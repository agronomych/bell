package ru.agronomych.bell_project.office.model;

import ru.agronomych.bell_project.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Office {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    private Integer orgId;

    private String phone;

    private Boolean isActive;

    private String address;

    @OneToMany(mappedBy = "office")
    private List<User> users;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }
}
