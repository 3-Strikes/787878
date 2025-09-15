package _01_JDK动态代理;

/*
    动态代理案例中的  目标类
 */
public class YCY implements Star{
    @Override
    public void sing() {
        System.out.println("杨超越唱歌了...");
    }

    @Override
    public void dance() {
        System.out.println("杨超越跳舞了...");
    }

    @Override
    public void smail() {
        System.out.println("杨超越微笑了...");
    }
}
