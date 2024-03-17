package org.example.monolith.layered.services.impl;

import lombok.AllArgsConstructor;
import org.example.monolith.layered.exceptions.ItemsSortingException;
import org.example.monolith.layered.services.BeltService;
import org.example.monolith.layered.services.CrossBeltSorterService;
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
