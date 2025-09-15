package _04_学生管理系统.dao;

import _04_学生管理系统.domain.Student;

import java.util.List;

/*
    对于数据层的操作,只有两个,1个是写数据,另一个是读数据
 */
public interface SDao {
    void writeList(List<Student> list);

    List<Student> readList();
}
