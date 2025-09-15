package _08_反射的综合练习;

public class Test {
    public static void main(String[] args) throws Exception {
        // 使用刚刚自己编写的工具类,让工具帮我们执行 A 类和B类的 a 方法和 b 方法
        System.out.println(MyTool.myInvokeMethod());
    }
}
