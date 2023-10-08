package com.upgrad.app.dto;

import lombok.Data;

@Data
public class TransactionDetailsDTO {
    private Integer transactionId;
    private String paymentMode;
    private Integer bookingId;
    private String upiId;
    private String cardNumber;
}
