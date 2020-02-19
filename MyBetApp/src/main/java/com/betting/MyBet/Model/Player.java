package com.betting.MyBet.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="player")

@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="player_id")
    private int playerId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="won_amount")
    private double wonAmount;

    @Column(name="credit")
    private double credit;

    @OneToMany(mappedBy = "playerr",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonManagedReference
    private List<Ticket> tickets = new ArrayList<>();

    public Player(){

    }

    public Player(String username,String password){
        this.username = username;
        this.password = password;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public List<Ticket> addTicket() {
        return tickets;
    }

    public double getWonAmount() {
        return wonAmount;
    }

    public void setWonAmount(double wonAmount) {
        this.wonAmount = wonAmount;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}


