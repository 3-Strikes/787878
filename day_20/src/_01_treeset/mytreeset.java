package _01_treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class mytreeset {
    public static void main(String[] args) {
        TreeSet<Phone> phoneTreeSet = new TreeSet<>(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return o2.getPrice()-o1.getPrice();
            }
        });
        phoneTreeSet.add(new Phone(123,"小米"));
        phoneTreeSet.add(new Phone(1233,"华为"));
        phoneTreeSet.add(new Phone(1234,"小米"));

        System.out.println(phoneTreeSet);
    }



}
