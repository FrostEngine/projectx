package projectx.inheritance;

/**
 * Created by Rommert on 30-11-2014.
 */
public class Car {

    int nrOfWheels;
    int topSpeed;
    int nrOfSeats;

    public Car(int nrOfWheels, int topSpeed, int nrOfSeats) {
        this.nrOfWheels = nrOfWheels;
        this.topSpeed = topSpeed;
        this.nrOfSeats = nrOfSeats;
    }

    public int getNrOfWheels() {
        return nrOfWheels;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }
}
