package com.example.sort_architectures.distributed.microservices.crossbelt.services;

import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.BeltServiceException;
import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.ItemsSortingException;

import java.io.IOException;

public interface BeltService {
    String startSorter() throws IOException, InterruptedException, BeltServiceException;

    String stopSorter() throws IOException, InterruptedException, BeltServiceException;

    String sortItems() throws ItemsSortingException, IOException, InterruptedException;
}
