package _01_ENUM类;

import java.util.Arrays;

public class t11 {

    public static void main(String[] args) {
        method(Sex.Other);

        System.out.println(Sex.Man.compareTo(Sex.Other));

        Sex sex = Enum.valueOf(Sex.class,"Man");
        sex.ab();

        Sex[] arr = Sex.values();
        System.out.println(Arrays.toString(arr));


    }

    public static void method(Sex sex){
        System.out.println("得到的性别信息是："+sex);
        sex.ab();

        System.out.println(sex.name());
        System.out.println(sex.ordinal());
    }
}
