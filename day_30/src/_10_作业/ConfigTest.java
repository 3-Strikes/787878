package _10_作业;

import java.io.IOException;

public class ConfigTest {
    public static void main(String[] args) {
        // 饿汉式使用
        try {
            HungryConfigManager hungryManager = HungryConfigManager.getInstance();
            hungryManager.loadConfig("config.properties");
            hungryManager.setProperty("username", "admin");
            hungryManager.setProperty("password", "123456");
            hungryManager.saveConfig();
            System.out.println("用户名: " + hungryManager.getProperty("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 懒汉式使用
        try {
            LazyConfigManager lazyManager = LazyConfigManager.getInstance();
            lazyManager.loadConfig("app.properties");
            lazyManager.setProperty("timeout", "3000");
            lazyManager.saveConfig();
            System.out.println("超时时间: " + lazyManager.getProperty("timeout"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}