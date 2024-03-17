package com.example.monolith.modular.report;

import com.example.monolith.modular.report.controllers.ReportController;
import com.example.monolith.modular.report.services.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ReportControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ReportService reportService;

    @Test
    void testGenerateReport() throws Exception {
        final String reportId = "123";
        final String reportContent = "Sample report content";

        when(reportService.generateReport(reportId)).thenReturn(reportContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/reports/{reportId}", reportId))
                .andExpect(status().isOk())
                .andExpect(content().string(reportContent));
    }

    @Configuration
    @Import(ReportController.class)
    static class TestBeanConfiguration {
    }
}