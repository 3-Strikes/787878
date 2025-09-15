package _04_反射构造方法_Constructor;

public class t41 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.
        Class pc = Phone.class;
        Class integarClass = int.class;
        System.out.println(pc);
        System.out.println(integarClass);

        Phone phone = new Phone("大小米");
        Phone phone1 = new Phone("华为i");
        //2.
        Class pc1 = phone.getClass();
        Class pc2 = phone1.getClass();
        System.out.println(pc2);
        System.out.println(pc2==pc1);

        //3.
        Class pc3 =Class.forName("_04_反射构造方法_Constructor.Phone");
        System.out.println(pc3==pc2);

    }
}
