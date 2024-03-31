package com.example.sort_architectures.distributed.event_driven.dto;

public record SortStatusDto(Status status) {
    public enum Status {
        STARTED, STOPPED
    }
}
