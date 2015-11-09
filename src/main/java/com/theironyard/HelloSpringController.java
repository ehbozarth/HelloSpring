package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by earlbozarth on 11/9/15.
 */
@Controller
public class HelloSpringController {

    @RequestMapping("/person")//Maps to person.html
    //help read in parameters from query
    public String person(
            Model model,
            @RequestParam(defaultValue = "Bob") String name,
            @RequestParam(defaultValue = "Charleston") String city,
            @RequestParam(defaultValue = "100") Integer age
    ){
        //Person tempPerson = new Person("Duke", "Cinnaminson", 28);
        Person tempPerson = new Person(name, city, age);
        model.addAttribute("person", tempPerson);
        return "person";
    }//End of /person

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");//Casting object to string
        model.addAttribute("username", username);
        return "home";//return to "home.html"
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username){
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return "redirect:/";
    }

}//End of HelloSpringController
