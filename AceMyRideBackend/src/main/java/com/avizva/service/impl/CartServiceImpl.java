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
	public List<CartItem> addToCart(int productId, int userId, int quantity) {
		CartItem existingCartItem = cartDao.getByProductIDUserId(productId, userId);
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
					cartDao.save(cartItem);
				} else {
					int available = product.getInStock();
					product.setInStock(0);
					product = productDao.update(product);
					cartItem.setProduct(product);
					cartItem.setQuantity(available);
					cartItem.setUserId(userId);
					cartItem.setTotalPrice(available * product.getPrice());
					cartDao.save(cartItem);
				}
			} else {
				cartItem.setProduct(product);
				cartItem.setQuantity(0);
				cartItem.setUserId(userId);
				cartItem.setTotalPrice(0.0d);
				cartDao.save(cartItem);
			}

		} else {
			Product product = existingCartItem.getProduct();
			int available = product.getInStock();
			if (available == 0) {
				return cartDao.getForUser(userId);
			} else if (available > quantity) {
				product.setInStock(available - quantity);
				productDao.update(product);
				existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
				existingCartItem.setTotalPrice(existingCartItem.getQuantity() * product.getPrice());
				cartDao.update(existingCartItem);
			} else {
				product.setInStock(0);
				productDao.update(product);
				existingCartItem.setQuantity(existingCartItem.getQuantity() + available);
				existingCartItem.setTotalPrice(existingCartItem.getQuantity() * product.getPrice());
				cartDao.update(existingCartItem);
			}
		}
		return cartDao.getForUser(userId);
	}

	@Override
	@Transactional
	public List<CartItem> updateCartItem(CartItem cartItem) {
		CartItem savedCartItem = cartDao.get(cartItem.getId());
		int diff = savedCartItem.getQuantity() - cartItem.getQuantity();
		if (diff == 0) {
			return cartDao.getForUser(cartItem.getUserId());
		} else if (diff > 0) {
			Product product = savedCartItem.getProduct();
			product.setInStock(product.getInStock() + diff);
			product = productDao.update(product);
			savedCartItem.setProduct(product);
			savedCartItem.setQuantity(cartItem.getQuantity());
			savedCartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());
			cartDao.update(savedCartItem);
			return cartDao.getForUser(savedCartItem.getUserId());
		} else {
			Product product = savedCartItem.getProduct();
			int available = product.getInStock();
			if (available <= 0) {
				return cartDao.getForUser(savedCartItem.getUserId());
			} else {
				if (available >= diff) {
					product.setInStock(available - diff);
					product = productDao.update(product);
					savedCartItem.setQuantity(savedCartItem.getQuantity() + diff);
					savedCartItem.setTotalPrice(savedCartItem.getQuantity() * product.getPrice());
					cartDao.update(savedCartItem);
					return cartDao.getForUser(savedCartItem.getUserId());
				} else {
					product.setInStock(0);
					product = productDao.update(product);
					savedCartItem.setQuantity(savedCartItem.getQuantity() + available);
					savedCartItem.setTotalPrice(savedCartItem.getQuantity() * product.getPrice());
					cartDao.update(savedCartItem);
					return cartDao.getForUser(savedCartItem.getUserId());
				}
			}
		}

	}

	public List<CartItem> getCartItemsForUser(int userId) {
		return cartDao.getForUser(userId);
	}

}
