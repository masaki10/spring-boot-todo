package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // Save operation
    @Override
    public Todo saveTodo(Todo todo)
    {
        return todoRepository.save(todo);
    }

    // Read operation
    @Override
    public List<Todo> fetchAllTodo()
    {
        return (List<Todo>)todoRepository.findAll();
    }

    // Update operation
    @Override
    public Todo updateTodo(Todo todo)
    {
        Todo newTodo = todoRepository.findById(todo.getId()).get();

        if (Objects.nonNull(todo.getContent()) && !"".equalsIgnoreCase(todo.getContent())) {
            newTodo.setContent(todo.getContent());
        }

        if (Objects.nonNull(todo.getDone())) {
            newTodo.setDone(todo.getDone());
        }

        return todoRepository.save(newTodo);
    }

    // Delete operation
    @Override
    public void deleteTodoById(Long todoId)
    {
        System.out.println("before delete method");
        System.out.println(todoId);
        todoRepository.deleteById(todoId);
        System.out.println("after delete method");
    }
}
