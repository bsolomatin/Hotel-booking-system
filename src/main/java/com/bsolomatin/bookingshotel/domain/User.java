package com.bsolomatin.bookingshotel.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="Id", unique = true, nullable = false)
    private Long id;
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
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "User [", "]");
        joiner.add("Id = " + id).add("First name = " + firstName).add("Last name =" + lastName);
        return joiner.toString();
    }
}
