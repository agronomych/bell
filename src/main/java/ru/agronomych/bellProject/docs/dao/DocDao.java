package ru.agronomych.bellProject.docs.dao;

import ru.agronomych.bellProject.docs.model.Doc;

import java.util.List;

public interface DocDao {
    /**
    * Получить все объекты Country
    *
    * @return
    */
    List<Doc> all();

    /**
    * Получить имя страны name по коду code
    *
    * @param code
    * @return
    */
    Doc loadByCode(Integer code);

    /**
    * Сохранить Country
    *
    * @param doc
    */
    void save(Doc doc);
}
