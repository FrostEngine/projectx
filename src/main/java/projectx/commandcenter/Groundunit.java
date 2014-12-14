package projectx.commandcenter;

public class Groundunit extends Unit {

    private int dps;
    private boolean alive;
    private String firstName;

    /**
     * Dit is een extend van een unit, Deze unit kan namelijk ook aanvallen en levend zijn
     *
     * @param hitPoints
     * @param name
     * @param armor
     * @param dps
     * @param alive
     */

    public Groundunit(int hitPoints, String name, boolean armor, int dps, boolean alive, String firstName) {
        super(hitPoints, name, armor);

        this.dps = dps;
        this.alive = alive;

        this.firstName = firstName;
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

        //When unit has armor it reduces the dps of the oponent
        if (player2.getArmor()) {
            unit1Dps = unit1Dps / 2;
        }

        if (this.getArmor()) {
            unit2Dps = unit2Dps / 2;
        }

        int ronde = 1;

        while (this.getAlive() && player2.getAlive()) {
            System.out.println("Ronde " + ronde + "\n -------------- \n");


            //Eerste gaat unit 2 knallen
            unit1Health = unit1Health - unit2Dps;
            System.out.println(player2.getName() + " says: " + this.taunts());

            //Dan unit 1
            unit2Health = unit2Health - unit1Dps;
            System.out.println(this.getName() + " says: " + this.taunts());

            System.out.println("\n");

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

    public boolean isAlive() {
        return alive;
    }
}