package projectx.inheritance;

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
        showCar(raceCar);
    }

    private void showCar(Car car) {
        System.out.printf("Nr of wheels: %s, topSpeed: %s, nr of seats: %s\n", car.getNrOfWheels(), car.getTopSpeed(), car.getNrOfSeats());
    }

    private void showCar(RaceCar raceCar) {
        System.out.printf("Showing racecar: nr of wheels: %s, topSpeed: %s, nr of seats: %s, spoiler type: %s\n",
                raceCar.getNrOfWheels(),
                raceCar.getTopSpeed(),
                raceCar.getNrOfSeats(),
                raceCar.getSpoilerType());
    }
}
