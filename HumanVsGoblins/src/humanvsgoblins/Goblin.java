package humanvsgoblins;
import java.util.*;

public class Goblin {
    int health;
    int strength;
    int row;
    int col;
    String name;

    Goblin(int health, int strength, int row, int col, String name, boolean move) {
        this.health = health;
        this.strength = strength;
        this.row = row;
        this.col = col;
        this.name = name;
    }

    Goblin() {
    }

    public String attack(Goblin goblin, Human human) {
        double x = 1.0 + Math.random() * (double)goblin.strength;
        int hitStrength = (int)x;
        human.health -= hitStrength;
        return "!*!SmAsH!*! " + goblin.name + " attacks " + human.name + " for a damage of: " + hitStrength;
    }
}