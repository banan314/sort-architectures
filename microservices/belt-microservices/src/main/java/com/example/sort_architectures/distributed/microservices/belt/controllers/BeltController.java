package com.example.sort_architectures.distributed.microservices.belt.controllers;

import com.example.sort_architectures.distributed.microservices.belt.dto.SortStatusDto;
import com.example.sort_architectures.distributed.microservices.belt.entities.BeltItem;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemsSortingException;
import com.example.sort_architectures.distributed.microservices.belt.services.BeltService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BeltController {

    private final BeltService beltService;

    @GetMapping("/start-sorter")
    public SortStatusDto startSorter() {
        return beltService.startSorter();
    }

    @GetMapping("/stop-sorter")
    public SortStatusDto stopSorter() {
        return beltService.stopSorter();
    }

    @PostMapping("/belt/items")
    public BeltItem placeItem(@RequestBody final BeltItem item) {
        return beltService.placeItem(item);
    }

    @DeleteMapping("/belt/items")
    public BeltItem popItem() throws ItemPopppingException {
        return beltService.popItem();
    }

    @PostMapping("/belt/items/sort")
    public String sortItems() throws ItemsSortingException {
        return beltService.sortItems();
    }
}
