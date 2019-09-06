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

/*
/todos
/todos/{id}
/todos/{id}/report
https://howtodoinjava.com/spring-boot2/rest-with-spring-hateoas-example/
 */
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
        var allTodos = todoService.findAll();
        return ResponseEntity.ok(allTodos);
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        log.info("Saving {}", todo.toString());
        var savedTodo = todoService.save(todo);
        return ResponseEntity.ok(savedTodo);
    }
    @PostMapping("/saveall")
    public ResponseEntity<?> saveAll(@Valid @RequestBody List<Todo> todos) {
        log.info(todos.toString());
        var todosCreated = todoService.saveAll(todos);
        return ResponseEntity.ok(todosCreated);
    }
}