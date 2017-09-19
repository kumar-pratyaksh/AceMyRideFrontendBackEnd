package com.avizva.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.dao.CartDao;
import com.avizva.dao.ProductDao;
import com.avizva.model.CartItem;
import com.avizva.model.Product;
import com.avizva.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	private static final Logger LOGGER = LogManager.getLogger(CartServiceImpl.class);

	@Autowired
	private CartDao cartDao;

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public CartItem addToCart(int productId, int userId, int quantity) {
		CartItem existingCartItem = cartDao.getByProductIDUserId(productId, userId);
		CartItem savedCartItem = null;
		if (existingCartItem == null) {
			LOGGER.info("No existing cart item exists " + userId);
			Product product = productDao.view(productId);
			CartItem cartItem = new CartItem();
			if (product.getInStock() > 0) {
				if (product.getInStock() >= quantity) {
					product.setInStock(product.getInStock() - quantity);
					product = productDao.update(product);
					cartItem.setProduct(product);
					cartItem.setQuantity(quantity);
					cartItem.setUserId(userId);
					cartItem.setTotalPrice(quantity * product.getPrice());
					savedCartItem = cartDao.save(cartItem);
				} else {
					int available = product.getInStock();
					product.setInStock(0);
					product = productDao.update(product);
					cartItem.setProduct(product);
					cartItem.setQuantity(available);
					cartItem.setUserId(userId);
					cartItem.setTotalPrice(available * product.getPrice());
					savedCartItem = cartDao.save(cartItem);
				}
			} else {
				cartItem.setProduct(product);
				cartItem.setQuantity(0);
				cartItem.setUserId(userId);
				cartItem.setTotalPrice(0.0d);
				savedCartItem = cartDao.save(cartItem);
			}

		} else {
			Product product = existingCartItem.getProduct();
			int available = product.getInStock();
			if (available == 0) {
				return existingCartItem;
			} else if (available > quantity) {
				product.setInStock(available - quantity);
				productDao.update(product);
				existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
				existingCartItem.setTotalPrice(existingCartItem.getQuantity() * product.getPrice());
				savedCartItem = cartDao.update(existingCartItem);
			} else {
				product.setInStock(0);
				productDao.update(product);
				existingCartItem.setQuantity(existingCartItem.getQuantity() + available);
				existingCartItem.setTotalPrice(existingCartItem.getQuantity() * product.getPrice());
				savedCartItem = cartDao.update(existingCartItem);
			}
		}
		return savedCartItem;
	}

	@Override
	@Transactional
	public CartItem updateCartItem(CartItem cartItem) {
		CartItem savedCartItem = cartDao.get(cartItem.getId());
		int diff = savedCartItem.getQuantity() - cartItem.getQuantity();
		if (diff == 0) {
			return savedCartItem;
		} else if (diff > 0) {
			Product product = savedCartItem.getProduct();
			product.setInStock(product.getInStock() + diff);
			product = productDao.update(product);
			savedCartItem.setProduct(product);
			savedCartItem.setQuantity(cartItem.getQuantity());
			savedCartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());
			savedCartItem = cartDao.update(savedCartItem);

		} else {
			Product product = savedCartItem.getProduct();
			int available = product.getInStock();
			if (available <= 0) {
				return savedCartItem;
			} else {
				if (available >= -diff) {
					product.setInStock(available + diff);
					product = productDao.update(product);
					savedCartItem.setQuantity(savedCartItem.getQuantity() - diff);
					savedCartItem.setTotalPrice(savedCartItem.getQuantity() * product.getPrice());
					savedCartItem = cartDao.update(savedCartItem);
				} else {
					product.setInStock(0);
					product = productDao.update(product);
					savedCartItem.setQuantity(savedCartItem.getQuantity() + available);
					savedCartItem.setTotalPrice(savedCartItem.getQuantity() * product.getPrice());
					savedCartItem = cartDao.update(savedCartItem);
				}
			}
		}
		return savedCartItem;
	}

	public List<CartItem> getCartItemsForUser(int userId) {
		return cartDao.getForUser(userId);
	}

	@Override
	@Transactional
	public CartItem deleteCartItem(CartItem cartItem) {
		CartItem savedCartItem = cartDao.get(cartItem.getId());
		Product product = savedCartItem.getProduct();
		product.setInStock(product.getInStock() + savedCartItem.getQuantity());
		productDao.update(product);
		return cartDao.delete(savedCartItem);
	}

}
