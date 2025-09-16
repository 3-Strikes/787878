package _学生管理系统.domain;

import java.util.StringJoiner;

/*
    学生管理系统存学生信息的类
 */
public class Student {
    private String id;
    private String name;
    private int age;
    private String birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Student() {
    }

    public Student(String id, String name, int age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        return sj.add(id).add(name).add(String.valueOf(age)).add(birthday).toString();

    }
}
