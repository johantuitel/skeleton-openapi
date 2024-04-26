package nl.skeleton.openapi.controllers;

import nl.skeleton.openapi.models.World;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/world", produces = MediaType.APPLICATION_JSON_VALUE)
    public World world() {
        return new World("Greetings from Spring Boot!");
    }
}
