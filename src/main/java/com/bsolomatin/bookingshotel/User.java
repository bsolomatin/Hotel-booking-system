package com.bsolomatin.bookingshotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String firstName;
    String lastName;
//    @OneToMany(mappedBy = "user")
//    Set<Booking> bkSet = new HashSet<>();

    public User() { } //For JPA Entity

    public User(Long id, String firstName, String lastName) {
        this.id = id;
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
