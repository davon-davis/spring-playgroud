package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    public void testFlightDate() throws Exception {
        // 1. Check for a 200 response, that the content type is JSON and that the name is "Splash Mountain"
        this.mvc.perform(get("/flights/flight?departs=2017-04-21 14:34")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.Departs", is("2017-04-21 14:34")));
    }

    @Test
    public void testFlightFirstNameAndPrice() throws Exception {
        // 1. Check for a 200 response, that the content type is JSON and that the name is "Splash Mountain"
        this.mvc.perform(get("/flights/flight")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName", is("Dave")))
                .andExpect(jsonPath("$.Tickets[0].Price", is(200)));
    }

    @Test
    public void testSecondFlightEntry() throws Exception {
        // 1. Check for a 200 response, that the content type is JSON and that the name is "Splash Mountain"
        this.mvc.perform(get("/flights")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.Tickets[1].Passenger.FirstName", is("Brad")))
                .andExpect(jsonPath("$[1].Tickets[0].Price", is(400)));
    }
}
