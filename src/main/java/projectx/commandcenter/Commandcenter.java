package main.java.projectx.commandcenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Commandcenter {
	
	private List<Unit> units;
	private List<Groundunit> groundUnits;
	
	public static void main(String[] args) {
		Commandcenter cc = new Commandcenter();
		cc.buildUnits();
		
		Groundunit unit1 = cc.groundUnits.get(0);
		Groundunit unit0 = cc.groundUnits.get(1);
		
		unit1.fight(unit0);
		
		//cc.showUnits();
	}
	
	private void showUnits () {
		int dingen = (int) units.stream()
		.filter(u->u.getHealth() > 50)
		//.map(u->u.getName())
		.count();
		
		System.out.println(dingen);
		
	}
	
	private void buildUnits() {
		Groundunit marine = new Groundunit(80, "Marine", true, 45, true);
		Groundunit marauder = new Groundunit(140, "Marauder", false, 30, true);
		Unit raven = new Unit(60, "Reaper", true);
		Unit scv = new Groundunit(0, null, false, 0, false);
		
		List<Groundunit> groundUnits = new ArrayList<Groundunit>();
		this.groundUnits = groundUnits;
		
		this.groundUnits.addAll(Arrays.asList(marine,marauder));
		
		List<Unit> units = new ArrayList<Unit>();
		units.addAll(Arrays.asList(marine,marauder,raven));
		this.units = units;
	}
}