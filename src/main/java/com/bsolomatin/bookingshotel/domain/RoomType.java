package com.bsolomatin.bookingshotel.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class RoomType implements Serializable {

    //TODO
    //Добавь опции  в виде связей @OneToMany @ManyToOne с типом комнаты, канал Follow the White rabbit

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "roomType", fetch = FetchType.EAGER)
    private List<Room> roomList;
    //Select room r from room join booking b where bookingsdate// and r.roomtype = :roomType
    private String title;
    private int numberOfRooms;
    private double price;
    private String description;
    @JsonManagedReference
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name="type_features",
            joinColumns = { @JoinColumn(name="type_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name="feature_id", referencedColumnName = "id") })
    private Set<Feature> features = new HashSet<>();
    @OneToMany(mappedBy = "rt")
    private List<Photos> photos;
    public RoomType() {} // for JPA

    public RoomType(String title, int numberOfRooms, double price, String description) {
        this.title = title;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }


    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", roomList=" + roomList +
                ", title='" + title + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                ", features=" + features +
                '}';
    }
}
