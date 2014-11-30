package main.java.projectx.inheritance;

/**
 * Created by Rommert on 30-11-2014.
 */
public class RaceCar extends Car {

    String spoilerType;

    public RaceCar(int nrOfWheels, int topSpeed, int nrOfSeats) {
        super(nrOfWheels, topSpeed, nrOfSeats);
        spoilerType = "Awesome!";
    }

    public String getSpoilerType() {
        return spoilerType;
    }
}
