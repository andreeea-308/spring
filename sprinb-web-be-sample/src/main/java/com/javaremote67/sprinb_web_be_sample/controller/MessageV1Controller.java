package com.javaremote67.sprinb_web_be_sample.controller;


import com.javaremote67.sprinb_web_be_sample.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageV1Controller {

    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/hello")
    public ResponseEntity<Message> sayHello() {
        return ResponseEntity
                .ok()
                .body(new Message("Hello World from my first GET request!!!"));
    }
    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/hi")
    public ResponseEntity<Message> sayHi() {
        return ResponseEntity
                .ok()
                .body(new Message("Hi"));
    }

}
