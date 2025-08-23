package _01_继承练习;

public class Fu {
    private String name;
    private int age;
    private String birthday;

    public Fu() {
        System.out.println("父类的空参构造方法执行了...");
    }

    public Fu(String name, int age, String birthday) {
        System.out.println("父类的带参数构造方法执行力...");
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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


    public String show1() {
        return "Fu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
