package com.bsolomatin.bookingshotel.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class RoomType {

    //TODO
    //Добавь опции  в виде связей @OneToMany @ManyToOne с типом комнаты, канал Follow the White rabbit

    @Id
    @org.springframework.data.annotation.Id
    private Long id;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.EAGER)
    private List<Room> roomList;
    //Select room r from room join booking b where bookingsdate// and r.roomtype = :roomType

    private String title;
    private int numberOfRooms;
    private double price;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name="type_features",
            joinColumns = { @JoinColumn(name="type_id") },
            inverseJoinColumns = { @JoinColumn(name="feature_id") })
    private Set<Feature> features = new HashSet<>();

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

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}
