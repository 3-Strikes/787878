//package _09_xml;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//
//import java.io.File;
//import java.util.List;
//
///*
//    使用 Dom4j 解析 a.xml 文件
// */
//public class MyXmlParse {
//    public static void main(String[] args) throws  Exception {
//        // 1: 创建解析器对象
//        SAXReader reader = new SAXReader();
//        // 2: 读文件,得 文档对象
//        Document document = reader.read(new File("xml/a.xml"));
//        // 3: 获取根
//        Element root = document.getRootElement();
//        // 4: 面向根,获取根下的两个子标签
//        List<Element> list = root.elements();
//        //System.out.println(list);
//        for (Element user : list) {
//            // 面向 user 标签,可以获取 id 属性的值
//            String id = user.attributeValue("id");
//            // 获取 user下,name的内容
//            String name = user.elementText("name");
//            // 先获取 age 标签,再利用 getTxt获取文本
//            Element age = user.element("age");
//            String ageText = age.getText();
//            System.out.println(user.getName()+"标签下的name标签的内容是:"+name+",age标签的内容是:"+ageText+",id属性的值是:"+id);
//            // 尝试获取 hobby
//            Element hobby = user.element("hobby");
//            if(hobby != null){
//                String hobbyText = hobby.getText();
//                System.out.println("hobby的值是:"+hobbyText);
//            }
//        }
//    }
//}
