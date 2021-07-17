package com.example.library.library.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Author {

    private Long pid;

    private String firstName;

    private String middleName;

    private String lastName;

    private Date birthday;

    private String sex;

    public Author() {
    }

    public Author(Long pid, String firstName, String middleName, String lastName, Date birthday, String sex) {
        this.pid = pid;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String dateHelper(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(birthday);
    }
}
