package _01_lamda;

import java.util.function.Function;
import java.util.function.Predicate;

public class t12 {
    public static void main(String[] args) {
//        m3(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer t){
//                return "字符串"+t;
//            }
//        },666);

        m4(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>3;
            }
        },"abcdasd");

    }

    public static <T,R> void m3(Function<T,R> f,T t){
        R r = f.apply(t);
        System.out.println("自定义的方法，利用f对象，把参数转化"+t+"转换成了"+r);
    }

    public static <T> void m4(Predicate<T> p,T t){
        boolean test = p.test(t);
        System.out.println("面向p对象，掉用重写后的test方法，传递了:"+t+"得到了："+test);
    }
}
