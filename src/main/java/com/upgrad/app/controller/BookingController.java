package com.upgrad.app.controller;

import com.upgrad.app.dto.TransactionDetailsDTO;
import com.upgrad.app.entity.BookingInfoEntity;
import com.upgrad.app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    private ResponseEntity<BookingInfoEntity> createBookingInfoEntity(@RequestBody BookingInfoEntity bookingInfoEntity) throws ParseException {
        return bookingService.createBookingInfoEntity(bookingInfoEntity);
    }

    @PostMapping("/booking/{bookingId}/booking")
    private TransactionDetailsDTO createTransaction(@PathVariable("bookingId") Integer bookingId, @RequestBody TransactionDetailsDTO transactionDetailsDTO){
        return bookingService.createTransaction(bookingId, transactionDetailsDTO);
    }
}
