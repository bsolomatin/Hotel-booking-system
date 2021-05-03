package com.bsolomatin.bookingshotel.domain;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.StringJoiner;
@Entity
public class Room {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    //@Column(name="Id", unique = true, nullable = false)
    private int flat;
    private int numberOfBed;
    private int price;
//    @OneToMany(mappedBy = "room")
//    private Set<Booking> bookingSet = new HashSet<>();

    public Room() { } //for JPA

    public Room(int flat, int numberOfBed, int price) {
        this.flat = flat;
        this.numberOfBed = numberOfBed;
        this.price = price;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "Room [", "]");
        joiner.add("Id =" + Id).add("Flat = " + flat).add("Number of bed = " + numberOfBed).add("Price = " + price);
        return joiner.toString();
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
