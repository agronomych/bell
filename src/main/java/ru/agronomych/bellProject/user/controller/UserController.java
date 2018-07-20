package ru.agronomych.bellProject.user.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.bellProject.user.service.UserService;
import ru.agronomych.bellProject.user.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "getUsers", nickname = "getUsers", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public void listUsers(@RequestBody List<UserView> users) {
        users = userService.users();
    };

    //@RequestMapping("/save")
    @ApiOperation(value = "saveUser", nickname = "saveUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public void saveUser(@RequestBody UserView user) {
        userService.saveUser(user);
    };

    //@RequestMapping("/update")
    @ApiOperation(value = "updateUser", nickname = "updateUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public void updateUser(@RequestBody UserView user) {
        userService.updateUser(user);
    };

    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Object get(@RequestParam() int id) {
        return id;
    }
    public UserView loadById(){
        UserView user = null;

        return user;
    }
}
