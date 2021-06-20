package com.bsolomatin.bookingshotel.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Entity
@Table(name="photos")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Lob @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;
    private String imageBase64;
    @ManyToOne
    private RoomType rt;

    public Photos() {} //FOR JPA

    public Photos(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
