package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testHomaPageEndpoint() throws Exception{
        //localhost:8080
        this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk())//200
            .andExpect(content().string("Hello from Spring!"));
    }

    @Test
    public void testMathPiEndpoint() throws Exception{
        //localhost:8080
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void queryStringTest() throws Exception{
        //localhost:8080
        this.mvc.perform(get("/animals?animal=cat&age=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())//200
                .andExpect(content().string("cats are the best when they are 5"));
    }
    @Test
    public void testMathPath() throws Exception{
        //localhost:8080
        int length = 3;
        int width = 4;
        int height = 5;
        this.mvc.perform(get(String.format("/math/volume/%d/%d/%d", length, width, height)))
                .andExpect(status().isOk())//200
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void cookieAccessingTest() throws Exception {
        this.mvc.perform(get("/cookie").cookie(new Cookie("key","value")))
                .andExpect(status().isOk())
                .andExpect(content().string("This is our cookie: value"));
    }
}
