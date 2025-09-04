package _02_ex;

public class InventorySystem {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager inventoryManager = new InventoryManager();

        initProducts(inventoryManager);

        System.out.println("===== 初始库存 =====");
        for (Product p : inventoryManager.getAllProducts()) {
            System.out.println(p);
        }
        System.out.println("===================\n");

        int threadCount = 5;
        int operationsPerThread = 10;

        UserOperationThread[] threads = new UserOperationThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new UserOperationThread(inventoryManager," 用户线程-"+(i+1),operationsPerThread);
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("\n==== 最终库存 ====");
        for (Product p : inventoryManager.getAllProducts()) {
            System.out.println(p);
        }

        System.out.println("================");
    }

    private static void initProducts(InventoryManager inventoryManager) {
        inventoryManager.addProduct(new Product("S001","M14",99));
        inventoryManager.addProduct(new Product("S002","M16A4",99));
        inventoryManager.addProduct(new Product("S003","M250",99));
        inventoryManager.addProduct(new Product("S004","K416",99));
        inventoryManager.addProduct(new Product("S005","K437",99));
        inventoryManager.addProduct(new Product("S006","AKM",99));
        inventoryManager.addProduct(new Product("P001","7.62x61mm",9999));
        inventoryManager.addProduct(new Product("P002","7.62x39mm",9999));
        inventoryManager.addProduct(new Product("P003","5.56x45mm",9999));
        inventoryManager.addProduct(new Product("P004",".300",9999));
        inventoryManager.addProduct(new Product("P005","6.28x71mm",9999));

    }
}
