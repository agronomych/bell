package ru.agronomych.bellProject.user.view;

public class UserView {

    public Integer id;

    public Integer version;

    public Integer officeId;

    public String firstName;

    public String lastName;

    public String middleName;

    public String position;

    public Integer docCode;

    public Integer citizenshipCode;

    public String phone;

    public String docName;

    public String docNumber;
    
    public java.util.Date docDate;

    public String citizenshipName;

    public Boolean isIdentified;

    @Override
    public String toString(){
        return "name"+" lastName"+" middleName,"+" docName,"+" docNumber,"+" docDate";
    }
}
