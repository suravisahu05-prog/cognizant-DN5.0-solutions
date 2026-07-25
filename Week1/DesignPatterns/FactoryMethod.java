
interface Vehicle {
    void printType();
}


class Car implements Vehicle {
    public void printType() {
        System.out.println("This is a Car");
    }
}

class Bike implements Vehicle {
    public void printType() {
        System.out.println("This is a Bike");
    }
}


class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}


public class FactoryMethodExample {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.getVehicle("car");
        v1.printType();

        Vehicle v2 = VehicleFactory.getVehicle("bike");
        v2.printType();
    }
}
