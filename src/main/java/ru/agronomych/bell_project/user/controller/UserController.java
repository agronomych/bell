package ru.agronomych.bell_project.user.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.bell_project.user.model.User;
import ru.agronomych.bell_project.user.service.UserService;
import ru.agronomych.bell_project.user.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user/", produces = APPLICATION_JSON_VALUE)
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "getUsers", nickname = "getUsers", httpMethod = "POST")
    @PostMapping("/list")
    public void users(@RequestBody List<UserView> users) {
        for(User user:users){

        }
    };

    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Failed")});
    @GetMapping
}
