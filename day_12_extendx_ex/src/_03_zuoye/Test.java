package _03_zuoye;

public class Test {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(7,8);
        Circle cir = new Circle(6);
        Square squ = new Square(5);

        cir.area();
        cir.perimeter();
        rec.area();
        rec.perimeter();
        squ.area();
        squ.perimeter();

    }
}
