package _03_cglib;

/*
    动态代理案例中的  目标类
 */
public class YCY{
    public void sing() {
        System.out.println("杨超越唱歌了...");
    }

    public void dance() {
        System.out.println("杨超越跳舞了...");
    }

    public void smail() {
        System.out.println("杨超越微笑了...");
    }
}
