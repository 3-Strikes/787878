package _10_作业;

import java.io.*;
import java.util.Properties;

public class LazyConfigManager {
    // 1. 懒汉式：声明但不初始化实例
    private static volatile LazyConfigManager instance;
    
    private Properties properties;
    private String currentFilePath;
    
    // 2. 私有化构造方法
    private LazyConfigManager() {
        // 防止反射破坏单例
        if (instance != null) {
            throw new RuntimeException("禁止通过反射创建实例");
        }
        properties = new Properties();
    }
    
    // 3. 提供全局访问点，双重校验锁确保线程安全
    public static LazyConfigManager getInstance() {
        if (instance == null) {
            synchronized (LazyConfigManager.class) {
                if (instance == null) {
                    instance = new LazyConfigManager();
                }
            }
        }
        return instance;
    }
    
    // 加载配置文件
    public void loadConfig(String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("文件路径不能为空");
        }
        
        currentFilePath = filePath;
        File file = new File(filePath);
        
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                properties.load(fis);
            } catch (IOException e) {
                throw new IOException("加载配置文件失败: " + e.getMessage(), e);
            }
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("创建新配置文件: " + filePath);
                }
            } catch (IOException e) {
                throw new IOException("创建配置文件失败: " + e.getMessage(), e);
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
            properties.store(fos, "Config saved at " + System.currentTimeMillis());
        } catch (IOException e) {
            throw new IOException("保存配置文件失败: " + e.getMessage(), e);
        }
    }
}
