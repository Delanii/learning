public class Player {

   private String name;
   private int healthPercentage;
   private String weapon;

    public Player(String name, int healthPercentage, String weapon) {

        this.name = name;

        if (healthPercentage < 0) {
            this.healthPercentage = 1;
        } else if (healthPercentage > 100) {
            this.healthPercentage = 100;
        } else {
            this.healthPercentage = healthPercentage;
        }

        this.weapon = weapon;
    }

    public Player(String name) {
        this(name, 100, "sword");
    }

    public int getHealthPercentage(){
       return this.healthPercentage;
   }

    public String getName() {
        return this.name;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setHealthPercentage(int healthPercentage){
        this.healthPercentage = healthPercentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void loseHealth(int damage){

       this.healthPercentage = this.getHealthPercentage() - damage;

       if (healthPercentage <= 0) {
           System.out.println("Player lost.");
       }
   }

   public void restoreHealth(int extraHealth){

       this.healthPercentage = this.getHealthPercentage() + extraHealth;

       if (this.healthPercentage > 100) {
           System.out.println("Player healed to 100 %");
           this.setHealthPercentage(100);
       }
   }
}
