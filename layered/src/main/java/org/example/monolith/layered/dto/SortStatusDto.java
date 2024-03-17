package org.example.monolith.layered.dto;

public record SortStatusDto(SortStatusDto.Status status) {
    public enum Status {
        STARTED, STOPPED
    }
}
