package com.example.sort_architectures.distributed.microservices.crossbelt.controllers;

import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.BeltServiceException;
import com.example.sort_architectures.distributed.microservices.crossbelt.services.CrossBeltSorterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class CrossBeltSorterController {

    private final CrossBeltSorterService sorterService;

    @GetMapping("/calibrate-sorter")
    public String calibrateSorter() throws BeltServiceException {
        try {
            return sorterService.calibrateSorter();
        } catch (IOException | InterruptedException e) {
            throw new BeltServiceException(e.getMessage());
        }
    }

    @GetMapping("/optimize-sorter")
    public String optimizeSorter() throws BeltServiceException {
        try {
            return sorterService.optimizeSorter();
        } catch (IOException | InterruptedException e) {
            throw new BeltServiceException(e.getMessage());
        }
    }

    @GetMapping("/belt/status")
    public String getBeltStatus() {
        return "Belt is operational";
    }

    @PostMapping("/belt/quality-assurance")
    public String performQualityAssurance(@RequestBody final String item) throws BeltServiceException, IOException, InterruptedException {
        return sorterService.performQualityAssurance(item);
    }
}
