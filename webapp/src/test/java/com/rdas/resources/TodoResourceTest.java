package com.rdas.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdas.repository.TodoRepository;
import com.rdas.services.TodoService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//https://www.freecodecamp.org/news/unit-testing-services-endpoints-and-repositories-in-spring-boot-4b7d9dc2b772/
//https://springbootdev.com/2018/02/22/spring-boot-test-writing-unit-tests-for-the-controller-layers-with-webmvctest/#more-4536
@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(TodoResource.class)
public class TodoResourceTest {
//    @Mock
//    TodoRepository todoRepository;

    @Mock
    TodoService todoService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void it_should_return_nothing_at_first() throws Exception {
//        when(todoService.getById(1L)).thenReturn(Optional.empty());
//
//        mockMvc.perform(get("/")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//        ;
    }
}