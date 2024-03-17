package org.example.monolith.layered.services;

import org.example.monolith.layered.dto.SortStatusDto;
import org.example.monolith.layered.entities.BeltItem;
import org.example.monolith.layered.exceptions.ItemPopppingException;
import org.example.monolith.layered.exceptions.ItemsSortingException;

public interface BeltService {

    SortStatusDto startSorter();

    SortStatusDto stopSorter();

    BeltItem popItem() throws ItemPopppingException;

    BeltItem placeItem(BeltItem item);

    String sortItems() throws ItemsSortingException;
}
