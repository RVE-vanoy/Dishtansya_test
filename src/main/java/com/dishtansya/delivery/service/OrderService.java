package com.dishtansya.delivery.service;

import com.dishtansya.delivery.dto.OrderRequest;
import com.dishtansya.delivery.dto.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);
}