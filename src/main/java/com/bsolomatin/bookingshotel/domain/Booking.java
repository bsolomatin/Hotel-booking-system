package com.bsolomatin.bookingshotel.domain;


import javax.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.StringJoiner;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name="Id", unique = true, nullable = false)
    private Long Id;
    private boolean isConfirm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;
    private Integer userId;
    private Integer roomId;

    //    @ManyToOne
//    private Room room;
//    @ManyToOne
//    private User user;

    public Booking() { } //For JPA Entity;

    public Booking(LocalDate checkIn, LocalDate checkOut, Integer userId, Integer roomId) {
        isConfirm = true;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.userId = userId;
        this.roomId = roomId;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    @Id
    public Long getId() {
        return Id;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "Booking [", "]");
        joiner.add("Room id =" + roomId).add("Check in date = " + checkIn).add("Check out date = "+checkOut).add("Confirm = " + isConfirm);
        return joiner.toString();
    }
}
