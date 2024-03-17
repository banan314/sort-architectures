package com.example.monolith.modular.cross_belt_sorter;

import com.example.monolith.modular.cross_belt_sorter.controllers.CrossBeltSorterController;
import com.example.monolith.modular.cross_belt_sorter.services.CrossBeltSorterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CrossBeltSorterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CrossBeltSorterService sorterService;

    @Test
    void testCalibrateSorter() throws Exception {
        when(sorterService.calibrateSorter()).thenReturn("Calibrated");

        mockMvc.perform(MockMvcRequestBuilders.get("/calibrate-sorter"))
                .andExpect(status().isOk())
                .andExpect(content().string("Calibrated"));
    }

    @Test
    void testOptimizeSorter() throws Exception {
        when(sorterService.optimizeSorter()).thenReturn("Optimized");

        mockMvc.perform(MockMvcRequestBuilders.get("/optimize-sorter"))
                .andExpect(status().isOk())
                .andExpect(content().string("Optimized"));
    }

    @Test
    void testGetBeltStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/belt/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("Belt is operational"));
    }

    @Test
    void testPerformQualityAssurance() throws Exception {
        final String item = "Test Item";
        when(sorterService.performQualityAssurance(item)).thenReturn("Quality assurance completed for item " + item);

        mockMvc.perform(MockMvcRequestBuilders.post("/belt/quality-assurance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(item))
                .andExpect(status().isOk())
                .andExpect(content().string("Quality assurance completed for item Test Item"));
    }

    @Configuration
    @Import(CrossBeltSorterController.class)
    static class TestContextConfig {
    }
}