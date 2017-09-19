package com.avizva.dao;

import java.util.List;

import com.avizva.model.CartItem;

public interface CartDao {

	public CartItem save(CartItem cartItem);

	public CartItem update(CartItem cartItem);

	public CartItem delete(CartItem cartItem);

	public CartItem get(int id);

	public List<CartItem> getForUser(int userId);

	public CartItem getByProductIDUserId(int productId, int userId);

}
