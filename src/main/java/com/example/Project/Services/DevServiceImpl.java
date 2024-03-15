package com.example.Project.Services;

import com.example.Project.Models.Dev;
import com.example.Project.Models.Maj;
import com.example.Project.Models.Marque;
import com.example.Project.Repositories.DevRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevServiceImpl {
    private final DevRepository devRepo;

    public DevServiceImpl(DevRepository devRepo) {
        this.devRepo = devRepo;
    }

    public List<Dev> getAllDev() {
        return devRepo.findAll();
    }

    public Dev saveDev(Dev dev) {
        return devRepo.save(dev);
    }

    public Optional<Dev> findById(int id) {
        return devRepo.findById(id);
    }

    public List<Dev> getDevByCdcId(int id) {
        return devRepo.findByCDC(id);
    }
   public List<Dev> getDevByMaj(Maj maj){
        return devRepo.findByMaj(maj);
   }


}
