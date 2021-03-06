package ru.agronomych.bellProject.countries.dao;

import ru.agronomych.bellProject.countries.model.Country;

import java.util.List;

/**
 * DAO для работы с Country
 */

public interface CountryDao {
    /**
     * Получить все объекты Country
     *
     * @return
     */
    List<Country> all();

    /**
     * Получить имя страны name по коду code
     *
     * @param code
     * @return
     */
    Country loadByCode(Integer code);

    /**
     * Сохранить Country
     *
     * @param country
     */
    void save(Country country);
}
