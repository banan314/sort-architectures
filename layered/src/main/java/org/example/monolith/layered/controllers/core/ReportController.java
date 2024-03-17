package org.example.monolith.layered.controllers.core;

import lombok.AllArgsConstructor;
import org.example.monolith.layered.services.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/reports/{reportId}")
    public String generateReport(@PathVariable final String reportId) {
        return reportService.generateReport(reportId);
    }
}
