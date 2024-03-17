package com.example.monolith.modular.belt.services;

import com.example.monolith.modular.belt.dto.SortStatusDto;
import com.example.monolith.modular.belt.exceptions.ItemsSortingException;
import com.example.monolith.modular.core.entities.BeltItem;
import com.example.monolith.modular.belt.exceptions.ItemPopppingException;

public interface BeltService {

    SortStatusDto startSorter();

    SortStatusDto stopSorter();

    BeltItem popItem() throws ItemPopppingException;

    BeltItem placeItem(BeltItem item);

    String sortItems() throws ItemsSortingException;
}
