package com.qualigy.payment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "paymentId")
    private int paymentId;
    @Column(name= "paymentStatus")
    private String paymentStatus;
    @Column(name= "transactionId")
    private String transactionId;
    @Column(name= "orderId")
    private int orderId;
    @Column(name= "amount")
    private int amount;

}
