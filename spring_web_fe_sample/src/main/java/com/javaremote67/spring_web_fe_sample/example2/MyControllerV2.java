package com.javaremote67.spring_web_fe_sample.example2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v2")
public class MyControllerV2 {

    @GetMapping("/welcome-1")
    public String welcome1(Model model) {
        model.addAttribute("welcomeMessage", "Aloha senior!");
        return "example-2-welcome";
    }

    @GetMapping("/welcome-2")
    public ModelAndView welcome2() {
        ModelAndView modelAndView = new ModelAndView("example-2-welcome");
        modelAndView.addObject("welcomeMessage", "Guten tag!");
        return modelAndView;
    }
}
