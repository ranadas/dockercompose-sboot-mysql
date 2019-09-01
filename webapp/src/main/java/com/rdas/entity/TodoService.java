package com.rdas.entity;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository stockRepository;

    public List<Todo> findAll() {
        return stockRepository.findAll();
    }

    public List<Todo> saveAll(List<Todo> todos) {
        return stockRepository.saveAll(todos);
    }

}