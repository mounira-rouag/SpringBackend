package com.example.Project.Controller;

import com.example.Project.Models.CDC;
import com.example.Project.Models.Reverse;
import com.example.Project.Repositories.ReverseRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api")
public class ReverseController {
private final ReverseRepository reverseRepo;

    public ReverseController(ReverseRepository reverseRepo) {
        this.reverseRepo = reverseRepo;
    }

    @PostMapping("cretae")
    public Reverse saveReverse(@RequestBody Reverse reverse){
        return reverseRepo.save(reverse);
    }
}
