package com.rdas.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//https://www.freecodecamp.org/news/unit-testing-services-endpoints-and-repositories-in-spring-boot-4b7d9dc2b772/
//https://springbootdev.com/2018/02/22/spring-boot-test-writing-unit-tests-for-the-controller-layers-with-webmvctest/#more-4536
@SpringBootTest
@WebMvcTest(TodoResource.class)
@AutoConfigureMockMvc
//@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_CLASS, methodMode= DirtiesContext.MethodMode.BEFORE_METHOD)
//@AutoConfigureTestDatabase
//https://howtodoinjava.com/spring-boot2/spring-boot-mockmvc-example/
public class TodoResourceTest1 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void it_should_return_nothing_at_first() throws Exception {
//        when(todoService.getById(1L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/todos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        ;
        /*
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/add")
                .content(ClassToStringUtils.parse(account)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.CREATED.value()))
                .andReturn();
         */
    }
}