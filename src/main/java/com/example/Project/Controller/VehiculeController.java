package com.example.Project.Controller;

import com.example.Project.Models.Marque;
import com.example.Project.Models.Vehicule;
import com.example.Project.Repositories.MarqueRepository;
import com.example.Project.Repositories.VehiculeRepository;
import com.example.Project.Services.VehiculeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {


    private final VehiculeServiceImpl vehiculeServieImpl;
    private final MarqueRepository marqueRepo;

    final VehiculeRepository vehiculeRepository ;

    public VehiculeController(VehiculeRepository vehiculeRepo, VehiculeServiceImpl vehiculeServieImpl, MarqueRepository marqueRepo, VehiculeRepository vehiculeRepository) {

        this.vehiculeServieImpl = vehiculeServieImpl;
        this.marqueRepo = marqueRepo;
        this.vehiculeRepository = vehiculeRepository;
    }




    @GetMapping("/all")
    public  List<Vehicule> getAllVehicule(){
        return vehiculeRepository.findAll() ;
    }

    @PostMapping("/create")
    public  Vehicule saveVehicule(@RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule) ;
    }
    /**find vehicues by marque */
    @GetMapping("/by-marque/{marqueId}")
    public List<Vehicule> getVehiculesByMarque(@PathVariable int marqueId) {

        Marque marque = marqueRepo.getById(marqueId);
        return vehiculeServieImpl.getVehiculesByMarque(marque);
    }
}
