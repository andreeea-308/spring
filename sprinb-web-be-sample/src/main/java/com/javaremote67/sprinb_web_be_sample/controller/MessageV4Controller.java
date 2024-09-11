package com.javaremote67.sprinb_web_be_sample.controller;


import com.javaremote67.sprinb_web_be_sample.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageV4Controller {

    private final List<Message> messages = new ArrayList<>();

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/v4/messages")
    public List<Message> getMessages() {
        return this.messages;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/api/v4/messages")
    public void createMessage(@RequestBody final Message message) {
        this.messages.add(message);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, path = "/api/v4/messages/{index}")
    public void createMessage(@RequestBody final Message message, @PathVariable final Integer index) {
        this.messages.get(index).setText(message.getText());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, path = "/api/v4/messages/{index}")
    public void deleteMessage(@PathVariable final Integer index) {
        this.messages.remove(index.intValue());
    }
}
