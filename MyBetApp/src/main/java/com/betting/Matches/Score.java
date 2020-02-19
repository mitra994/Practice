package com.betting.Matches;

public class Score {

    private String winner;
    private String duration;
    private FullTime fullTime;
    private HalfTime halfTime;
    private ExtraTime extraTime;
    private Penalties penalties;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public FullTime getFullTime() {
        return fullTime;
    }

    public void setFullTime(FullTime fullTime) {
        this.fullTime = fullTime;
    }


    public HalfTime getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(HalfTime halfTime) {
        this.halfTime = halfTime;
    }

    public ExtraTime getExtraTime() {
        return extraTime;
    }

    public Penalties getPenalties() {
        return penalties;
    }

    public void setPenalties(Penalties penalties) {
        this.penalties = penalties;
    }

    public void setExtraTime(ExtraTime extraTime) {
        this.extraTime = extraTime;


    }

    public class FullTime{

        private int homeTeam;
        private int awayTeam;

        public FullTime(){

        }

        public int getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(int homeTeam) {
            this.homeTeam = homeTeam;
        }

        public int getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(int awayTeam) {
            this.awayTeam = awayTeam;
        }
    }
   public  class HalfTime{

        public HalfTime(){

        }

        private int homeTeam;
        private int awayTeam;

        public int getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(int homeTeam) {
            this.homeTeam = homeTeam;
        }

        public int getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(int awayTeam) {
            this.awayTeam = awayTeam;
        }
    }
    public class ExtraTime{

        public ExtraTime(){

        }

        private int homeTeam;
        private int awayTeam;

        public int getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(int homeTeam) {
            this.homeTeam = homeTeam;
        }

        public int getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(int awayTeam) {
            this.awayTeam = awayTeam;
        }
    }
    public class Penalties{

        private int homeTeam;
        private int awayTeam;

        public Penalties(){

        }

        public int getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(int homeTeam) {
            this.homeTeam = homeTeam;
        }

        public int getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(int awayTeam) {
            this.awayTeam = awayTeam;
        }
    }




}
