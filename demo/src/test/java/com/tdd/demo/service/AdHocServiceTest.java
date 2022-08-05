package com.tdd.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

class AdHocServiceTest {

    @Spy
    @InjectMocks
    AdHocService service;

    @Test
    public void healthCheck() {
        Assertions.assertTrue(true);

        Assertions.assertNotNull(service);
        // don't forget to openMocks!
    }

    @BeforeEach
    public void init(){
      MockitoAnnotations.openMocks(this);
      // consider adding healthcheck method below this init()
    }

}