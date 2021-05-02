package com.bsolomatin.bookingshotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    int flat;
    int numberOfBed;
    int price;
//    @OneToMany(mappedBy = "room")
//    private Set<Booking> bookingSet = new HashSet<>();

    public Room() { } //for JPA

    public Room(Long id, int flat, int numberOfBed, int price) {
        this.id = id;
        this.flat = flat;
        this.numberOfBed = numberOfBed;
        this.price = price;
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
        StringJoiner joiner = new StringJoiner("|", "Room [", "]");
        joiner.add("Id =" + id).add("Flat = " + flat).add("Number of bed = " + numberOfBed).add("Price = " + price);
        return joiner.toString();
    }
}
