package com.example.sort_architectures.distributed.event_driven.messages;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Messages {
    public static final String START_SORTER = "start-sorter";
    public static final String STOP_SORTER = "stop-sorter";
    public static final String POP_ITEM = "pop-item";
    public static final String SORT_ITEMS = "sort-items";
    public static final String PLACE_ITEM = "place-item";
    public static final String CALIBRATE_SORTER = "calibrate-sorter";
    public static final String OPTIMIZE_SORTER = "optimize-sorter";
    public static final String QUALITY_ASSURANCE = "quality-assurance";

    @UtilityClass
    public static class ReportMessages {
        public static final String SORTER_OPTIMIZED = "Sorter optimized";
        public static final String QUALITY_ASSURANCE = "Quality assurance completed for item ";
    }
}
