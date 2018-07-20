package ru.agronomych.bellProject.office.dao;

import ru.agronomych.bellProject.office.model.Office;

import java.util.List;

public interface OfficeDao {
    
    /**
     * Получить всех office для списка
     */
    List<Office> all();

    /**
     * Получить office по id
     */
    Office loadById(int id);

    /**
     * Сохранить office
     */
    void save(Office office);

    /**
     * Сохранить office
     */
    void update(Office office);
}
