package main.java.projectx.commandcenter;

public class Groundunit extends Unit {
	
	private int dps;
	private boolean alive;
	
	public Groundunit(int hitPoints, String name, boolean armor, int dps, boolean alive) {
		super(hitPoints, name, armor);
		
		this.dps = dps;
		this.alive = alive;
		
	}
	
	public int getDps() {
		return this.dps;
	}
	
	public boolean getAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void fight(Groundunit player2) {
		
		int unit1Health = this.getHealth();
		int unit2Health = player2.getHealth();
		
		int unit1Dps = this.getDps();
		int unit2Dps = player2.getDps();
		
		int ronde = 1;
		
		while (this.getAlive() && player2.getAlive()) {
			System.out.println("Ronde " + ronde + "\n -------------- \n");
			unit1Health = unit1Health - unit2Dps;
			unit2Health = unit2Health - unit1Dps;
			
			if (unit1Health < 1) {
				this.setAlive(false);
				System.out.println(player2.getName() + " Wint met " + unit2Health + " Health over");
			}
			
			if (unit2Health < 1) {
				player2.setAlive(false);
				System.out.println(this.getName() + " Wint met " + unit1Health + " Health over");
			}
			
			ronde++;
		}
		
	}
}