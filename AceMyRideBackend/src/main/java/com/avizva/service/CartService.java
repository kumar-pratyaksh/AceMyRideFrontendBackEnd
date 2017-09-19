package com.avizva.service;

import java.util.List;

import com.avizva.model.CartItem;

public interface CartService {

	public List<CartItem> addToCart(int productId, int userId, int quantity);

	public List<CartItem> updateCartItem(CartItem cartItem);

	public List<CartItem> getCartItemsForUser(int userId);

}
