package com.betting.Controllers;

import com.betting.DaoService.TicketService;
import com.betting.DaoService.UserService;
import com.betting.MyBet.Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    private TicketService tService;

    @PostMapping
    private String authenticateUser(@RequestParam String username,@RequestParam String password, HttpSession session){

        Player player;
        try{
            player = userService.getPlayerByUsername(username);
        }catch (NoResultException e){
            return "Username not found!";
        }

        if (!(player.getPassword().equals(password)))
            return "Wrong password!";

        session.setAttribute("username",player.getUsername());

        return "Welcome" + player.getUsername() + " " + tService.getLastId();



    }



}
