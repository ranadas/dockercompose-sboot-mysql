package com.rdas.resources;

import java.util.List;

import javax.validation.Valid;

import com.rdas.entity.Todo;
import com.rdas.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/todos")
@Slf4j
public class TodoResource {
    private final TodoService todoService;

    @Autowired
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> findAll() {
        var test = "rana";
        return ResponseEntity.ok(todoService.findAll());
    }

    @PostMapping("/one")
    public ResponseEntity<?> save(@Valid @RequestBody Todo todo) {
        log.info(todo.toString());
        return ResponseEntity.ok(todoService.save(todo));
    }
//    @PostMapping("/all")
    public ResponseEntity<?> saveAll(@Valid @RequestBody List<Todo> todos) {
        log.info(todos.toString());
        return ResponseEntity.ok(todoService.saveAll(todos));
    }
}