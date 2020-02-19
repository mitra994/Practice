package com.betting.MyBet.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name="SoccerGame")
@Table(name = "soccer_game")
public class SoccerGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_id")
    private int gameId;

    @Column (name="home_team")
    private String homeTeam;
    @Column (name="away_team")
    private String awayTime;

    @Column(name="fix_played")
    private String fix_played;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="ticket_fk",nullable = false)
    @JsonBackReference
    private Ticket ticket;

    public SoccerGame(){

    }


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTime() {
        return awayTime;
    }

    public void setAwayTime(String awayTime) {
        this.awayTime = awayTime;
    }


    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getFix_played() {
        return fix_played;
    }

    public void setFix_player(String fix_played) {
        this.fix_played = fix_played;
    }
}
