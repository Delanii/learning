public class Main {

    public static void main(String[] args){

        Player player = new Player("Mickey", 100, "fork");

        player.setName("Tim");
        player.setHealthPercentage(20);

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining player heath: " + player.getHealthPercentage());

        player.loseHealth(11);
        System.out.println("Remaining player health: " + player.getHealthPercentage());
    }
}
