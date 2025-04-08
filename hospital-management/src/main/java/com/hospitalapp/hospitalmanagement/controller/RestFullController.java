package com.hospitalapp.hospitalmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "api/requests")
@ResponseBody
public class RestFullController {

    @GetMapping(value = "/get")
    public String getInfo(){
        return "GET info";
    }

    //Enum Constants
    @GetMapping(value = "/get-error")
    public ResponseStatusException getInfoError(){
        return new ResponseStatusException(HttpStatus.NOT_FOUND,"Error - NOT FOUND");
    }

    @PostMapping(value = "/post")
    public String postInfo(){
        return "POST info";
    }

    @GetMapping(value = "/post-error")
    public ResponseStatusException postInfoError(){
        return new ResponseStatusException(HttpStatus.NOT_FOUND,"Error - NOT FOUND");
    }

    @PutMapping(value = "/put")
    public String putInfo() {
        try {
            int x = 1 / 0;
            return "PUT info";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.REQUEST_TIMEOUT,"Error - NOT FOUND");
        }
    }

    @DeleteMapping(value = "/delete")
    public String deleteInfo() {
        try {
            int x = 1 / 0;
            return "DELETE info";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error - NOT FOUND");
        }
    }
}

