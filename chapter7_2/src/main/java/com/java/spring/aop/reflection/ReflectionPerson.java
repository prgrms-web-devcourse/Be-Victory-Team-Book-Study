package com.java.spring.aop.reflection;

public class ReflectionPerson {

    private String name;
    private Integer age;
    private String address;

    ReflectionPerson(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    ReflectionPerson() {};

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

