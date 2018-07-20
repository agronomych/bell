package ru.agronomych.bellProject.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.organization.dao.OrganizationDao;
import ru.agronomych.bellProject.organization.view.OrganizationView;

import java.util.List;

public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao){
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationView> organizations(){
        List<OrganizationView> organizations = null;
        return organizations;
    }

    @Override
    public void saveUser(OrganizationView organization){

    }

    @Override
    public void updateUser(OrganizationView organization){

    }

    @Override
    public OrganizationView loadById(int id){
        OrganizationView organization = null;
        return organization;
    }
}
