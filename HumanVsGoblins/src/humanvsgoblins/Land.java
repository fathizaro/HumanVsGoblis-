package humanvsgoblins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Land {
    HashMap<Integer, String[]> grid = new HashMap();
    ArrayList<Goblin> goblins = new ArrayList();
    ArrayList<Treasure> treasureChests = new ArrayList();

    public Land() {
    }

    public boolean setGoblinMovement() {
        double x = 1.0 + Math.random() * 2.0;
        return (int)x == 1;
    }

    public void createGameBoard() {
        this.grid.put(0, new String[]{"\n            Humans Verse Goblins\n"});

        for(int i = 1; i < 16; ++i) {
            this.grid.put(i, new String[]{" - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", " - ", "\n"});
        }

    }

    public boolean testForElement(HashMap<Integer, int[]> hashToEdit, HashMap<Integer, int[]> hashToCompare) {
        int[] temp = new int[]{111};

        for(int i = 0; i < hashToEdit.size(); ++i) {
            for(int j = 0; j < hashToCompare.size(); ++j) {
                if (Arrays.equals((int[])hashToEdit.get(i), (int[])hashToCompare.get(j))) {
                    hashToEdit.put(i, temp);
                    return true;
                }
            }
        }

        return false;
    }

    public void removeElement(HashMap<Integer, int[]> hashToRemove, HashMap<Integer, int[]> hashToCompare) {
        for(int i = 0; i < hashToRemove.size(); ++i) {
            for(int j = 0; j < hashToCompare.size(); ++j) {
                if (Arrays.equals((int[])hashToRemove.get(i), (int[])hashToCompare.get(j))) {
                    hashToRemove.remove(i);
                    break;
                }
            }
        }

    }

    public void addElement(int d, HashMap<Integer, int[]> coordinates, String s) {
        for(int i = 0; d > 0; --d) {
            boolean same = true;

            while(same) {
                int x = this.randomNum(1, 15);
                int y = this.randomNum(0, 15);
                if (((String[])this.grid.get(x))[y].equals(" - ")) {
                    ((String[])this.grid.get(x))[y] = s;
                    int[] arr = new int[]{x, y};
                    coordinates.put(coordinates.size(), arr);
                    ++i;
                    same = false;
                }
            }
        }

    }

    public String randomGoblinName() {
        String[] names = new String[]{"The Greedy Goblin", "Gil the Goblin", "Flesh Eater", "Sally Swordsman", "Googley Eyed Goblin", "Grumpy Goblin", "Goblisauras Rex", "Adam the Goblin", "Jacob the Goblin", "The Gargantuan Goblin", "Creepy Goblin", "Goblin the Grey", "Grizzly Goblin"};
        double x = Math.random() * 12.0;
        int y = (int)x;
        return names[y];
    }

    public Goblin getGoblinToFight(HashMap<Integer, int[]> humCoords, ArrayList<Goblin> arrList) {
        Goblin fighter = null;
        Iterator var4 = arrList.iterator();

        while(var4.hasNext()) {
            Goblin a = (Goblin)var4.next();
            if (a.row == ((int[])humCoords.get(0))[0] && a.col == ((int[])humCoords.get(0))[1]) {
                fighter = a;
            }
        }

        return fighter;
    }

    public Treasure getTreasure(HashMap<Integer, int[]> humCoords, ArrayList<Treasure> arrList) {
        Treasure chest = null;
        Iterator var4 = arrList.iterator();

        while(var4.hasNext()) {
            Treasure i = (Treasure)var4.next();
            if (i.row == ((int[])humCoords.get(0))[0] && i.col == ((int[])humCoords.get(0))[1]) {
                chest = i;
            }
        }

        return chest;
    }

    public String toString(HashMap<Integer, String[]> hash) {
        StringBuilder str2 = new StringBuilder();

        for(int i = 0; i < hash.size(); ++i) {
            String[] var4 = (String[])hash.get(i);
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String s = var4[var6];
                str2.append(s);
            }
        }

        return str2.toString();
    }

    public int randomNum(int i, int j) {
        double x = (double)i + Math.random() * (double)(j - i);
        return (int)x;
    }

    public boolean checkForWin(HashMap<Integer, int[]> coordinates) {
        int[] temp = new int[]{111};

        for(int i = 0; i < coordinates.size(); ++i) {
            if (!Arrays.equals((int[])coordinates.get(i), temp)) {
                return false;
            }
        }

        return true;
    }
}
