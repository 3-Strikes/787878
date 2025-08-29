package _03_zuoye;

public class Rectangle extends Shape{
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void area() {
        int s = getLength()*getWidth();
        System.out.println("该矩形的面积为："+s);
    }

    @Override
    public void perimeter() {
        int l = getLength()*getWidth();
        System.out.println("该矩形的周长为："+l);
    }
}
