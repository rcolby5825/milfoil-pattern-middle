package com.example.milfoil.web;

import com.example.milfoil.config.ApiRateLimitFilter;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApiControllerTest {

    @Test
    void apiHealthEndpointShouldBeAccessible() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new ApiController())
                .addFilters(new ApiRateLimitFilter())
                .build();

        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"status\":\"ok\"}"));
    }

    @Test
    void apiHealthEndpointShouldRateLimitAfterOneHundredRequests() throws Exception {
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new ApiController())
                .addFilters(new ApiRateLimitFilter())
                .build();

        for (int i = 0; i < 100; i++) {
            mockMvc.perform(get("/api/health"))
                    .andExpect(status().isOk());
        }

        mockMvc.perform(get("/api/health"))
                .andExpect(status().isTooManyRequests());
    }
}
