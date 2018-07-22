package ru.agronomych.bellProject.user.model;

import ru.agronomych.bellProject.office.model.Office;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    private Integer officeId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String position;

    private Integer citizenshipId;

    private  Integer docId;

    private String phone;

    private String docNumber;

    @Temporal(TemporalType.DATE)
    private java.util.Date docDate;

    private Boolean isIdentified;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Office office;

    public User(){

    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getCitizenshipId() {
        return citizenshipId;
    }

    public void setCitizenshipId(Integer citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Integer getId() {
        return id;
    }
}
