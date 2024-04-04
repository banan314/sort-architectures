package com.example.sort_architectures.distributed.service_based.report.services;

import org.springframework.stereotype.Service;

@Service
public class DefaultReportService implements ReportService {

    @Override
    public String generateReport(final String reportId) {
        return "Report generated for ID " + reportId;
    }
}
