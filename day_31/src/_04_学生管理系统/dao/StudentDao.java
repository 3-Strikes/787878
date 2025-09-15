package _04_学生管理系统.dao;


import _04_学生管理系统.domain.Student;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
    三层架构中的数据访问层,准备通过这个类 操作项目的相对路径下的  day17/stu.txt 这个文件
 */
public class StudentDao implements SDao{

    private File file = new File("day17/stu.txt");
    @Override
    public void writeList(List<Student> list) {
        System.out.println(file.exists());
        FileUtil.writeLines(list,file,"utf-8");
    }

    @Override
    public List<Student> readList() {
        List<String> list = FileUtil.readLines(file, "utf-8");
        // 利用Stream流,将集合中的字符串,转成学生对象,并返回即可
        List<Student> list1 = list.stream().map(s -> {
            // 把 s 转成 Student
            if (s != null && s.length() > 0) {
                String[] arr = s.split(",");
                return new Student(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3]);
            }
            return null;
        }).toList();
        return new ArrayList<Student>(list1);
    }


   /* @Test
    public void  test1(){
        List<Student> list = List.of(new Student("1", "张三", 18, "2011-11-11"), new Student("2", "李四", 19, "2011-11-11"));
        writeList(list);
    }*/

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        List<Student> list = List.of(new Student("1", "张三", 18, "2011-11-11"), new Student("2", "李四", 19, "2011-11-11"));
        studentDao.writeList(list);
        System.out.println(studentDao.readList());
    }
}
