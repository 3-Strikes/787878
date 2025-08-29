package _考试;

public class test {
    public static void main(String[] args) {
        String t = "测试打印";
        Task tt = new Task() {
            @Override
            public void execute(String param) {
                System.out.println(param);
            }
        };
        tt.execute(t);
    }
}
