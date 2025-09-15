package _08_简单工厂;
/*
    自定义的工厂类,可以创建 多个 USB 对象
 */
public class MyFactory {

    private MyFactory(){

    }

    public static Object getObject(String name) throws  Exception {
        /*if("mouse".equals(name)){
            return  new  Mouse();
        }else if("KB".equals(name)){
            return new KB();
        }else {
            return null;
        }*/
        // 要求调用者,传递的不是类的名字,传递 类的全路径,可以利用反射的方式,创建对象,可以大大的提升程序的扩展
        // 根据全路径获取字节码文件
        Class<?> c = Class.forName(name);
        return  c.newInstance();
    }

}
