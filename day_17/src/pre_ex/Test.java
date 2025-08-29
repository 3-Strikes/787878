package pre_ex;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("8988998078978979790789");
        System.out.println(b1);
        BigInteger b2 = new BigInteger("3289471239805714359878923475198");
        //不能有非数字符号！！！
        BigInteger b3 = b1.add(b2);
        System.out.println(b3);

        BigInteger b4 = b2.subtract(b1);
        System.out.println(b4);

        BigInteger b5 = b1.multiply(b2);
        System.out.println(b5);

        BigInteger b6 = b1.divide(b2);
        System.out.println(b6);


        /*
            使用double完成加减乘除运算

            问题: 出现损失精度的问题

            不允许: 钱的问题

            解决方案: 使用java.math.BigDecimal类

         */
        double d1 = 0.03;
        double d2 = 0.02;
        System.out.println(d1 + d2);
        System.out.println(d1 - d2);
        System.out.println(d1 * d2);
        System.out.println(d1 / d2);

        /*
            java.math.BigDecimal类: 代表超级大的小数,不可变的任意精度的小数。
            1.构造方法:
                public BigDecimal(String val):
                    作用: 把构造方法参数String类型的val,转换成BigDecimal类的对象
                    参数: 必须是String类型的数字,内部不能出现非数字内容

            2.常用方法:
                数学运算中最常用的就是+,-,*,/,所以对于BigDecimal类提供了对应的方法
                对于+,-,*这些运算和BigInteger是一样的,就不再演示了
                但是对于 除法 运算,可能会出现 无限循环/无限不循环的结果
                然而BigDecimal是用来完成超级精确的数学运算,这样就导致
                BigDecimal不知道到底给你什么样的结果?
                解决方案:
                    (1)告诉它保留多少位小数
                    (2)如何保留小数

                public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode):
                    按照方法参数指定的保留位数以及保留方式做除法运算
                    参数:
                         int scale: 要保留几位小数
                         int roundingMode: 如何保留小数
                                BigDecimal.ROUND_UP 向上加1。
                                BigDecimal.ROUND_DOWN 直接舍去。
                                BigDecimal.ROUND_HALF_UP 四舍五入。
        */
        BigDecimal b1c = new BigDecimal("10.0");

        BigDecimal b2c = new BigDecimal("3.0");
        BigDecimal b3c = b1c.divide(b2c,8,BigDecimal.ROUND_DOWN);

        System.out.println(b3c);

        ArrayList<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(200);

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            System.out.println(num);
        }
        Integer i1 = 300;
        Integer i2 = Integer.valueOf("3000");
        System.out.println(i1);
        System.out.println(i2);

        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toOctalString(i1));
        System.out.println(Integer.toHexString(i1));

//        Zi zi = new Zi();
//        zi.method();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("jack");
        list1.add("rose");
        list1.add("lucy");
        list1.add("lili");
        list1.add("hanmeimei");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名:");
        String userName = sc.nextLine();

        try {
            checkUserName(list1,userName);
        }catch (UserNameRegisterException e){
            e.printStackTrace();
        }

        System.out.println("看看其他图片...");
        System.out.println("看看其他视频...");


    }

    private static void checkUserName(ArrayList<String> list1, String userName) throws UserNameRegisterException{
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i).equals(userName)){
                throw new UserNameRegisterException("非常抱歉用户名："+userName+"已经被注册...");
            }
        }
        System.out.println("恭喜您，用户名："+userName+"可以使用...");
    }


}
