package com.example.sort_architectures.distributed.microservices.belt.services;

import com.example.sort_architectures.distributed.microservices.belt.dto.SortStatusDto;
import com.example.sort_architectures.distributed.microservices.belt.entities.BeltItem;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.microservices.belt.exceptions.ItemsSortingException;

public interface BeltService {

    SortStatusDto startSorter();

    SortStatusDto stopSorter();

    BeltItem popItem() throws ItemPopppingException;

    BeltItem placeItem(BeltItem item);

    String sortItems() throws ItemsSortingException;
}
