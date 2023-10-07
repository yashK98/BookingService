package com.upgrad.app.controller;

import com.upgrad.app.entity.BookingInfoEntity;
import com.upgrad.app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    private BookingInfoEntity createBookingInfoEntity(@RequestBody BookingInfoEntity bookingInfoEntity){
        return bookingService.createBookingInfoEntity(bookingInfoEntity);
    }
}
