package com.example.monolith.modular;

import com.example.monolith.modular.belt.services.BeltService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.util.Assert.notNull;

@SpringBootTest
class SortArchitecturesApplicationTest {

    @Autowired
    BeltService beltService;

    @Test
    void contextLoads() {
        notNull(beltService, "Belt service is null!");
    }
}