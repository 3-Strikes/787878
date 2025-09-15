package _04_学生管理系统.service;


import _04_学生管理系统.domain.Student;

/*
    学生管理系统的业务层接口
 */
public interface SService {

    public String addStudent(Student student);
    public String deleteStudent(String id);
    public String updateStudent(Student student);

    public String selectAll();
    public String selectByLikeName(String name);

    public int findStudentIndexById(String id);


}
