package com.bsolomatin.bookingshotel.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoomType {

    @Id
    @org.springframework.data.annotation.Id
    private Long id;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.EAGER)
    private List<Room> roomList;
    private String title;
    private int numberOfRooms;
    private double price;

    public RoomType() {} // for JPA

    public RoomType(String title, int numberOfRooms, double price) {

        this.title = title;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
