package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jhj on 2016-05-10.
 */
@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String home2(){
        return "home2";
    }
}
