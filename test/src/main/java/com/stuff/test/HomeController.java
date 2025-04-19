package com.stuff.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "homePage/index.html";
    }

    @RequestMapping("/Page1")
    public String page1(){
        return "Page1/Page1.html";
    }

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String name(@PathVariable String name){
        return "Hello " + name + "!";
    }

}
