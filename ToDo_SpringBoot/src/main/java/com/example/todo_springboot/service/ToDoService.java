package com.example.todo_springboot.service;

import com.example.todo_springboot.dto.TodoDto;

import java.util.List;

public interface ToDoService {
    TodoDto addToDo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);

    TodoDto incompleteTodo(Long id);
}
