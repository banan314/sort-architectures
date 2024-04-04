package com.example.sort_architectures.distributed.service_based.belt.dto;

public record SortStatusDto(Status status) {
    public enum Status {
        STARTED, STOPPED
    }
}
