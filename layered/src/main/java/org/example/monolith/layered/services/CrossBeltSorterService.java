package org.example.monolith.layered.services;

public interface CrossBeltSorterService {

    String calibrateSorter();

    String optimizeSorter();

    String performQualityAssurance(String item);
}
