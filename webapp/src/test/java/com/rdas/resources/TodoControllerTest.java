package com.rdas.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdas.entity.Todo;
import com.rdas.test.config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(TodoResource.class)
@Import(TestConfig.class)
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //@Qualifier("timesObjectMapper")
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void init() {
//        objectMapper.registerModule(new JSR310Module());
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }

    @Test
    public void all_returns_ok_empty_list() throws Exception {
        mockMvc.perform(get("/api/todos/all")
                //.accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
        ;
    }
    //https://www.mkyong.com/spring-boot/spring-test-how-to-test-a-json-array-in-jsonpath/

    @Test
    public void save_todo_returns_ok() throws Exception {
        Todo todo = Todo.builder()
                .title("A Test Todo")
                .completed(false)
                .updatedDate(LocalDate.now())
                .build();
        mockMvc.perform(post("/api/todos/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(todo))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.fieldErrors", hasSize(2)))
//                .andExpect(jsonPath("$.fieldErrors[*].path", containsInAnyOrder("title", "description")))
//                .andExpect(jsonPath("$.fieldErrors[*].message", containsInAnyOrder(
//                        "The maximum length of the description is 500 characters.",
//                        "The maximum length of the title is 100 characters."
//                )))
        ;
    }
    @Test
    public void save_all_todo_returns_ok() throws Exception {
        Todo todo = Todo.builder()
                .title("A Test Todo")
                .completed(false)
                .updatedDate(LocalDate.now())
                .build();
        var todos = new ArrayList<>();
        todos.add(todo);
        mockMvc.perform(post("/api/todos/saveall")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(todos))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.fieldErrors", hasSize(2)))
//                .andExpect(jsonPath("$.fieldErrors[*].path", containsInAnyOrder("title", "description")))
//                .andExpect(jsonPath("$.fieldErrors[*].message", containsInAnyOrder(
//                        "The maximum length of the description is 500 characters.",
//                        "The maximum length of the title is 100 characters."
//                )))
        ;
    }
}