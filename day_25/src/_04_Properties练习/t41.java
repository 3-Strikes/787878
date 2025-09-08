package _04_Properties练习;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class t41 {
    public static void main(String[] args) throws IOException {
        load();
    }
    public static void load() throws IOException{
        Properties p = new Properties();
        p.setProperty("666","shabi,大");
        p.setProperty("777","doubi,大");
        p.setProperty("888","huaibi,大");

        FileWriter fw = new FileWriter("e/5.txt");

        p.store(fw,"没什么好说的");
        fw.close();

    }
}
