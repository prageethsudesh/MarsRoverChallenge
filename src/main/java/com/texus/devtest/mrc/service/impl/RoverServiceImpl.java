package com.texus.devtest.mrc.service.impl;

import org.springframework.stereotype.Service;

import com.texus.devtest.mrc.dto.RoverInstructionDto;
import com.texus.devtest.mrc.entity.Rover;
import com.texus.devtest.mrc.exception.InputValidationException;
import com.texus.devtest.mrc.exception.RoverException;
import com.texus.devtest.mrc.service.RoverService;

@Service
public class RoverServiceImpl implements RoverService {

    private Rover rover;
    private int x;
    private int y;
    private int maxX;
    private int maxY;
    private String positionChar;

    @Override
    public void initiateRover(String position, String instruuctions) throws RoverException {
        try {
            this.rover = new Rover();
            this.rover.setPosition(x, y, positionChar);
            this.rover.process(instruuctions);
        } catch (Exception e) {
            throw new RoverException("Error Occured. please Check  your input formats");
        }

    }

    @Override
    public void validatePosition(String position, String instruuctions, String upperRightCoordinates)
            throws InputValidationException {

        // Validate upper Righ tCoordinates
        String[] maxCoordinatesArray = upperRightCoordinates.split("\\s+");
        if (maxCoordinatesArray.length == 2
                && (maxCoordinatesArray[0].trim().length() == 1 && Character.isDigit(maxCoordinatesArray[0].charAt(0)))
                && (maxCoordinatesArray[1].trim().length() == 1
                        && Character.isDigit(maxCoordinatesArray[1].charAt(0)))) {

            this.maxX = Integer.parseInt(maxCoordinatesArray[0].trim());
            this.maxY = Integer.parseInt(maxCoordinatesArray[1].trim());

        } else {
            throw new InputValidationException(
                    "Wrong Upper Right Coordinates :  Please give two  + integers  separated with space");

        }

        // Validate position
        String[] positionInfoArray = position.split("\\s+");
        if (positionInfoArray.length == 3
                && (positionInfoArray[0].trim().length() == 1 && Character.isDigit(positionInfoArray[0].charAt(0)))
                && (positionInfoArray[1].trim().length() == 1 && Character.isDigit(positionInfoArray[1].charAt(0)))
                && (positionInfoArray[2].trim().length() == 1 && Character.isLetter(positionInfoArray[2].charAt(0)))) {

            this.x = Integer.parseInt(positionInfoArray[0].trim());
            this.y = Integer.parseInt(positionInfoArray[1].trim());
            positionChar = positionInfoArray[2].trim();

        } else {
            throw new InputValidationException(
                    "Wrong position info :  Please give two  + integers and a letter  separated with space");

        }

        // validate against max Coordinates
        if (x > maxX) {
            throw new InputValidationException(
                    "Instruct X Coordinates " + x + " can not be grater than Max X Coordinates " + maxX);
        }

        if (y > maxY) {
            throw new InputValidationException(
                    "Instruct Y Coordinates " + y + " can not be grater than Max X Coordinates " + maxY);
        }

    }

    @Override
    public String getNewPositionDetails() {
        return this.rover.printPosition(); // prints 5 1 E
    }

    @Override
    public String getNewPositionDetails(RoverInstructionDto roverInstructionDto) throws InputValidationException  , RoverException{
        
        String upperRightCoordinates = roverInstructionDto.getUpperRightCoordinates();
        String position = roverInstructionDto.getPosition();
        String instructions = roverInstructionDto.getInstructions();
        validatePosition(position ,instructions , upperRightCoordinates);
        initiateRover(position ,instructions);
        return getNewPositionDetails();   
    }

}
