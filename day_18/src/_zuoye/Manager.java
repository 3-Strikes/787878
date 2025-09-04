package _zuoye;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Manager {
    private LinkedList<Item> warehouse;
    public Manager(){
        this.warehouse = new LinkedList<>();
    }

    public Manager(LinkedList<Item> warehouse) {
        this.warehouse = warehouse;
    }

    public void addStock(Item...items){
        for (Item it:items){
            warehouse.add(it);
        }
    }

    public void removeOutStock(){
        warehouse.removeIf(item -> item.getStockQuantity() == 0 );
    }

    public LinkedList<Item> deepCloneItems(){
        LinkedList<Item> cloneList= new LinkedList<>();
        for (Item it:warehouse){
            cloneList.add(it.clone());
        }
        return cloneList;
    }

    public void transferItems(ArrayList<Item> targetWarehouse,String...itemIds){
        List<Item> toTransfer = new LinkedList<>();
        for (Item item : warehouse){
            for (String id : itemIds){
                if(item.getId().equals(id)){
                    toTransfer.add(item);
                    break;
                }
            }
        }
        warehouse.removeAll(toTransfer);
        targetWarehouse.addAll(toTransfer);
    }

    public LinkedList<Item> getWarehouse(){
        return warehouse;
    }

    public void printAllProducts(){
        System.out.println("仓库中的商品列表:");
        for (Item item:warehouse){
            System.out.println(item);
        }
    }


}
