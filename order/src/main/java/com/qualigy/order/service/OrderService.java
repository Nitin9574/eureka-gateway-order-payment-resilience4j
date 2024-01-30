package com.qualigy.order.service;

import com.qualigy.order.dto.OrderRequest;
import com.qualigy.order.dto.OrderResponse;
import com.qualigy.order.dto.Payment;
import com.qualigy.order.entity.Order;
import com.qualigy.order.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Retry(name = "ORDER-SERVICE", fallbackMethod = "paymentDoneAndOrderPlaced")
    //@CircuitBreaker(name = "ORDER-SERVICE", fallbackMethod = "paymentDoneAndOrderPlaced")
    public OrderResponse saveOrder(OrderRequest request) {
        String resMessage = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        System.out.println("Trying again");

        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);

        resMessage = paymentResponse.getPaymentStatus().equals("success") ? "payment is sucessful,order placed" : "failed payment";

        orderRepository.save(order);
        return new OrderResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), resMessage);
    }

    public OrderResponse paymentDoneAndOrderPlaced(Exception e) {
        return new OrderResponse(new Order(999, "Order placed", 1, 15000), "TNX12345", 15000, "payment processing complete and order placed");
    }
}
