package _01_test;

import java.util.*;

public class t2 {
    public static void main(String[] args) {
        String[] huas = {"♠","♥","♣","♦"};
        String[] dians = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        List<Pai> all = new ArrayList<>();
        int zhi = 1;
        for (String dian : dians) {
            for (String hua : huas) {
                all.add(new Pai(hua,dian,zhi++));
            }
        }
        all.add(new Pai("小","王",zhi++));
        all.add(new Pai("大","王",zhi++));

//        for (Pai pai : all) {
//            System.out.println(pai);
//        }

        Collections.shuffle(all);
        System.out.println();

        TreeSet<Pai> play1 = new TreeSet<>(new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o2.getZhi1()-o1.getZhi1();
            }
        });
        TreeSet<Pai> play2 = new TreeSet<>(new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o2.getZhi1()-o1.getZhi1();
            }
        });
        TreeSet<Pai> play3 = new TreeSet<>(new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o2.getZhi1()-o1.getZhi1();
            }
        });
        TreeSet<Pai> dp = new TreeSet<>();
        int i = 50;
        while(i>0){
            play1.add(all.get(i)); i--;
            play2.add(all.get(i)); i--;
            play3.add(all.get(i)); i--;
        }

        dp.add(all.get(51));
        dp.add(all.get(52));
        dp.add(all.get(53));

        System.out.println("玩家1："+play1);
        System.out.println("玩家2："+play2);
        System.out.println("玩家3："+play3);
        System.out.println("底牌:"+dp);


    }
}
