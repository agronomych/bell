package ru.agronomych.bellProject.user.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.bellProject.user.model.User;
import ru.agronomych.bellProject.user.service.UserService;
import ru.agronomych.bellProject.user.view.UserView;

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
        List<User>
        for(User user:users){

        }
    };

    /*@ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Failed")});*/
    //@GetMapping
}
