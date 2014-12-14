package projectx.commandcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {
	private int hitPoints;
	private String name;
	private boolean armored;
	
	/**
	 * Maak een unit, deze kan niet aanvallen maar beschikt wel over taunts, hp, armor en een naam
	 * @param hitPoints 
	 * @param name
	 * @param armor
	 */
	
	public Unit(int hitPoints, String name, boolean armor) {
		this.hitPoints = hitPoints;
		this.name = name;
		this.armored = armor;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return this.hitPoints;
	}
	
	public boolean getArmor() {
		return this.armored;
	}
	
	public String taunts() {
		
		List<String> taunts = new ArrayList<String>();
		
		taunts.add("Eat my Dust");
		taunts.add("BattleCruiser Operational");
		taunts.add("Hell Yeah!");
		taunts.add("Aaaaaaargh");
		taunts.add("I dont care, I love it");
		
		Random random = new Random() ;
        int cijfer = random.nextInt(taunts.size());
        		
        		
		String result = taunts.get(cijfer);
		
		
		return result;
	}
}