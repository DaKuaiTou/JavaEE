package com.dkt.entry;

/**
 * @author: dkt
 * @Pcakage: com.dkt.entry.Person
 * @Date: 2022年10月16日 20:25
 * @Description:
 */
public class Person {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String qq;
    private String email;

    public Person() {
    }

    public Person(Integer id, String name, String sex, Integer age, String address, String qq, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.qq = qq;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
