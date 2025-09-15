package _03_类加载器;

public class t31 {
    public static void main(String[] args) {
        Class<t31> aClass = t31.class;

        ClassLoader app = aClass.getClassLoader();
        System.out.println(app);

    }
}
