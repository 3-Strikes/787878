package _02_挑战;

import java.util.Map;

public class Student {
    private int id;
    private String name;
    private Map<String,Integer> courseScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(Map<String, Integer> courseScore) {
        this.courseScore = courseScore;
    }

    public Student(int id, String name, Map<String, Integer> courseScore) {
        this.id = id;
        this.name = name;
        this.courseScore = courseScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("学号：").append(id).append("，姓名：").append(name).append("，成绩：");
        for (Map.Entry<String, Integer> entry : courseScore.entrySet()) {
            sb.append(entry.getKey()).append("：").append(entry.getValue()).append("，");
        }
        // 移除最后一个逗号
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
