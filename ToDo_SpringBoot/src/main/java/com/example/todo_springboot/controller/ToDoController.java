package com.example.todo_springboot.controller;

import com.example.todo_springboot.dto.TodoDto;
import com.example.todo_springboot.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;

    // Build Add Todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addToDo(@RequestBody TodoDto todoDto) {
        TodoDto savedToDo = toDoService.addToDo(todoDto);
        return new ResponseEntity<>(savedToDo, HttpStatus.CREATED);
    }

    // Build Get Todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        TodoDto todoDto = toDoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build Get All Todo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = toDoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // Build Update Todo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto,
                                              @PathVariable("id") Long todoId) {
        TodoDto updatedTodoDto = toDoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodoDto);
    }

    // Build Delete Todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        toDoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo is deleted success");
    }

    // Build Complete Todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodo = toDoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    // Build Incomplete Todo REST API
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodo = toDoService.incompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }
}
