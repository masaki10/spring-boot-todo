package com.example.todo.service;
import com.example.todo.entity.Todo;
// Importing required classes
import java.util.List;

public interface TodoService {

    // Save operation
    Todo saveTodo(Todo todo);

    // Read operation
    List<Todo> fetchAllTodo();

    // Update operation
    Todo updateTodo(Todo todo);

    // Delete operation
    void deleteTodoById(Long todoId);
}