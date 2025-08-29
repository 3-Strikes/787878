package _考试.code4;

public class Bike implements Vehicle{
    private int speed;

    public Bike(int speed) {
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
        System.out.println("自行车以 "+getSpeed()+"km/h 行驶");
    }


}
