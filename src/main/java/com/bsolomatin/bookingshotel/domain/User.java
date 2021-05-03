package com.bsolomatin.bookingshotel.domain;

import javax.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.StringJoiner;

@Entity
@Table(name="user")
public class User {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name="Id", unique = true, nullable = false)
    private Long Id;
    String firstName;
    String lastName;
//    @OneToMany(mappedBy = "user")
//    Set<Booking> bkSet = new HashSet<>();

    public User() { } //For JPA Entity

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setId(Long id) {
        this.Id = id;
    }

    @Id
    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "User [", "]");
        joiner.add("Id = " + Id).add("First name = " + firstName).add("Last name =" + lastName);
        return joiner.toString();
    }
}
