package com.example.Project.Controller;

import com.example.Project.Models.Maj;
import com.example.Project.Models.Marque;
import com.example.Project.Repositories.MajRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/maj")
public class MAJController {

    private final MajRepository majRepo;

    public MAJController(MajRepository majRepo) {
        this.majRepo = majRepo;
    }
    @GetMapping("/all-versions")
    public List<Maj> getAllVersions() {
        return majRepo.findAll();
}


}
