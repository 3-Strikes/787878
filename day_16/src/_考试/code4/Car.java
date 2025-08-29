package _考试.code4;

public class Car implements Vehicle{
    private int speed;

    public Car(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void move() {
        System.out.println("汽车以 "+getSpeed()+"km/h 行驶");
    }

    public void hoke(){
        System.out.println("汽车鸣笛：嘀嘀");
    }
}
