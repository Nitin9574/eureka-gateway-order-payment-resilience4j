package com.qualigy.payment.controller;

import com.qualigy.payment.entity.Payment;
import com.qualigy.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    Logger logger = LoggerFactory.getLogger(PaymentController.class);
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        logger.info("Start of doPayment method inside PaymentController :: "+payment);
        return paymentService.doPayment(payment);
    }

    // for gateway impl
    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
        logger.info("Start of findPaymentHistoryByOrderId method inside PaymentController  with order id:: "+orderId);
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }

}
