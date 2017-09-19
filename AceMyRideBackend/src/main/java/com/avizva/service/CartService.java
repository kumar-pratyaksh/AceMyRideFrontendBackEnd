package com.avizva.service;

import java.util.List;

import com.avizva.model.CartItem;

public interface CartService {

	public CartItem addToCart(int productId, int userId, int quantity);

	public CartItem updateCartItem(CartItem cartItem);

	public CartItem deleteCartItem(CartItem cartItem);

	public List<CartItem> getCartItemsForUser(int userId);

}
