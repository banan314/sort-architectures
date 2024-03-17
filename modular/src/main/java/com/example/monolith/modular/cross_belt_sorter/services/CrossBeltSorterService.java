package com.example.monolith.modular.cross_belt_sorter.services;

public interface CrossBeltSorterService {

    String calibrateSorter();

    String optimizeSorter();

    String performQualityAssurance(String item);
}
