package com.bsolomatin.bookingshotel.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    @Column(unique = true)
    private String description;
    @ManyToMany(mappedBy = "features")
    private Set<RoomType> roomTypeSet = new HashSet<>();

    public Feature() {} //For JPA

    public Feature(String icon, String description) {
        this.icon = icon;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
