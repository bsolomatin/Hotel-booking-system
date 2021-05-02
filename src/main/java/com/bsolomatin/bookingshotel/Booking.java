package com.bsolomatin.bookingshotel;

import org.joda.time.DateMidnight;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    boolean isConfirm;
    LocalDate checkIn;
    LocalDate checkOut;
    Interval interval;
//    @ManyToOne
//    private Room room;
//    @ManyToOne
//    private User user;

    public Booking() { } //For JPA Entity;

    public Booking(Long id, LocalDate checkIn, LocalDate checkOut, boolean isConfirm) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isConfirm = isConfirm;
        interval = new Interval(new DateMidnight(checkIn), new DateMidnight(checkOut));
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "Booking [", "]");
        joiner.add("Id =" + id).add("Check in date = " + checkIn).add("Check out date = "+checkOut).add("Confirm = " + isConfirm);
        return joiner.toString();
    }
}
