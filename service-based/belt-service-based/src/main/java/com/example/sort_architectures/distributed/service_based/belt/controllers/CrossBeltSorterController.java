package com.example.sort_architectures.distributed.service_based.belt.controllers;

import com.example.sort_architectures.distributed.service_based.belt.services.CrossBeltSorterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CrossBeltSorterController {

    private final CrossBeltSorterService sorterService;

    @GetMapping("/calibrate-sorter")
    public String calibrateSorter() {
        return sorterService.calibrateSorter();
    }

    @GetMapping("/optimize-sorter")
    public String optimizeSorter() {
        return sorterService.optimizeSorter();
    }

    @GetMapping("/belt/status")
    public String getBeltStatus() {
        return "Belt is operational";
    }

    @PostMapping("/belt/quality-assurance")
    public String performQualityAssurance(@RequestBody final String item) {
        return sorterService.performQualityAssurance(item);
    }
}
