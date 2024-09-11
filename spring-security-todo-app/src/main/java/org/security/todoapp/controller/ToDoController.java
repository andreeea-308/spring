package org.security.todoapp.controller;

import org.security.todoapp.model.ToDo;
import org.security.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/todo-list")
public class ToDoController {

    @Autowired
    private ToDoRepository todoRepository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todo-index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task,
                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline) {
        ToDo todo = new ToDo();
        todo.setTask(task);
        todo.setDeadline(deadline);
        todoRepository.save(todo);
        return "redirect:/todo-list";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todo-list";
    }

    @PostMapping("/update")
    public String updateTodo(@RequestParam Long id,
                             @RequestParam String task,
                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date deadline) {
        Optional<ToDo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            ToDo todo = todoOptional.get();
            todo.setTask(task);
            todo.setDeadline(deadline);
            todoRepository.save(todo);
        }
        return "redirect:/todo-list";
    }
}
