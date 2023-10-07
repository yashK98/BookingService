package com.upgrad.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    @Column(name = "bookingId")
    private Integer id;

    @Column(name = "fromDate")
    private Date fromDate;

    @Column(name = "toDate")
    private Date toDate;

    @Column(name = "aadharNumber")
    private String aadharNumber;

    @Column(name = "numOfRooms")
    private Integer numOfRooms;

    @Column(name = "roomNumbers")
    private String roomNumbers;

    @Column(name = "roomPrice")
    private Integer roomPrice;

    @Column(name = "transactionId")
    private Integer transactionId;

    @Column(name = "bookedOn")
    private Date bookedOn;
}
