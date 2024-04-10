package com.example.sort_architectures.distributed.microservices.crossbelt.dto;

public record SortStatusDto(Status status) {
    public enum Status {
        STARTED, STOPPED
    }
}
