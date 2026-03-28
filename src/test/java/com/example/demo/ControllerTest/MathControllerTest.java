package com.example.demo.ControllerTest;

import com.example.demo.controllers.MathController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MathController.class)
class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSumOfTwoNumbers() throws Exception {
        mockMvc.perform(get("/math/sum/5/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }

    @Test
    void shouldThrowExceptionWhenInputIsNotNumeric() throws Exception {
        mockMvc.perform(get("/math/sum/a/b"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldThrowExceptionWhenOneInputIsNotNumeric() throws Exception {
        mockMvc.perform(get("/math/sum/1/b"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldThrowExceptionWhenMissingInput() throws Exception {
        mockMvc.perform(get("/math/sum/b/"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnSquareOfNumber() throws Exception {
        mockMvc.perform(get("/math/square/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("25.0"));
    }

    @Test
    void shouldSubstractTwoNumbers() throws Exception {
        mockMvc.perform(get("/math/sub/5/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void shouldMultiplyTwoNumbers() throws Exception {
        mockMvc.perform(get("/math/mult/5/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }


    @Test
    void shouldDivideTwoNumbers() throws Exception {
        mockMvc.perform(get("/math/div/6/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() throws Exception {
         mockMvc.perform(get("/math/div/6/0"))
                 .andExpect(status().isBadRequest());

     }
}