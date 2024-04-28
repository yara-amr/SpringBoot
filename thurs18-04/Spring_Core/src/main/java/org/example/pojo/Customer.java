package org.example.pojo;

import org.example.Validators.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    @Size(min=3, message = " minimum size is 3")
    private String firstName;
    @Size(min=3, message = " minimum size is 3")
    private String lastName;
    @Email(message = "email format is incorrect")
    @NotNull
    @NotEmpty
    private String email;
    @Min(value = 20, message = "minimum age is 20")
    private int age;
    private String gender;
    private String country;
    private boolean active;
    @CourseCode(value = "r", message = "must start with r")
    private String code;


    public Customer() {}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer(String firstName, String lastName, String email, int age, String gender, String country, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
