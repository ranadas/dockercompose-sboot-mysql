package com.rdas.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
//@Import(SpringSecurityConfig.class)
public class IndexControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUser1() throws Exception {
        mockMvc.perform(get("/")
                .accept(MediaType.APPLICATION_JSON)
                //.with(httpBasic(username, password))
                )
                .andExpect(status().isOk())
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$.user_id", CoreMatchers.is(userId)))
//                .andExpect(jsonPath("$.name", CoreMatchers.is(name)))
//                .andExpect(jsonPath("$.username", CoreMatchers.is(username)))
            ;
    }
}