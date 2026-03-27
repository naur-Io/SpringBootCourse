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


}