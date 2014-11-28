package projectx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//init the array to store ways to get richs

		// geldVerdienManieren is een List (interface). De exacte implementatie is een ArrayList, maar dat wil
		// je het liefst geheim houden voor andere code. Daarom definieer je em als List, en niet als ArrayList
		List<String> geldVerdienManieren = new ArrayList<String>();

		//Add ways to get richs
		geldVerdienManieren.add("Een rock band beginnen");
		geldVerdienManieren.add("Alleen maar zealots bouwen en daarna max tempest gaan..");

		//Output the explenation for the UI
		System.out.println("Hoe rijk te worden in 2 stappen:");


		//Output each way through an aweomse for-loop
		for (int i = 0; i < geldVerdienManieren.size(); i++) {
			System.out.println(geldVerdienManieren.get(i));
		}

		//gg, wp sir


		//Output the explenation for the UI, but use the new java 8 stream API
		System.out.println("Hoe rijk te worden in 2 stappen, maar dan met stream API:");
		geldVerdienManieren.stream().forEach(System.out::println);

		// Stream API:
		// someCollection.stream() returns a stream. Stream supports methods like
		// map (for each element, convert it),
		// filter (build a new stream with only the elements for which the given method returns true)
		// forEach (call a method for each element in the stream)
		// etc
		// A combination is cool too. For instance, give a number of cars, print the brands of those that are excellent
		// and the name is shorter then 6 letters

		Car skoda = new Car(true, "Skoda");
		Car fiat = new Car(false, "Fiat");
		Car mercedes = new Car(true, "Mercedes");
		Car volkswagen = new Car(true, "Volkswagen");
		List<Car> cars = new ArrayList<>();
		cars.addAll(Arrays.asList(skoda, fiat, mercedes, volkswagen));

		System.out.println("Auto's die excellent zijn en een naam hebben van minder dan 6 tekens:");
		cars.stream() // get a stream,
				.filter(c->c.isExcellent()) // filter on excellence and create a new stream with only those elements
				.filter(c -> c.getName().length() < 6) // filter on name length and create a new stream with only those elements
				.map(c->c.getName()) // get the names instead of the cars and create a new stream with only those elements
				.forEach(System.out::println); // print each element in your stream
	}

	private static class Car {
		private boolean isExcellent;
		private String name;

		public Car(boolean isExcellent, String name) {
			this.isExcellent = isExcellent;
			this.name = name;
		}

		public boolean isExcellent() {
			return isExcellent;
		}

		public String getName() {
			return name;
		}
	}
}
