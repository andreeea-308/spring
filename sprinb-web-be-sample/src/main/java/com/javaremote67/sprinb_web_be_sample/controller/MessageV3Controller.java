package com.javaremote67.sprinb_web_be_sample.controller;


import com.javaremote67.sprinb_web_be_sample.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageV3Controller {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v3/hello/{id}")
    public Message sayHelloWithId(@PathVariable(name = "id") final Integer id) {
        return new Message("Hello world" + id);
    }

}
