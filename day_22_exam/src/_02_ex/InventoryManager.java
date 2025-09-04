package _02_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private List<Product> productList;
    private Map<String,Product> productMap;

    public InventoryManager() {
        productList = new ArrayList<>();
        productMap = new HashMap<>();
    }

    //添加商品
    public synchronized void addProduct(Product product){
        productList.add(product);
        productMap.put(product.getId(),product);
    }

    public Product getProductById(String id){
        return productMap.get(id);
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(productList);
    }

    public synchronized int getStock(String productId){
        Product product = productMap.get(productId);
        return product!=null? product.getStock() : -1;
    }

    public synchronized void increaseStock(String productId,int quantity){
        Product product = productMap.get(productId);
        if(product!=null && quantity>0){
            product.setStock(product.getStock()+quantity);
            System.out.println(Thread.currentThread().getName()+" 增加库存 - "+product.getName()+" 新增："+quantity+",当前库存："+product.getStock());
        }
    }

    public synchronized void decreaseStock(String productId,int quantity)throws InsufficientStockException {
        Product product = productMap.get(productId);
        if(product==null){
            throw new IllegalArgumentException("商品不存在："+productId);
        }

        if(quantity<=0){
            throw new IllegalArgumentException("减少数量必须为正数："+quantity);
        }

        if(product.getStock()<quantity){
            throw new InsufficientStockException("商品 "+product.getName()+" 库存不足，当前库存： "+product.getStock()+",请求减少："+quantity);
        }

        product.setStock(product.getStock() - quantity);
        System.out.println(Thread.currentThread().getName()+" 减少库存 - "+product.getName()+" 减少："+quantity+"，当前库存： "+product.getStock());
    }

}
