package projectx;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//init the array to store ways to get richs
		ArrayList<String> geldVerdienManieren = new ArrayList<String>();
		
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
		
	}

}
