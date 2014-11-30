package main.java.projectx.stefancode;

public class Unit {
	private int hitPoints;
	private String name;
	private boolean armored;
	
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
}
