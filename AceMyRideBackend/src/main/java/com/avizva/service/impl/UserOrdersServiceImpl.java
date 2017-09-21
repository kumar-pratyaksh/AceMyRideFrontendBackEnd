package com.avizva.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.UserOrdersDao;
import com.avizva.model.Address;
import com.avizva.model.CartItem;
import com.avizva.model.Payment;
import com.avizva.model.UserOrders;
import com.avizva.pojo.OrderStatus;
import com.avizva.service.AddressService;
import com.avizva.service.CartService;
import com.avizva.service.PaymentService;
import com.avizva.service.ProductService;
import com.avizva.service.UserOrdersService;

@Service
public class UserOrdersServiceImpl implements UserOrdersService {

	@Autowired
	private UserOrdersDao userOrdersDao;

	@Autowired
	private AddressService addressService;

	@Autowired
	private CartService cartService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ProductService productService;

	@Override
	public UserOrders saveOrder(int userId, Address shippingAddress, boolean isNew) {
		UserOrders orders = new UserOrders();
		orders.setUserId(userId);
		if (isNew) {
			shippingAddress.setUserId(userId);
			shippingAddress = addressService.saveAddress(shippingAddress);
		}
		orders.setShippingAddressId(shippingAddress.getId());
		orders.setItems(cartService.getCartItemsForUser(userId));
		orders.setOrderStatus(OrderStatus.IN_PROCESS);
		orders.setOrderAmount(getOrderAmount(orders.getItems()));
		cartService.removeCartItemsForUser(userId);
		return userOrdersDao.save(orders);
	}

	private double getOrderAmount(List<CartItem> orderItems) {
		return orderItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
	}

	@Override
	public UserOrders updateOrder(int orderId, Address shippingAddress) {
		UserOrders savedOrder= userOrdersDao.get(orderId);
		savedOrder.setShippingAddress(shippingAddress);
		return userOrdersDao.update(savedOrder);
	}

	@Override
	public UserOrders updateOrderAfterPayment(int orderId, Address billingAddress, Payment payment, boolean isNew) {
		UserOrders orders = userOrdersDao.get(orderId);
		payment = paymentService.savePayment(payment);
		orders.setPayment(payment);
		if (isNew) {
			billingAddress.setUserId(orders.getUserId());
			billingAddress = addressService.saveAddress(billingAddress);
		} else if (billingAddress == null) {
			billingAddress = orders.getShippingAddress();
		}
		productService.removeProductFromStock(orders.getItems());
		orders.setOrderAmount(getOrderAmount(orders.getItems()));
		orders.setBillingAddressId(billingAddress.getId());
		orders.setOrderDate(new Date());
		return userOrdersDao.save(orders);
	}

}
