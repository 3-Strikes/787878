package _02_ex;

import java.util.List;
import java.util.Random;

public class UserOperationThread extends Thread{
    private InventoryManager inventoryManager;
    private Random random;
    private int operationCount;

    public UserOperationThread(InventoryManager inventoryManager,String name, int operationCount) {
        super(name);
        this.inventoryManager = inventoryManager;
        this.random = new Random();
        this.operationCount = operationCount;
    }

    @Override
    public void run() {
        List<Product> products = inventoryManager.getAllProducts();
        if(products.isEmpty()){
            System.out.println(getName()+":没有商品可操作");
            return;
        }

        for (int i = 0; i < operationCount; i++) {
            Product product = products.get(random.nextInt(products.size()));
            String productId = product.getId();

            int operationType = random.nextInt(100);

            try {
                if (operationType < 30){
                    int stock = inventoryManager.getStock(productId);
                    System.out.println(getName()+" 查询库存 - "+product.getName()+" 当前库存："+stock);
                }else if(operationType<65){
                    int quantity = random.nextInt(5)+1;
                    inventoryManager.increaseStock(productId,quantity);
                }else {
                    int quantity = random.nextInt(3)+1;
                    inventoryManager.decreaseStock(productId,quantity);

                }
            } catch (InsufficientStockException e) {
                System.out.println(getName()+" 操作失败： "+e.getMessage());
            }catch (Exception e){
                System.out.println(getName()+" 发生错误: "+e.getMessage());
            }


            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(getName()+"操作完成");
    }
}
