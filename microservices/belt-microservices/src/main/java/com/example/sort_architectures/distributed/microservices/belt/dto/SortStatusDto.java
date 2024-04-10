package com.example.sort_architectures.distributed.microservices.belt.dto;

public record SortStatusDto(Status status) {
    public enum Status {
        STARTED, STOPPED
    }
}
