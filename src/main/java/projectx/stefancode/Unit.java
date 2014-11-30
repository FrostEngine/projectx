package main.java.projectx.stefancode;

public class Unit {
	private int hitPoints;
	private int team;
	private String name;
	
	public Unit(int hitPoints, int team, String name) {
		this.hitPoints = hitPoints;
		this.team = team;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return this.hitPoints;
	}
}
