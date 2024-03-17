package org.example.monolith.layered.controllers.core;

import org.example.monolith.layered.controllers.handlers.ControllerExceptionHandler;
import org.example.monolith.layered.dto.SortStatusDto;
import org.example.monolith.layered.entities.BeltItem;
import org.example.monolith.layered.exceptions.ItemPopppingException;
import org.example.monolith.layered.exceptions.ItemsSortingException;
import org.example.monolith.layered.services.BeltService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class BeltControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeltService beltService;

    @Test
    void testStartSorter() throws Exception {
        final var mockDto = new SortStatusDto(SortStatusDto.Status.STARTED);
        when(beltService.startSorter()).thenReturn(mockDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/start-sorter"))
                .andExpect(status().isOk())
                .andExpect(content().json(String.format("{\"status\":\"%s\"}", SortStatusDto.Status.STARTED.name())));
    }

    @Test
    void testStopSorter() throws Exception {
        final SortStatusDto mockDto = new SortStatusDto(SortStatusDto.Status.STOPPED);
        when(beltService.stopSorter()).thenReturn(mockDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/stop-sorter"))
                .andExpect(status().isOk())
                .andExpect(content().json(String.format("{\"status\":\"%s\"}", SortStatusDto.Status.STOPPED)));
    }

    @Test
    void testPlaceItem() throws Exception {
        final var item = new BeltItem("Test item");
        final var persistedItem = new BeltItem(item);
        persistedItem.setId(1L);
        when(beltService.placeItem(item)).thenReturn(persistedItem);

        mockMvc.perform(MockMvcRequestBuilders.post("/belt/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":null,\"description\":\"Test item\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'description':'Test item'}"));
    }

    @Test
    void testPopItem_Success() throws Exception {
        final var item = new BeltItem(1L, "Test item");
        when(beltService.popItem()).thenReturn(item);

        mockMvc.perform(MockMvcRequestBuilders.delete("/belt/items"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'description':'Test item'}"));
    }

    @Test
    void testPopItem_Failure() throws Exception {
        doThrow(new ItemPopppingException("Popping item failed")).when(beltService).popItem();

        mockMvc.perform(MockMvcRequestBuilders.delete("/belt/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Popping item failed"));
    }

    @Test
    void testSortItems_Success() throws Exception {
        when(beltService.sortItems()).thenReturn("Items sorted successfully");

        mockMvc.perform(MockMvcRequestBuilders.post("/belt/items/sort"))
                .andExpect(status().isOk())
                .andExpect(content().string("Items sorted successfully"));
    }

    @Test
    void testSortItems_Failure() throws Exception {
        Mockito.doThrow(new ItemsSortingException("Sorting failed")).when(beltService).sortItems();

        mockMvc.perform(MockMvcRequestBuilders.post("/belt/items/sort"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Sorting failed"));
    }

    @Configuration
    @Import({BeltController.class, ControllerExceptionHandler.class})
    static class TestBeanConfiguration {
    }
}