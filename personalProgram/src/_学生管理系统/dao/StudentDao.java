package _学生管理系统.dao;

import _学生管理系统.domain.Student;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//数据处理层
public class StudentDao implements StuDao{
    private File file = new File("_学生管理系统/stu.txt");
    @Override
    public void writeList(List<Student> list) {
        System.out.println(file.exists());
        FileUtil.writeLines(list,file,"utf-8");
    }

    @Override
    public List<Student> readList() {
        List<String> list = FileUtil.readLines(file, "utf-8");
        List<Student> list1 = list.stream().map(s -> {
            if (s != null && s.length() > 0) {
                String[] arr = s.split(",");
                return new Student(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3]);
            }
            return null;
        }).toList();

        return new ArrayList<>(list1);
    }
}
