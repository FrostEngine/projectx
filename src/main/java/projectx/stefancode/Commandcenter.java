package main.java.projectx.stefancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commandcenter {
	
	private List<Unit> units;

	public static void main(String[] args) {
		
		Commandcenter cc = new Commandcenter();
		cc.buildUnits();
		cc.showUnits();
	}
	
	private void showUnits () {
		
		units.stream()
		.filter(u->u.getHealth() > 50)
		.map(u->u.getName())
		.forEach(System.out::println);
		
	}
	
	private void buildUnits() {
		
		Unit marine = new Unit(45, "Marine", false);
		Unit marauder = new Unit(120, "Marauder", true);
		Unit reaper = new Unit(60, "Reaper", true);
		
		List<Unit> units = new ArrayList<Unit>();
		units.addAll(Arrays.asList(marine,marauder,reaper));
		
		this.units = units;
	}

}
