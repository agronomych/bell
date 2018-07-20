package ru.agronomych.bellProject.organization.service;

import ru.agronomych.bellProject.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    List<OrganizationView> organizations();

    void saveOrganization(OrganizationView organization);

    void updateOrganization(OrganizationView organization);

    OrganizationView loadById(int id);
}
