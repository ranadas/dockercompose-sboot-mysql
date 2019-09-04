package com.rdas.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
//@Import(SomeConfig.class)
public class IndexControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_homepage_returns_ok() throws Exception {
        mockMvc.perform(get("/")
                        .accept(MediaType.APPLICATION_JSON)
                //.with(httpBasic(username, password))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
//                .andExpect(jsonPath("$.user_id", CoreMatchers.is(userId)))
//                .andExpect(jsonPath("$.name", CoreMatchers.is(name)))
//                .andExpect(jsonPath("$.username", CoreMatchers.is(username)))
        ;
    }
    @Test
    public void test_homepage_returns_index() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(view().name("index"));
    }
}