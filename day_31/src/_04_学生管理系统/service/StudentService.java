package _04_学生管理系统.service;


import _04_学生管理系统.dao.SDao;
import _04_学生管理系统.dao.StudentDao;
import _04_学生管理系统.domain.Student;

import java.util.List;

public class StudentService implements SService{

    // 涉及一个 dao层的对象,用于从文件中读数据或写数据
    private SDao dao = new StudentDao();
    private List<Student> list ;
    {
        list= dao.readList();
    }

    @Override
    public String addStudent(Student student) {
        list.add(student);
        dao.writeList(list);
        return "添加成功";
    }

    @Override
    public String deleteStudent(String id) {
        int index = findStudentIndexById(id);
        if(index == -1){
            return id+"对应的学生不存在,删除失败!";
        }
        Student remove = list.remove(index);
        dao.writeList(list);
        return "删除:"+remove.getName()+"成功!";
    }

    @Override
    public String updateStudent(Student student) {
        // 将来在表现层获取对象之后,直接通过调用对象的  setXxx方法,就可以影响list集合中对象的内容,直接更新数据库即可
        int index = findStudentIndexById(student.getId());
        list.set(index,student);
        dao.writeList(list);
        return "修改成功....";
    }

    @Override
    public String selectAll() {
        if(list.size() == 0){
            return "暂无数据,请添加后查询...";
        }
        StringBuilder sb = new StringBuilder("---------------全部学生信息如下------------\r\n");
        sb.append("学号\t\t姓名\t\t年龄\t\t生日\r\n");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            sb.append(student.getId()).append("\t\t").append(student.getName())
                    .append("\t\t").append(student.getAge()).append("\t\t").append(student.getBirthday());
            sb.append("\r\n");
        }
        sb.append("-----------------------------------------");
        return sb.toString();
    }

    @Override
    public String selectByLikeName(String name) {
        if(list.size() == 0){
            return "暂无数据,请添加后查询...";
        }
        StringBuilder sb = new StringBuilder("---------------包含:"+name+"的学生信息如下------------\r\n");
        sb.append("学号\t\t姓名\t\t年龄\t\t生日\r\n");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if(student.getName().contains(name)){
                sb.append(student.getId()).append("\t\t").append(student.getName())
                        .append("\t\t").append(student.getAge()).append("\t\t").append(student.getBirthday());
                sb.append("\r\n");
            }
        }
        sb.append("---------------------------------------------");
        return sb.toString();
    }

    @Override
    public int findStudentIndexById(String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SService service = new StudentService();
        String s = service.addStudent(new Student("3", "王五", 20, "2011-11-11"));
        service.addStudent(new Student("1", "张五", 20, "2011-11-11"));
        service.addStudent(new Student("2", "张五流", 20, "2011-11-11"));
        //System.out.println(s);

       // String s = service.deleteStudent("4");
        //System.out.println(s);

        System.out.println(service.selectAll());
        System.out.println(service.selectByLikeName("张"));

    }
}
