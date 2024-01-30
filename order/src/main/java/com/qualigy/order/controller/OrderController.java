package com.qualigy.order.controller;

import com.qualigy.order.dto.OrderRequest;
import com.qualigy.order.dto.OrderResponse;
import com.qualigy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/makeOrder")
    public OrderResponse makeOrder(@RequestBody OrderRequest request){
        return orderService.saveOrder(request);
    }
//    @GetMapping
//    public List<Order> fetchOrders(){
//        return  orderService.fetchOrders();
//    }
//    @GetMapping("/{id}")
//    public Order fetchOrderById(@PathVariable int id) {
//        return orderService.fetchOrderById(id);
//    }
}
