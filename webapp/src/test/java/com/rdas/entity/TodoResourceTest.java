package com.rdas.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdas.resources.TodoResource;
import com.rdas.services.TodoService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@Ignore
//https://www.freecodecamp.org/news/unit-testing-services-endpoints-and-repositories-in-spring-boot-4b7d9dc2b772/
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(TodoResource.class)
public class TodoResourceTest {

    ObjectMapper  objectMapper = new ObjectMapper();

    @MockBean
    TodoService todoService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void it_should_return_all_users() {

    }
}