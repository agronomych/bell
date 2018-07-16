package ru.agronomych.bell_project.countries.model;

import javax.persistence.*;

@Entity
@Table (name = "Countries")
public class Country {

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
