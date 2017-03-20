package org.arip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Arip Hidayat on 3/20/2017.
 */
@Controller
public class AppController {

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String forward() {
        return "forward:/";
    }

    @ResponseBody
    @RequestMapping(value = "user")
    public Principal user(Principal user) {
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "hello")
    public Map<String, Object> hello() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello Spring Boot and AngularJS!");
        return model;
    }
}
