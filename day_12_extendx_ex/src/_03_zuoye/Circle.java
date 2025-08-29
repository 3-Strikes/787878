package _03_zuoye;

public class Circle extends Shape{
    private int r ;

    public final double PI = 3.14;
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Circle(int r) {
        this.r=r;
    }

    @Override
    public void area() {
        double s = Math.PI*r*r;
        System.out.println("圆的面积为："+s);
    }

    @Override
    public void perimeter() {
        double l = Math.PI*r*2;
        System.out.println("圆的周长为："+l);
    }
}
