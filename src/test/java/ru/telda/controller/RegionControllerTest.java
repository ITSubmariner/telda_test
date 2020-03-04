package ru.telda.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegionControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/region/all")).andExpect(status().isOk()).andExpect(content().json("[{\"id\":1,\"name\":\"Moscow\",\"title\":\"MSK\"},{\"id\":2,\"name\":\"Saint-Petersburg\",\"title\":\"SPB\"}]"));
    }

    @Test
    void getRegion() throws Exception {
        mockMvc.perform(get("/region?id=1")).andExpect(status().isOk()).andExpect(content().json("{\"id\":1,\"name\":\"Moscow\",\"title\":\"MSK\"}"));
    }

    @Test
    void addRegion() throws Exception {
        String region = "{\"name\":\"Norilsk\",\"title\":\"NSK\"}";
        mockMvc.perform(post("/region").contentType(MediaType.APPLICATION_JSON).content(region)).andExpect(status().isOk());
    }

    @Test
    void editRegion() throws Exception {
        String region = "{\"id\":1,\"name\":\"Moscow\",\"title\":\"MSKK\"}";
        mockMvc.perform(put("/region").contentType(MediaType.APPLICATION_JSON).content(region)).andExpect(status().isOk());
    }

    @Test
    void deleteRegion() throws Exception {
        mockMvc.perform(delete("/region?id=2")).andExpect(status().isOk());
    }
}