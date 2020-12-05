package com.texus.devtest.mrc.service;

import com.texus.devtest.mrc.dto.RoverInstructionDto;
import com.texus.devtest.mrc.exception.InputValidationException;
import com.texus.devtest.mrc.exception.RoverException;

public interface RoverService {
    
     void initiateRover(String position, String instruuctions) throws RoverException;
    
     void validatePosition(String position,String instruuctions, String upperRightCoordinates) throws InputValidationException;
    
     String getNewPositionDetails();

     String getNewPositionDetails(RoverInstructionDto roverInstructionDto) throws InputValidationException  , RoverException;

}
