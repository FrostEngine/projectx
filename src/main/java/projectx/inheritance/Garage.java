package projectx.inheritance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rommert on 30-11-2014.
 */
public class Garage {

    private Car simpleCar = new Car(4, 100, 4);
    private Car limo = new Car(8, 90, 12);
    private RaceCar raceCar = new RaceCar(4, 150, 2);


    public static void main(String... args) {
        Garage garage = new Garage();
        garage.showCars();
    }

    private void showCars() {
        // show regular car
        showCar(simpleCar);
        showCar(limo);
        showCar(raceCar); // polymorphism: java knows it needs to call a more specific method for this racecar

        // castedRaceCar is the same(!) object as raceCar, but we only tell java that it's a Car. So java
        // no longer knows about the zwesome spoiler!
        Car castedRaceCar = raceCar;
        showCar(castedRaceCar);

        // Things in list get the type of the list. So adding raceCar to the list will make it a regular car
        List<Car> regularCars = new ArrayList<>();
        regularCars.add(simpleCar);
        regularCars.add(limo);
        regularCars.add(raceCar);

        System.out.println("Showing a list of Car items");
        regularCars.stream().forEach(this::showCar);

        System.out.println("Showing a list of Car items using the showCarWithSpecificDetails method");
        regularCars.stream().forEach(this::showCarWithSpecificDetails);
    }

    private void showCar(Car car) {
        System.out.printf("Showing regular car: nr of wheels: %s, topSpeed: %s, nr of seats: %s\n", car.getNrOfWheels(), car.getTopSpeed(), car.getNrOfSeats());
    }

    private void showCar(RaceCar raceCar) {
        System.out.printf("Showing racecar: nr of wheels: %s, topSpeed: %s, nr of seats: %s, spoiler type: %s\n",
                raceCar.getNrOfWheels(),
                raceCar.getTopSpeed(),
                raceCar.getNrOfSeats(),
                raceCar.getSpoilerType());
    }

    private void showCarWithSpecificDetails(Car car) {
        // show regular car
        System.out.printf("Showing regular car: nr of wheels: %s, topSpeed: %s, nr of seats: %s\n", car.getNrOfWheels(), car.getTopSpeed(), car.getNrOfSeats());
        // if car is in fact a RaceCar, do additional stuff!
        if (car instanceof RaceCar) {
            RaceCar raceCar = (RaceCar) car;
            System.out.printf("Oh, btw, this looks like a RaceCar, and the spoiler is %s!!!", raceCar.getSpoilerType());
        }
    }
}
