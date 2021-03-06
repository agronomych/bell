package ru.agronomych.bellProject.organization.dao;

import ru.agronomych.bellProject.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {


    /**
     * Получить всех organization для списка
     */
    List<Organization> all();

    /**
     * Получить organization по id
     */
    Organization loadById(int id);

    /**
     * Сохранить organization
     */
    void save(Organization organization);

    /**
     * Сохранить organization
     */
    void update(Organization organization);
}
