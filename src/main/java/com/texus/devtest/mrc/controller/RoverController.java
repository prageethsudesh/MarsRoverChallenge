package com.texus.devtest.mrc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.texus.devtest.mrc.dto.ResponseModel;
import com.texus.devtest.mrc.dto.RoverInstructionDto;
import com.texus.devtest.mrc.exception.InputValidationException;
import com.texus.devtest.mrc.exception.RoverException;
import com.texus.devtest.mrc.service.RoverService;

@Controller
@RequestMapping("/roverAPI/")
public class RoverController {

    @Autowired
    private RoverService roverService;

    @PostMapping("/instruct")
    public ResponseEntity<ResponseModel<String>> moveRover(@RequestBody RoverInstructionDto roverInstructionDto) {

        ResponseModel<String> responseModel = null;
        String response = "";

        try {

            response = roverService.getNewPositionDetails(roverInstructionDto);

            responseModel = new ResponseModel<>(HttpStatus.OK.value(), HttpStatus.OK.name(), response);

        } catch (InputValidationException e) {
            responseModel = new ResponseModel<>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
                    e.getMessage());
        } catch (RoverException e) {
            responseModel = new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getMessage());
        }

        return new ResponseEntity<ResponseModel<String>>(responseModel, HttpStatus.OK);

    }
}
