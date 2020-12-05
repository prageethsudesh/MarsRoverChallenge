package com.texus.devtest.mrc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.texus.devtest.mrc.dto.RoverInstructionDto;
import com.texus.devtest.mrc.service.RoverService;

@SpringBootTest
public class RoverServiceTest {
    
    @Autowired
    private RoverService roverService;
    
    @Test
    public void contextLoads() throws Exception {
        
        RoverInstructionDto roverInstructionDto = new RoverInstructionDto();
        roverInstructionDto.setUpperRightCoordinates("5 5");
        roverInstructionDto.setPosition("1 2 N");
        roverInstructionDto.setInstructions("LMLMLMLMM");
        
        assertThat(roverService.getNewPositionDetails(roverInstructionDto))
        .isEqualTo("1 3 N");
    }

}
