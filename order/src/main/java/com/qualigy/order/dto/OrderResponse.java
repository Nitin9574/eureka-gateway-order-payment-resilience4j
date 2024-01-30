package com.qualigy.order.dto;


import com.qualigy.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Order order;
    private String transactionId;
    private int amount;
    private String message;

}
