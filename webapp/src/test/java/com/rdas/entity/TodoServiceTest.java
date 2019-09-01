package com.rdas.entity;

import lombok.extern.log4j.Log4j2;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@Ignore
@Log4j2
@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {
    @MockBean
    TodoRepository todoRepository;

//    @Mock
//    TodoRepository todoRepository2;

    @InjectMocks
    TodoService todoService;

    //@Spy
    private List<Todo> todos = new ArrayList<>();
    private Todo alex = Todo.builder().title("Add Alex").completed(false).updatedDate(new Date()).build();

    //when(mockRepository.findById(1L)).thenReturn(Optional.of(book));

    @Test
    public void return_emptytods_at_start() {
        assertNotNull(todoService);
//        when(todoRepository.findAll()).thenReturn(todos);
        when(todoRepository.findByTitle("Add Alex")).thenReturn(alex);

        Todo found = todoService.getByTitle("Add Alex");

        System.out.println(found);
    }
}