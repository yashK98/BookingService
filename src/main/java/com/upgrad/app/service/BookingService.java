package com.upgrad.app.service;

import com.upgrad.app.dto.TransactionDetailsDTO;
import com.upgrad.app.entity.BookingInfoEntity;
import com.upgrad.app.exception.ExceptionResponse;
import com.upgrad.app.repo.BookingRepo;
import com.upgrad.app.util.BookingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import static com.upgrad.app.util.BookingConstants.*;


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

    public ResponseEntity<?> createTransaction(Integer transactionId, TransactionDetailsDTO transactionDetailsDTO){
        if(UPI.equalsIgnoreCase(transactionDetailsDTO.getPaymentMode()) || CARD.equalsIgnoreCase(transactionDetailsDTO.getPaymentMode())){
            Optional<BookingInfoEntity> response = bookingRepo.findById(transactionDetailsDTO.getBookingId());
            if(response.isEmpty()){
                return new ResponseEntity<>(new ExceptionResponse(INVALID_BOOKING_ID,400), HttpStatusCode.valueOf(400));
            }
            return new ResponseEntity<>(transactionDetailsDTO, HttpStatusCode.valueOf(201));
        }
        return new ResponseEntity<>(new ExceptionResponse(INVALID_PAYMENT_MODE, 400), HttpStatusCode.valueOf(400));
    }
}
