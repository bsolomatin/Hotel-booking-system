package com.bsolomatin.bookingshotel.domain;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.StringJoiner;
@Entity
public class Room {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    //@Column(name="Id", unique = true, nullable = false)"
//
//    @Min(value = 1, message = "Минимальный этаж - 1")
//    private int flat;
//
//    @Min(value = 1, message = "Минимум одна кровать")
//    private int numberOfBed;
//
//    @Min(value = 1000, message = "Минимальный прайс 1000")
//    private int price;
//    @OneToMany(mappedBy = "room")
//    private Set<Booking> bookingSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private RoomType roomType;

    public Room() { } //for JPA

//    public Room(int flat, int numberOfBed, int price, int roomTypeId) {
//        this.flat = flat;
//        this.numberOfBed = numberOfBed;
//        this.price = price;
//    }

    public Room(RoomType roomType) {
        this.roomType = roomType;
    }

//    @Override
//    public String toString() {
//        StringJoiner joiner = new StringJoiner("|", "Room [", "]");
//        joiner.add("Id =" + Id).add("Flat = " + flat).add("Number of bed = " + numberOfBed).add("Price = " + price);
//        return joiner.toString();
//    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }

//    public int getFlat() {
//        return flat;
//    }
//
//    public void setFlat(int flat) {
//        this.flat = flat;
//    }
//
//    public int getNumberOfBed() {
//        return numberOfBed;
//    }
//
//    public void setNumberOfBed(int numberOfBed) {
//        this.numberOfBed = numberOfBed;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }


    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
