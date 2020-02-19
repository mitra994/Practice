package com.betting.Controllers;

import com.betting.DaoService.UserService;
import com.betting.MyBet.Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    private String registerUser(@RequestParam String username,@RequestParam String password){


        try{
            userService.save(new Player(username,password));

        }catch(Exception e){
            return "Username already exists!";
        }

        return "Sucessfuly registered";

    }

}
