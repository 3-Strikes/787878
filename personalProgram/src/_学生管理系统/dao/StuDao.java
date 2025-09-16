package _学生管理系统.dao;

import _学生管理系统.domain.Student;

import java.util.List;

public interface StuDao {

    void writeList(List<Student> list);
    List<Student> readList();
}
