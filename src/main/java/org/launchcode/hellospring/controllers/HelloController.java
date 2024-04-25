package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action= 'hello' method='post'>" + //submit request to /hello
                "<input type='text' name='name' placeholder='Enter your name'>" +
                "<select name = 'language'>" +
                "<option value='french'>french</option>" +
                "<option value='english'>english</option>" +
                "<option value='arabic'>arabic</option>" +
                "<option value='italian'>italian</option>" +
                "<option value='spanish'>spanish</option>" +
                "</select>" +
                "<input type='submit' value ='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {
        if (language.equals("french")) {
            return "bonjour, " + name + "!";
        } else if (language.equals("english")) {
            return "Hello, " + name + "!";
        } else if (language.equals("arabic")) {
            return "Marhaba, " + name + "!";
        } else if (language.equals("italian")) {
            return "bonjourno, " + name + "!";
        } else return "Hola, " + name + "!";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

}
