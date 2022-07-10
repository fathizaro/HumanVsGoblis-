package humanvsgoblins;
import java.util.*;

public class Treasure {
    String dagger = "Dagger";
    String sword = "Sword";
    String armor = "Armor";
    String drink1 = "Magic Potion";
    String drink2 = "Poison";
    String[] treasures = new String[22];
    int row;
    int col;

    Treasure() {
    }

    Treasure(String[] treasures, int row, int col) {
        this.treasures = treasures;
        this.row = row;
        this.col = col;
    }

    public String[] fillTreasuresArray() {
        int i;
        for(i = 0; i < 10; ++i) {
            this.treasures[i] = this.dagger;
        }

        for(i = 10; i < 17; ++i) {
            this.treasures[i] = this.armor;
        }

        for(i = 17; i < 20; ++i) {
            this.treasures[i] = this.sword;
        }

        for(i = 20; i < 21; ++i) {
            this.treasures[i] = this.drink1;
        }

        for(i = 21; i < 22; ++i) {
            this.treasures[i] = this.drink2;
        }

        return this.treasures;
    }
}
