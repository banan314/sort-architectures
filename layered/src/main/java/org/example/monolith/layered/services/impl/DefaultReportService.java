package org.example.monolith.layered.services.impl;

import org.example.monolith.layered.services.ReportService;
import org.springframework.stereotype.Service;

@Service
public class DefaultReportService implements ReportService {

    @Override
    public String generateReport(final String reportId) {
        return "Report generated for ID " + reportId;
    }
}
