package com.bsolomatin.bookingshotel.domain;

import org.joda.time.DateMidnight;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import javax.persistence.*;
import org.springframework.data.annotation.Id;
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
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Interval interval;
    private Integer userId;
    private Integer roomId;

    //    @ManyToOne
//    private Room room;
//    @ManyToOne
//    private User user;

    public Booking() { } //For JPA Entity;

    public Booking(LocalDate checkIn, LocalDate checkOut, boolean isConfirm) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isConfirm = isConfirm;
        interval = new Interval(new DateMidnight(checkIn), new DateMidnight(checkOut));
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

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "Booking [", "]");
        joiner.add("Id =" + Id).add("Check in date = " + checkIn).add("Check out date = "+checkOut).add("Confirm = " + isConfirm);
        return joiner.toString();
    }
}
