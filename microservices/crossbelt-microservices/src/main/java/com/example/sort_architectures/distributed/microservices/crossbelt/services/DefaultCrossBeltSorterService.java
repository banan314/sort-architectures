package com.example.sort_architectures.distributed.microservices.crossbelt.services;

import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.BeltServiceException;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.ItemsSortingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class DefaultCrossBeltSorterService implements CrossBeltSorterService {

    private final BeltService beltService;

    @Override
    public String calibrateSorter() throws BeltServiceException, IOException, InterruptedException {
        beltService.startSorter();
        beltService.stopSorter();
        return "Sorter calibrated";
    }

    @Override
    public String optimizeSorter() throws BeltServiceException, IOException, InterruptedException {
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
    public String performQualityAssurance(final String item) throws BeltServiceException, IOException, InterruptedException {
        beltService.startSorter();
        beltService.stopSorter();
        return "Quality assurance completed for item " + item;
    }
}
