package com.javaremote67.sprinb_web_be_sample.controller;

import com.javaremote67.sprinb_web_be_sample.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MessageV2Controller {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v2/hello")
    public Message sayHello(){
        return new Message("Hello Worls again!");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v2/hi")
    public String sayHi() {
        return "Hi!";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v2/nothing")
    public void doNothing() {
        log.info("S-a executat requetul GET/api/v2/nothing cu succes!");
    }
}
