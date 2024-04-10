package com.example.sort_architectures.distributed.microservices.crossbelt.services;

import com.example.sort_architectures.distributed.microservices.crossbelt.exceptions.BeltServiceException;

import java.io.IOException;

public interface CrossBeltSorterService {

    String calibrateSorter() throws BeltServiceException, IOException, InterruptedException;

    String optimizeSorter() throws BeltServiceException, IOException, InterruptedException;

    String performQualityAssurance(String item) throws BeltServiceException, IOException, InterruptedException;
}
