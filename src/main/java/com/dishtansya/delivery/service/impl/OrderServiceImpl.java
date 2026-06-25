package com.dishtansya.delivery.service.impl;

import com.dishtansya.delivery.dto.OrderRequest;
import com.dishtansya.delivery.dto.OrderResponse;
import com.dishtansya.delivery.entity.Orders;
import com.dishtansya.delivery.entity.Product;
import com.dishtansya.delivery.exception.InsufficientStockException;
import com.dishtansya.delivery.repository.OrderRepository;
import com.dishtansya.delivery.repository.ProductRepository;
import com.dishtansya.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {

        Product product = productRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new InsufficientStockException(
                        "Failed to order this product due to unavailability of the stock"
                ));

        if (product.getStock() < orderRequest.getQuantity()) {
            throw new InsufficientStockException(
                    "Failed to order this product due to unavailability of the stock"
            );
        }

        product.setStock(product.getStock() - orderRequest.getQuantity());
        productRepository.save(product);

        Orders order = new Orders();
        order.setProductId(product.getId());
        order.setQuantity(orderRequest.getQuantity());
        orderRepository.save(order);

        return new OrderResponse("You have successfully ordered this product.");
    }
}