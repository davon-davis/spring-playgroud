package com.example.demo.lesson;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> show(@PathVariable Long id){
        return this.repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteID(@PathVariable Long id){
        this.repository.deleteById(id);

    }
}
