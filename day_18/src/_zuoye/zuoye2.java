package _zuoye;

import java.util.ArrayList;
import java.util.LinkedList;

public class zuoye2 {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Item item1 = new Item("P001","笔记本电脑",5999.99,10);
        Item item2 =new Item("P002","鼠标",99.99,0);
        Item item3 =new Item("P003","键盘",199.99,20);
        Item item4 =new Item("P004","显示器",1499.99,0);
        Item item5 =new Item("P005","耳机",299.99,15);
        manager.addStock(item1,item2,item3,item4,item5);
        System.out.println("===添加商品后===");
        manager.printAllProducts();

        manager.removeOutStock();
        System.out.println("\n===下架库存为0的商品后===");
        manager.printAllProducts();

        LinkedList<Item> clonedWarehouse = manager.deepCloneItems();

        if(!manager.getWarehouse().isEmpty()){
            manager.getWarehouse().get(0).setStockQuantity(5);
        }

        System.out.println("\n=== 原始仓库(已修改) ===");
        manager.printAllProducts();

        System.out.println("\n=== 深克隆的仓库(未受影响) ===");
        Manager cloneManger = new Manager(clonedWarehouse);
        cloneManger.printAllProducts();

        ArrayList<Item> targetWarehouse = new ArrayList<>();
        manager.transferItems(targetWarehouse,"002","004");
        System.out.println("\n=== 转移商品后，原仓库 ===");
        manager.printAllProducts();

        System.out.println("\n=== 转移商品后，目标仓库 ===");
        System.out.println("目标仓库中的商品列表:");
        for (Item it:targetWarehouse){
            System.out.println(it);
        }


    }




}
