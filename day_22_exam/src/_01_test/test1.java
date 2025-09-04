package _01_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class test1 <T>{
    private T q;

    public test1(T q) {
        this.q = q;
    }

    public T getQ() {
        return q;
    }

    public void setQ(T q) {
        this.q = q;
    }

    public static void main(String[] args) throws RuntimeException,Exception{
        Properties properties = new Properties();
        properties.put(null,null);
        System.out.println(properties);
        List<?> list = new ArrayList<>();
        boolean is = mp();
        
    }

    private static boolean mp() {
        return false;
    }
}
