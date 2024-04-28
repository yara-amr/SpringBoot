package org.example.Controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String showLogin(){

        return "login";
    }

//    @RequestMapping("/confirm")
//    public String submit(HttpServletRequest request, Model model){
//        String username = request.getParameter("username");
//        int age = Integer.valueOf(request.getParameter("age"));
//        System.out.println("username"+username);
//        model.addAttribute("message", "hello "+username+", you are now logged in!");
//        model.addAttribute("message2", "you will be "+(age+1)+" in 2 months");
//        return "confirmation";
//    }


    @RequestMapping("/confirm")
    public String submit(@RequestParam("username") String username, @RequestParam("age") int age, Model model){
        model.addAttribute("message", "hello "+username+", you are now logged in!");
        model.addAttribute("message2", "you will be "+(age+1)+" in 2 months");
        return "confirmation";
    }




}
