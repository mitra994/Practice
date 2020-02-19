package com.betting.Controllers;

import com.betting.DaoService.TicketService;
import com.betting.DaoService.UserService;
import com.betting.Matches.Matches;
import com.betting.MyBet.Model.Player;
import com.betting.MyBet.Model.SoccerGame;
import com.betting.MyBet.Model.Ticket;
import com.betting.SportApi.GetJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/bet")
public class TicketController {

    @Autowired
    private UserService service;

    @Autowired
    private GetJson getJson;

    @Autowired
    private TicketService tService;

    private Player loggedInPlayer;

    private Matches[] matches;
    private Ticket ticket;

    private String startDate;
    private String endDate;

    private SoccerGame game;

    private int counter = 55;


    @RequestMapping(value="/getGames",method = RequestMethod.GET)
    private Matches[] getGames(@RequestParam String startDate, @RequestParam String endDate
    ,HttpSession session) throws IOException {

        matches = getJson.getGames(startDate,endDate);


        if(session.getAttribute("username")==null)
            session.setAttribute("username","nenadmit1");

        if(loggedInPlayer == null)
            loggedInPlayer = service.getPlayerByUsername((String) session.getAttribute("username"));

        counter = new SoccerGame().getGameId()+1;

        this.startDate = startDate;
        this.endDate = endDate;

        return matches;

    }

    @RequestMapping(value="/add",method = RequestMethod.GET)
    private String addGames(@RequestParam int id, @RequestParam String fix){

        if(ticket==null){
            ticket = new Ticket();
        }
        if(ticket.checkTicketPlayer()==null){
            ticket.setPlayer(loggedInPlayer);
        }

        if(ticket.getQuota() ==0){
            ticket.setQuota(2);
        }


        Matches match = new Matches();

        for (Matches m:matches){
            System.out.println(m.getId());
            System.out.println(id);
            if(m.getId()==id){
                match = m;
                break;
            }
        }

        if(match == null)
            return "Game not found!";

        game = new SoccerGame();
        game.setHomeTeam(match.getHomeTeam().getName());
        game.setAwayTime(match.getAwayTeam().getName());
        game.setFix_player(fix);
        game.setTicket(ticket);
        ticket.addGameToTicket(game);
        ticket.setQuota(ticket.getQuota() * 2);

        return "Game " + game + "sucessfuly added to the ticket!";
    }

    @RequestMapping(value="/checkTicket",method=RequestMethod.GET)
    public Ticket checkTicket(){

        return ticket;
    }

    @RequestMapping(value="/playTicket",method = RequestMethod.GET)
    public String playTicket(@RequestParam int ticketAmount){

        if(loggedInPlayer.getCredit() < ticketAmount)
            return "Not enough credit!";

        ticket.setPotentialWin(ticketAmount * ticket.getQuota());


        loggedInPlayer.addTicket().add(ticket);

        service.update(loggedInPlayer);

        return "Ticket processed sucessfully";

    }

    @RequestMapping(value="/newTicket", method = RequestMethod.GET)
    public void newTicket(){
        ticket = new Ticket();
    }


}
