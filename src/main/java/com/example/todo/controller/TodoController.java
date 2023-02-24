package com.example.todo.controller;

import java.util.List;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;


@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public String fetchAllTodo(Model model) {
        List<Todo> allTodo = todoService.fetchAllTodo();
        model.addAttribute("allTodo", allTodo);
        return "index";
    }

    @PostMapping(path="/new", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public String saveTodo(@RequestBody Todo todo) {
    public String saveTodo(Todo todo) {
        Todo _savedTodo = todoService.saveTodo(todo);
        return "redirect:/";
    }

//    @PutMapping(path="/update/{id}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public String updateTodo(Todo todo, @PathVariable("id") Long todoId) {
//    @PutMapping(path="/update", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @PostMapping(path="/update", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateTodo(Todo todo) {
        Todo _updatedTodo = todoService.updateTodo(todo);
        return "redirect:/";
    }

//    @DeleteMapping(path="/delete/{id}", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public String deleteTodo(@PathVariable("id") Long todoId) {
    @PostMapping(path="/delete", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String deleteTodo(Long todoId) {
        System.out.println("before delete");
        todoService.deleteTodoById(todoId);
        System.out.println("after delete");
        return "redirect:/";
    }

}