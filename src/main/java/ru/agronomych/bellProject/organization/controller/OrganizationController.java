package ru.agronomych.bellProject.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agronomych.bellProject.organization.model.Organization;
import ru.agronomych.bellProject.organization.service.OrganizationService;
import ru.agronomych.bellProject.organization.view.OrganizationView;

import java.util.List;

public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public void listUsers(@RequestBody List<OrganizationView> organizations) {
        organizations = organizationService.organizations();
    };

    //@RequestMapping("/save")
    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public void saveOrganization(@RequestBody OrganizationView organization) {
        organizationService.saveOrganization(organization);
    };

    //@RequestMapping("/update")
    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public void updateOrganization(@RequestBody OrganizationView organization) {
        organizationService.updateOrganization(organization);
    };

    @ApiOperation(value = "id", nickname = "id",httpMethod = "GET")
    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Object get(@RequestParam() int id) {
        return id;
    }
    public OrganizationView loadById(){
        OrganizationView organization = null;

        return organization;
    }
}
