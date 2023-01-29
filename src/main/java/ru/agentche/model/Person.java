package ru.agentche.model;

import javax.validation.constraints.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 27.12.2022
 */

public class Person {
    private int id;
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 30, message = "The name must contain a minimum of 2 and a maximum of 30 characters")
    private String name;
    @Min(value = 0, message = "Age must not be negative")
    private int age;
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in the format: Country, City, Post Code (6 digits)")
    private String address;

    public Person() {

    }

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
