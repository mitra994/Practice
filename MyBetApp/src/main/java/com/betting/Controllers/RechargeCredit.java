package com.betting.Controllers;

import com.betting.DaoService.UserService;
import com.betting.MyBet.Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/credit")
public class RechargeCredit {

    @Autowired
    private UserService service;

    private Player logedInPlayer;

    @GetMapping
    public String checkCredit(HttpSession session){
        if(logedInPlayer == null){
            logedInPlayer = service.getPlayerByUsername((String) session.getAttribute("username"));
        }


        return "Your current credit is: " + logedInPlayer.getCredit();

    }

    @RequestMapping(value="/addCredit",method= RequestMethod.POST)
    public void recharge(@RequestParam double credit, HttpServletResponse response) throws IOException {
        logedInPlayer.setCredit(logedInPlayer.getCredit()+credit);
        service.update(logedInPlayer);

        response.sendRedirect("/credit");
    }

}
