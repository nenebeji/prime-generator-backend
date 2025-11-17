package com.nene.primegeneratorbackend.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class PrimeControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        PrimeController primeController = new PrimeController();
        mockMvc = MockMvcBuilders
                .standaloneSetup(primeController)
                .build();
    }

    @Test
    public void testGetPrimesUpToLimit30() throws Exception {
        // Expected result for input 30
        String expectedJson = "{\"primes\":[2,3,5,7,11,13,17,19,23,29],\"initial\":30}";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", 30))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP 200 OK
                .andExpect(MockMvcResultMatchers.content().json(expectedJson)); // Expect the exact JSON array
    }

    @Test
    public void testGetPrimesUpToLimit10() throws Exception {
        // Expected result for input 10
        String expectedJson = "{\"primes\":[2,3,5,7],\"initial\":10}";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", 10))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    public void testGetPrimesLimitTwo() throws Exception {
        // Expected result for boundary input 2
        String expectedJson = "{\"primes\":[2],\"initial\":2}";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", 2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    public void testGetPrimesLimitZeroAndOne() throws Exception {
        // Expected result for inputs 0 and 1 (empty list)
        String expectedJsonForOne = "{\"primes\":[],\"initial\":1}";
        String expectedJsonForZero = "{\"primes\":[],\"initial\":0}";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJsonForOne));

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", 0))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJsonForZero));
    }

    @Test
    public void testInvalidInput_NegativeLimit() throws Exception {
        // Negative input should return an empty list
        String expectedJson = "{\"primes\":[],\"initial\":-5}";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", -5))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    public void testGetPrimesUpToLimitXml() throws Exception {
        // Expected XML result structure based on our PrimeResponse class annotations
        String expectedXml = "<Primes><initial>10</initial><Numbers><PrimeNumber>2</PrimeNumber><PrimeNumber>3</PrimeNumber><PrimeNumber>5</PrimeNumber><PrimeNumber>7</PrimeNumber></Numbers></Primes>";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{num}", 10)
                        .accept(MediaType.APPLICATION_XML)) // Request XML
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.content().xml(expectedXml));
    }

}

