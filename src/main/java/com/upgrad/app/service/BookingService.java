package com.upgrad.app.service;

import com.upgrad.app.dto.TransactionDetailsDTO;
import com.upgrad.app.entity.BookingInfoEntity;
import com.upgrad.app.repo.BookingRepo;
import com.upgrad.app.util.BookingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;


@Slf4j
@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public ResponseEntity<BookingInfoEntity> createBookingInfoEntity(BookingInfoEntity bookingInfoEntity) throws ParseException {
        bookingInfoEntity.setRoomNumbers(this.getRooms(bookingInfoEntity.getNumOfRooms()));
        bookingInfoEntity.setRoomPrice(this.getRoomPrice(bookingInfoEntity.getNumOfRooms(), bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate()));
        bookingInfoEntity.setBookedOn(new Date());
        bookingInfoEntity.setTransactionId(0);
        bookingInfoEntity = bookingRepo.save(bookingInfoEntity);
        return new ResponseEntity<>(bookingInfoEntity, HttpStatusCode.valueOf(201));
    }

    private String getRooms(Integer numberOfRooms){
        return String.join(", ", BookingUtil.getRandomNumbers(numberOfRooms));
    }

    private Integer getRoomPrice(Integer numberOfRooms, Date fromDate, Date toDate) throws ParseException {
        return 1000*numberOfRooms*BookingUtil.diffDate(fromDate, toDate);
    }

    public TransactionDetailsDTO createTransaction(Integer transactionId, TransactionDetailsDTO transactionDetailsDTO){
        return transactionDetailsDTO;
    }
}
