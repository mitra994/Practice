package com.betting.MyBet.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="ticket")
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private int ticketId;

    @Column(name="quota")
    private double quota;

    @Column(name="potential_win")
    private double potentialWin;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name="player_fk")
    @JsonBackReference
    private Player playerr;

    @OneToMany(mappedBy = "ticket",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonManagedReference
    private List<SoccerGame> sgames = new ArrayList<>();


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public double getPotentialWin() {
        return potentialWin;
    }

    public void setPotentialWin(double potentialWin) {
        this.potentialWin = potentialWin;
    }

    public Player returnOwner() {
        return playerr;
    }

    public void setPlayer(Player player) {
        this.playerr = player;
    }

    public Player checkTicketPlayer(){
        return this.playerr;
    }

    public void addGameToTicket(SoccerGame game) {
        sgames.add(game);
    }


}
