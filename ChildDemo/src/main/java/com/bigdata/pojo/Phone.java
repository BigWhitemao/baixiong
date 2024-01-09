package com.bigdata.pojo;

/**
 * @author maomao
 * @date 2024/1/8 18:32
 * @description Phone
 */

public class Phone {
    private int id;
    private String number;
    private String sex;
    private int age;

    public Phone() {
    }

    public Phone(String number, String sex, int age) {
        this.number = number;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "电话号码=" + number +
                ", 性别=" + sex +
                ", 年龄=" + age;
    }
}
