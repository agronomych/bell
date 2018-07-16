package ru.agronomych.bellProject.docs.model;

import javax.persistence.*;

@Entity
public class Doc {

    @Id
    private Integer code;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Название страны
     */
    @Column(nullable = false)
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
