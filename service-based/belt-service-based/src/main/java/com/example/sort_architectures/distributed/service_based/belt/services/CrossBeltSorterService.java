package com.example.sort_architectures.distributed.service_based.belt.services;

public interface CrossBeltSorterService {

    String calibrateSorter();

    String optimizeSorter();

    String performQualityAssurance(String item);
}
