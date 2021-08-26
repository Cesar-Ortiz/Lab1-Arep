package edu.eci.SprintBootRestApi.controller;

import edu.eci.SprintBootRestApi.data.User;
import edu.eci.SprintBootRestApi.dto.UserDto;
import edu.eci.SprintBootRestApi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return userService.all();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById(@PathVariable String id )
    {
        return userService.findById(id);
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        try {

            User user = new User(id, userDto.getName(), userDto.getEmail(), userDto.getLastName(), userDto.getCreatedAt());
            return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
    {
        try {
            User user = new User(id, userDto.getName(), userDto.getEmail(), userDto.getLastName(), userDto.getCreatedAt());
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(user, id));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete(@PathVariable String id )
    {
        try {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
