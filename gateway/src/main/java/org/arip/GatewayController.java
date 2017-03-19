package org.arip;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Arip Hidayat on 3/19/2017.
 */
@Controller
public class GatewayController {

    @ResponseBody
    @RequestMapping("/user")
    public Map<String, Object> user(Principal user) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", user.getName());
        map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
        return map;
    }

    @RequestMapping("/login")
    public String login() {
        return "forward:/";
    }
}
