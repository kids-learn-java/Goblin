import java.lang.Math;
import java.util.Scanner;

public class App {
    public static void Attack(Being attacker, Being defenser) {
        int attackPower = attacker.getAttack();
        defenser.takeDamage(attackPower);
    }

    public static void main(String[] args) throws Exception {
        Player player = new Player("You", 25, 8, 4);
        Goblin[] goblins = new Goblin[3];
        boolean hasLiveGoblin;

        goblins[0] = new Goblin("foo", 15, 10, 4, 0.8f);
        goblins[1] = new Goblin("goo", 20,  8, 8, 0.9f);
        goblins[2] = new Goblin("gar", 25, 6, 5, 0.7f);

        Scanner sc = new Scanner(System.in);
        do {
            System.out.format("\nCurrent status: \n%s\nGoblins:\n", player.toString());
            for (Goblin goblin: goblins) {
                System.out.println(goblin.toString());
             }
            int attacker = (int)(Math.random() * goblins.length);
            System.out.format("\nGoblin %d will attack you first\n", attacker);

            System.out.println("Pick your choice before your attack: 1. attack mode; 2. defense mode");
            int choice = sc.nextInt();
            player.SetMode(choice == 1);

            Attack(goblins[attacker], player);
            hasLiveGoblin = false;
            for (Goblin goblin: goblins) {
                Attack(player, goblin);
                if (goblin.isLive()) {
                    hasLiveGoblin = true;
                }
        }
        } while (player.isLive() && hasLiveGoblin);
        sc.close();
        if (player.isLive()) {
            System.out.println("Congratulations, you win!");
        } else {
            System.out.println("Sorry, you lost to the goblins");
        }
    }
}
