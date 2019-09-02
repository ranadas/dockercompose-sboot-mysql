package com.rdas.services;

import com.rdas.entity.Todo;
import com.rdas.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> saveAll(List<Todo> todos) {
        return todoRepository.saveAll(todos);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo getByTitle(String title) {
        return todoRepository.findByTitle(title);
    }
}