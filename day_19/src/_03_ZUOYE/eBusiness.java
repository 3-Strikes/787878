package _03_ZUOYE;

import java.util.*;

public class eBusiness {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();
        addAllProduct(products);
        findByPrice(products,100,500);
        findProductCategory(products,"电子产品");
        countCategory(products);
    }

    public static <T>void addAllProduct(HashSet<Product> hashSet){
        List<Product> product = new ArrayList<>();
        product.add(new Product("P001", "小米手机", 2999, "电子产品"));
        product.add(new Product("P002", "华为平板", 3999, "电子产品"));
        product.add(new Product("P001", "小米手机（重复）", 2899, "电子产品"));
        product.add(new Product("P003", "耐克运动鞋", 699, "服饰"));
        product.add(new Product("P002", "华为平板（重复）", 4099, "电子产品"));
        product.add(new Product("P004", "阿迪T恤", 199, "服饰"));
        product.add(new Product("P005", "美的冰箱", 2499, "家电"));
        hashSet.addAll(product);
        System.out.println("===== 去重后商品列表 =====");
        for (Product p : hashSet){
            System.out.println(p);
        }
        System.out.println("\n按SKU降序（匿名Comparator）：");
        Collections.sort(product, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getSku().compareTo(o1.getSku());
            }
        });
        for (Product p : product){
            System.out.println(p);
        }
    }

    public static void findProductCategory(HashSet<Product> hashSet,String findname){
        System.out.println("===== "+findname+" =====");
        for (Product product:hashSet){
            if(product.getCategory() == findname){
                System.out.println(product);
            }
        }
    }

    public static void findByPrice(HashSet<Product> hashSet,double minprice,double maxprice){
        System.out.println("===== "+minprice+"-"+maxprice+"元商品 =====");
        for(Product p:hashSet){
            if (p.getPrice()>=minprice&&p.getPrice()<=maxprice){
                System.out.println(p);
            }
        }
    }

    public static void countCategory(HashSet<Product> hashSet){
        int eproduct = 0,cproduct = 0,jdproduct = 0;
        for (Product p : hashSet){
            if(p.getCategory()=="电子产品"){
                ++eproduct;
            }
            if(p.getCategory()=="服饰"){
                ++cproduct;
            }
            if(p.getCategory()=="家电"){
                ++jdproduct;
            }
        }
        System.out.println("===== 类别统计 =====");
        System.out.println("电子产品："+eproduct);
        System.out.println("服饰："+cproduct);
        System.out.println("家电："+jdproduct);
    }

}
