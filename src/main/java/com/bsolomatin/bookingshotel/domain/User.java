package com.bsolomatin.bookingshotel.domain;

import javax.persistence.*;
import org.springframework.data.annotation.Id;
import java.util.Set;
import java.util.StringJoiner;

@Entity
//@Table(name = "\"user\"")
@Table(name="usr")
public class User {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name="Id", unique = true, nullable = false)
    private Long Id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    @Enumerated(EnumType.STRING)
    Role roles;



    public User() { } //For JPA Entity

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("|", "User [", "]");
        joiner.add("Id = " + Id).add("Username = " + username);
        return joiner.toString();
    }
}
