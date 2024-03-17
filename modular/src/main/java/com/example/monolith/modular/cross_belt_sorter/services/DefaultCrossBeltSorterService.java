package com.example.monolith.modular.cross_belt_sorter.services;

import com.example.monolith.modular.belt.exceptions.ItemsSortingException;
import com.example.monolith.modular.belt.services.BeltService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultCrossBeltSorterService implements CrossBeltSorterService {

    private final BeltService beltService;

    @Override
    public String calibrateSorter() {
        beltService.startSorter();
        beltService.stopSorter();
        return "Sorter calibrated";
    }

    @Override
    public String optimizeSorter() {
        beltService.startSorter();
        try {
            beltService.sortItems();
        } catch (final ItemsSortingException e) {
            return "Optimization failed. " + e.getMessage();
        }
        beltService.stopSorter();
        return "Sorter optimized";
    }

    @Override
    public String performQualityAssurance(final String item) {
        beltService.startSorter();
        beltService.stopSorter();
        return "Quality assurance completed for item " + item;
    }
}
