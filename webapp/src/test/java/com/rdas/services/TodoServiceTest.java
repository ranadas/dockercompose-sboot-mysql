package com.rdas.services;

import com.rdas.entity.Todo;
import com.rdas.repository.TodoRepository;
import com.rdas.services.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    @Test
    public void service_injected() {
        assertThat(todoService).isNotNull();
    }

    @Test
    public void service_save() {
        Todo todo = Todo.builder().id(1L).title("Add JaCoco to Codebase").completed(false).updatedDate(new Date()).build();
        when(todoRepository.save(todo)).thenReturn(todo);

        Todo saved = todoService.save(todo);
        assertThat(saved.getTitle()).isEqualTo(todo.getTitle());
    }

    @Test
    public void service_save_retrieveById() {
        Todo todo = Todo.builder().title("Add JaCoco to Codebase").completed(false).updatedDate(new Date()).build();
        when(todoRepository.save(todo)).thenReturn(todo);
        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        Todo saved = todoService.save(todo);
        assertThat(saved.getTitle()).isEqualTo(todo.getTitle());

        Optional<Todo> byId = todoService.getById(1L);
        assertThat(byId.isPresent()).isTrue();
        assertThat(byId.get().getTitle()).isEqualTo(todo.getTitle());
    }


    @Test
    public void service_save_retrieveByTitle() {
        Todo todo = Todo.builder().title("Add JaCoco to Codebase").completed(false).updatedDate(new Date()).build();
        when(todoRepository.save(todo)).thenReturn(todo);
        when(todoRepository.findByTitle("Add JaCoco to Codebase")).thenReturn(todo);

        Todo saved = todoService.save(todo);
        assertThat(saved.getTitle()).isEqualTo(todo.getTitle());

        Todo found = todoService.getByTitle("Add JaCoco to Codebase");
        assertThat(found.getTitle()).isEqualTo(todo.getTitle());
    }

    @Spy
    private List<Todo> parts = new ArrayList<>();
    @Test
    public void service_save_All() {
        Todo task1 = Todo.builder().id(1L).title("Go to Doctor").completed(false).updatedDate(new Date()).build();
        Todo task2 = Todo.builder().id(2L).title("Pay Taxes").completed(false).updatedDate(new Date()).build();
        parts.add(task1);
        parts.add(task2);

        when(todoRepository.saveAll(parts)).thenReturn(parts);

        List<Todo> todos = todoService.saveAll(parts);
        assertThat(todos.size()).isEqualTo(2);

    }
    @Test
    public void service_save_retrieveAll() {
        Todo task1 = Todo.builder().id(1L).title("Go to Doctor").completed(false).updatedDate(new Date()).build();
//        when(todoRepository.save(task1)).thenReturn(task1);
        Todo task2 = Todo.builder().id(2L).title("Pay Taxes").completed(false).updatedDate(new Date()).build();
//        when(todoRepository.save(task2)).thenReturn(task2);
        parts.add(task1);
        parts.add(task2);
        when(todoRepository.saveAll(parts)).thenReturn(parts);
        List<Todo> todos = todoService.saveAll(parts);

        when(todoRepository.findAll()).thenReturn(parts);

        List<Todo> foundAll = todoService.findAll();
        assertThat(foundAll.size()).isEqualTo(2);
    }
}