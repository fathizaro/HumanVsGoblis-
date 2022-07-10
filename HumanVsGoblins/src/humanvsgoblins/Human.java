package humanvsgoblins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Human {
    int health;
    int strength;
    int row;
    int col;
    String name;
    ArrayList<String> inventory = new ArrayList();

    Human(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    Human() {
    }

    Human(int health, int strength, int row, int col, String name) {
        this.health = health;
        this.strength = strength;
        this.row = row;
        this.col = col;
        this.name = name;
    }

    public boolean checkTreasureForPotion(String str, Treasure treasure, Human human, Land land, Scanner scan) {
        if (str.equals(treasure.drink1)) {
            System.out.println("You have found a rare item. Press any button to see what it is!");
            scan.next();
            human.health += 10;
            System.out.println("Congratulations " + human.name + "! The Magic Potion has raised your health by 10 points!");
            ((String[])land.grid.get(human.row))[human.col] = " H ";
        } else if (str.equals(treasure.drink2)) {
            System.out.println("You have found a rare item. Press any button to see what it is!");
            scan.next();
            human.health -= 5;
            System.out.println("The treasure chest contained a bomb and it blew up taking away 5 health points.");
            ((String[])land.grid.get(human.row))[human.col] = " H ";
            if (human.health < 1) {
                System.out.println("Sorry " + human.name + " that bomb killed you. Better luck next time.");
                return false;
            }
        } else {
            human.inventory.add(str.toLowerCase());
            System.out.println("Treasure chest contained: " + str + ". It has been added to your arsenal.");
            ((String[])land.grid.get(human.row))[human.col] = " H ";
        }

        return true;
    }

    public String useItem(String str, Human human, Goblin goblin, String[] arr) {
        Iterator var5 = human.inventory.iterator();

        while(var5.hasNext()) {
            String temp = (String)var5.next();
            if (temp.contains(str)) {
                switch (str) {
                    case "dagger":
                        ++human.strength;
                        human.inventory.remove("dagger");
                        arr[0] = "dagger";
                        return "Your strength during this battle will be raised by 1.";
                    case "sword":
                        human.strength += 3;
                        human.inventory.remove("sword");
                        arr[0] = "sword";
                        return "Your strength during this battle will be raised by 3.";
                    case "armor":
                        goblin.strength = 1;
                        human.inventory.remove("armor");
                        arr[0] = "armor";
                        return "Your armor reduced the strength of your opponent to 1 point during this battle.";
                }
            }
        }

        return "Your arsenal does not contain that item.";
    }

    public void removeWeapon(Human human, String[] arr) {
        if (arr[0].equals("dagger")) {
            --human.strength;
        }

        if (arr[0].equals("sword")) {
            human.strength -= 3;
        }

        arr[0] = "no weapon";
    }

    public String printInventory(ArrayList<String> inventory) {
        StringBuilder sb = new StringBuilder();
        Iterator var3 = inventory.iterator();

        while(var3.hasNext()) {
            String s = (String)var3.next();
            sb.append(": ");
            sb.append(s);
            sb.append(" ");
        }

        return sb.toString();
    }

    public String attack(Human human, Goblin goblin) {
        double x = 1.0 + Math.random() * (double)human.strength;
        int hitStrength = (int)x;
        goblin.health -= hitStrength;
        return "!*!ThUd!*! " + human.name + " attacks " + goblin.name + " for a damage of: " + hitStrength;
    }

    public String move(HashMap<Integer, String[]> grid, HashMap<Integer, int[]> hash, String s) {
        switch (s.toLowerCase()) {

            //UP
            case "i":
                if (this.row - 1 >= 1) {
                    ((String[])grid.get(this.row))[this.col] = " - ";
                    --this.row;
                    ((int[])hash.get(0))[0] = this.row;
                    if (((String[])grid.get(this.row))[this.col].equals(" G ")) {
                        ((String[])grid.get(this.row))[this.col] = "G:H";
                    } else if (((String[])grid.get(this.row))[this.col].equals(" - ")) {
                        ((String[])grid.get(this.row))[this.col] = " H ";
                    } else {
                        ((String[])grid.get(this.row))[this.col] = "[H]";
                    }
                }
                break;

                //DOWN
            case "k":
                if (this.row + 1 < 16) {
                    ((String[])grid.get(this.row))[this.col] = " - ";
                    ++this.row;
                    ((int[])hash.get(0))[0] = this.row;
                    if (((String[])grid.get(this.row))[this.col].equals(" G ")) {
                        ((String[])grid.get(this.row))[this.col] = "G:H";
                    } else if (((String[])grid.get(this.row))[this.col].equals(" - ")) {
                        ((String[])grid.get(this.row))[this.col] = " H ";
                    } else {
                        ((String[])grid.get(this.row))[this.col] = "[H]";
                    }
                }
                break;
            case "j":
                if (this.col - 1 >= 0) {
                    ((String[])grid.get(this.row))[this.col] = " - ";
                    --this.col;
                    ((int[])hash.get(0))[1] = this.col;
                    if (((String[])grid.get(this.row))[this.col].equals(" G ")) {
                        ((String[])grid.get(this.row))[this.col] = "G:H";
                    } else if (((String[])grid.get(this.row))[this.col].equals(" - ")) {
                        ((String[])grid.get(this.row))[this.col] = " H ";
                    } else {
                        ((String[])grid.get(this.row))[this.col] = "[H]";
                    }
                }
                break;
            case "l":
                if (this.col + 1 < 15) {
                    ((String[])grid.get(this.row))[this.col] = " - ";
                    ++this.col;
                    ((int[])hash.get(0))[1] = this.col;
                    if (((String[])grid.get(this.row))[this.col].equals(" G ")) {
                        ((String[])grid.get(this.row))[this.col] = "G:H";
                    } else if (((String[])grid.get(this.row))[this.col].equals(" - ")) {
                        ((String[])grid.get(this.row))[this.col] = " H ";
                    } else {
                        ((String[])grid.get(this.row))[this.col] = "[H]";
                    }
                }
                break;
            default:
                return this.toString(grid);
        }

        return this.toString(grid);
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
}






