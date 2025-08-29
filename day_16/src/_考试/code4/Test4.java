package _考试.code4;

public class Test4 {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car(80);
        vehicles[1] = new Bike(15);
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].move();
            if(vehicles[i] instanceof Car){
                ((Car) vehicles[i]).hoke();
            }

        }
    }
}
