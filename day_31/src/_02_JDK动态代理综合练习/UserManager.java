package _02_JDK动态代理综合练习;

public class UserManager implements JK{
    @Override
    public String login(String username, String password) {
        System.out.println(username+"开始执行登录了...密码是:"+password);
        return username+"登录成功!";
    }

    @Override
    public void delete(String username) {
        System.out.println("删除了:"+username);
    }

    @Override
    public String select() {
        System.out.println("查询了...");
        return "张三丰";
    }
}
