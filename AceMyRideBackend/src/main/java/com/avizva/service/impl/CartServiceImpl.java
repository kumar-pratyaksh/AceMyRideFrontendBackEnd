package com.avizva.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
		if (existingCartItem == null) {
			CartItem cartItem = new CartItem();
			cartItem.setOrderProcessed(false);
			Product product = productDao.view(productId);
			cartItem.setProduct(product);
			cartItem.setUserId(userId);
			if (quantity > product.getInStock())
				quantity = product.getInStock();
			cartItem.setQuantity(quantity);
			cartItem.setTotalPrice(quantity * product.getPrice());
			cartItem = cartDao.save(cartItem);
			return cartItem;
		}
		if (quantity > existingCartItem.getProduct().getInStock())
			quantity = existingCartItem.getProduct().getInStock();
		existingCartItem.setQuantity(quantity);
		existingCartItem.setTotalPrice(quantity * existingCartItem.getProduct().getPrice());
		return cartDao.update(existingCartItem);
	}

	@Override
	@Transactional
	public CartItem updateCartItem(CartItem cartItem) {
		CartItem savedCartItem = cartDao.get(cartItem.getId());
		if (cartItem.getQuantity() > savedCartItem.getProduct().getInStock())
			savedCartItem.setQuantity(savedCartItem.getProduct().getInStock());
		else
			savedCartItem.setQuantity(cartItem.getQuantity());
		savedCartItem.setTotalPrice(savedCartItem.getQuantity() * savedCartItem.getProduct().getPrice());
		return cartDao.update(savedCartItem);
	}

	public List<CartItem> getCartItemsForUser(int userId) {
		return cartDao.getForUser(userId).parallelStream().filter((item) -> !item.isOrderProcessed())
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public CartItem deleteCartItem(CartItem cartItem) {
		return cartDao.delete(cartItem);
	}

	@Override
	public void removeCartItemsForUser(int userId) {
		List<CartItem> cartItems = cartDao.getForUser(userId);
		cartItems.forEach(((cartItem) -> {
			cartItem.setOrderProcessed(true);
			cartDao.update(cartItem);
		}));
	}

}
