package com.theironyard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by earlbozarth on 11/9/15.
 */

//Rest Controller helps convert to Json
@RestController()
public class HelloSpringJsonController {

    @RequestMapping("/person.json")
    public Person person(
            //Passing in queryParams (w/ default values)
            @RequestParam(defaultValue = "Bob") String name,
            @RequestParam(defaultValue = "Detroit") String city,
            @RequestParam(defaultValue = "55")Integer age){

        return new Person(name, city, age);
        //return new Person("Bob", "Charleston", 35);
    }


}
