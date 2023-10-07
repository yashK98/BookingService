package com.upgrad.app.service;

import com.upgrad.app.entity.BookingInfoEntity;
import com.upgrad.app.util.BookingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Slf4j
@Service
public class BookingService {

    public BookingInfoEntity createBookingInfoEntity(BookingInfoEntity bookingInfoEntity){
        bookingInfoEntity.setRoomNumbers(this.getRooms(bookingInfoEntity.getNumOfRooms()));
        bookingInfoEntity.setRoomPrice(this.getRoomPrice(bookingInfoEntity.getNumOfRooms(), bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate()));
        return bookingInfoEntity;
    }

    private String getRooms(Integer numberOfRooms){
        return String.join(", ", BookingUtil.getRandomNumbers(numberOfRooms));
    }

    private Integer getRoomPrice(Integer numberOfRooms, Date fromDate, Date toDate){
        // Formula 1000 * numberOfRoom * (totalNumberOfDays :: toDate - fromDate)
        return 1000*numberOfRooms;
    }
}
