package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathService.class)
public class MathServiceTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testMathCalculateAdd() throws Exception {
        //localhost:8080
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testMathCalculateMultiply() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    public void testMathCalculateSub() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testMathCalculateDivide() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testMathCalculateNothing() throws Exception {
        this.mvc.perform(get("/math/calculate?x=30&y=5")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("30 + 5 = 35"));
    }

    @Test
    public void testMathSum() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().is(200))//200
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testAreaCircle() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548245743669"));

    }

    @Test
    public void testAreaRectangle() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height", "7");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4x7 rectangle is 28"));;
    }

    @Test
    public void testAreainvalid() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "5");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));;
    }
}
