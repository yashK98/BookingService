package com.upgrad.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Date;


@Entity
@Data
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
