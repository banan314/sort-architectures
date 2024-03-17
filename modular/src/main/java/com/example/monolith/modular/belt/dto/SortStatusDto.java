package com.example.monolith.modular.belt.dto;

public record SortStatusDto(Status status) {
    public enum Status {
        STARTED, STOPPED
    }
}
