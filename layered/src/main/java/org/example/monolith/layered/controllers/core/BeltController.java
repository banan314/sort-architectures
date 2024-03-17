package org.example.monolith.layered.controllers.core;

import lombok.AllArgsConstructor;
import org.example.monolith.layered.dto.SortStatusDto;
import org.example.monolith.layered.entities.BeltItem;
import org.example.monolith.layered.exceptions.ItemPopppingException;
import org.example.monolith.layered.exceptions.ItemsSortingException;
import org.example.monolith.layered.services.BeltService;
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
