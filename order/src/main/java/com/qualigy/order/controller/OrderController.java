package com.qualigy.order.controller;

import com.qualigy.order.dto.OrderRequest;
import com.qualigy.order.dto.OrderResponse;
import com.qualigy.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @PostMapping("/makeOrder")
    public OrderResponse makeOrder(@RequestBody OrderRequest request){
        logger.info("Order request details :"+request.getOrder()+ "  " +request.getPayment());
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
