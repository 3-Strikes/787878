package _03_zuoye;

public class Square extends Shape{
    private int len;
    public Square(int len) {
        super(len,len);
    }
    @Override
    public void area() {
        int s = getLength()*getWidth();
        System.out.println("正方形的面积为："+s);
    }

    @Override
    public void perimeter() {
        int l = getLength()*4;
        System.out.println("正方形的周长为："+l);
    }
}
