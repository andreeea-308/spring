package com.javaremote67.spriing_data_jpa_sample.to_do_list_app;


import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/api/to-do-list")
@AllArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("allTasks", this.taskRepository.findAll());
        return "to-do-list";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String name, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateline) {
        Task task = new Task(name, dateline);
        this.taskRepository.save(task);
        return "redirect:/api/to-do-list";
    }

}
