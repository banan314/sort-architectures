package com.example.sort_architectures.distributed.service_based.belt.services;

import com.example.sort_architectures.distributed.service_based.belt.dto.SortStatusDto;
import com.example.sort_architectures.distributed.service_based.belt.entities.BeltItem;
import com.example.sort_architectures.distributed.service_based.belt.exceptions.ItemPopppingException;
import com.example.sort_architectures.distributed.service_based.belt.exceptions.ItemsSortingException;

public interface BeltService {

    SortStatusDto startSorter();

    SortStatusDto stopSorter();

    BeltItem popItem() throws ItemPopppingException;

    BeltItem placeItem(BeltItem item);

    String sortItems() throws ItemsSortingException;
}
