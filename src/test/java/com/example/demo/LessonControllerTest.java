package com.example.demo;

import com.example.demo.lesson.Lesson;
import com.example.demo.lesson.LessonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testList() throws Exception{
        Lesson lesson = new Lesson();
        lesson.setTitle("basket weaving");
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(lesson.getId().intValue())))
                .andExpect(jsonPath("$.[0].title", is("basket weaving")));
    }

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception{
        Lesson lesson = new Lesson();
        lesson.setTitle("Racket");
        lesson.setDeliveredOn(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(lesson);

        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Racket") ));
    }

}
