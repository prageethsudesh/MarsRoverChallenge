package com.texus.devtest.mrc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.texus.devtest.mrc.controller.RoverController;

@SpringBootTest
public class SmokeTest {
    
    @Autowired
    private RoverController roverController;
    
    @Test
    public void contextLoads() throws Exception {
        assertThat(roverController).isNotNull();
    }

}
