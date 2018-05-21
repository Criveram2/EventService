package com.cloud.event.controller;

import com.cloud.event.domain.Users;
import com.cloud.event.dto.EventDTO;
import com.cloud.event.dto.UserDTO;
import com.cloud.event.service.UserService;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/email/{email}/password/{password}", method = RequestMethod.GET)
    public ResponseEntity findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password){

        Option<UserDTO> user = userService.findUserByEmailAndPassword(email, password);
        if(user.isDefined()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO){
        boolean isCreated = userService.saveUser(userDTO);
        if (isCreated) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity findUserByEmailAndPassword(@RequestBody UserDTO userDTO){

        Option<UserDTO> user = userService.findUserByEmailAndPassword(userDTO.getEmail().toUpperCase(), userDTO.getPassword());
        if(user.isDefined()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
