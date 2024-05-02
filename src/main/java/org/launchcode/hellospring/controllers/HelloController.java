package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value= "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Cole");
        names.add("Cole2");
        names.add("Cole3");
        model.addAttribute("names", names); //first is the value the template sees, and the second is the value that variable should have
        return "hello-list";
    }



//    //now lives at /hello/goodbye
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//
//    @GetMapping("form")
//    public String helloForm(){
//        return "form";
//    }

//    public static String createMessage(String name, String language) {
//       String languageGreeting;
//        if (language.equals("french")) {
//            languageGreeting = "Bonjour";
//        } else if (language.equals("english")) {
//            languageGreeting = "Hello";
//        } else if (language.equals("arabic")) {
//            languageGreeting = "Marhaba";
//        } else if (language.equals("italian")) {
//           languageGreeting = "Bonjorno";
//        } else {
//          languageGreeting = "Hola";
//        }
//        return "languageGreeting";
//    }
//
//    @RequestMapping(value="hello", method = RequestMethod.POST)
//    public String helloPost(@RequestParam String name, @RequestParam String language, Model model) {
//        if (name == null) {
//            name = "World";
//        }
//
//        String message = createMessage(name, language);
//        model.addAttribute("languageGreeting", message); // Corrected: message is an object
//        model.addAttribute("name", name); // Corrected: name is an object
//
//        return "languageGreeting";
//    }



}
