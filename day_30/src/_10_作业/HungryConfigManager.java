package _10_作业;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class HungryConfigManager {
    //1.饿汉式：类加载时就创建实例
    private static final HungryConfigManager INSTANCE= new HungryConfigManager();
    private Properties properties;
    private String currentFilePath;

    //2.私有化构造方法，防止外部实例化
    private HungryConfigManager(){
        if(INSTANCE !=null){
            throw new RuntimeException("禁止通过反射创建实例");
        }
        properties = new Properties();
    }

    //3.提供全局访问点
    public static HungryConfigManager getInstance(){
        return INSTANCE;
    }

    public void loadConfig(String filePath) {
        if(filePath==null||filePath.isEmpty()){
            throw new IllegalArgumentException("文件路径不能为空");
        }

        currentFilePath = filePath;
        File file = new File(filePath);

        if(file.exists()){
            try (FileInputStream fis = new FileInputStream(file)){
                properties.load(fis);
            }catch (IOException e){
                e.getMessage();
            }
        } else {
            try {
                if(file.createNewFile()){
                    System.out.println("创建新配置文件："+filePath);
                }
            }catch (IOException e){
                e.getMessage();
            }
        }
    }

    // 获取配置项
    public String getProperty(String key) {
        if (key == null || key.isEmpty()) {
            return null;
        }
        return properties.getProperty(key);
    }

    // 设置配置项
    public void setProperty(String key, String value) {
        if (key != null && !key.isEmpty()) {
            properties.setProperty(key, value);
        }
    }

    // 保存配置到文件
    public void saveConfig() throws IOException {
        if (currentFilePath == null || currentFilePath.isEmpty()) {
            throw new IllegalStateException("请先加载配置文件");
        }

        try (FileOutputStream fos = new FileOutputStream(currentFilePath)) {
            // 保存时添加注释
            properties.store(fos, "Config saved at " + System.currentTimeMillis());
        } catch (IOException e) {
            throw new IOException("保存配置文件失败: " + e.getMessage(), e);
        }
    }
}
