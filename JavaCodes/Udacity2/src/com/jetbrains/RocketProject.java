package com.jetbrains;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class RocketProject {

    public static class Item {
        public String name;
        public int weight;
    }

    public interface SpaceShip {
        boolean launch();

        boolean land();

        boolean canCarry(Item item);

        int carry(Item item);
    }

    public static class Rocket implements SpaceShip {
        public int uWeight;
        public int maxWeight;

        public boolean launch() {
            return true;
        }

        public boolean land() {
            return true;
        }

        int currentWeight = 0;

        public int carry(Item item) {
            currentWeight = currentWeight + item.weight;
            return currentWeight;
        }

        public boolean canCarry(Item item) {
            if ((item.weight + currentWeight) > calcCargoLimit(uWeight, maxWeight)) {
                return false;
            } else {
                currentWeight = carry(item);
                return true;
            }
        }
    }

    public static int calcCargoLimit(int uWeight, int maxWeight) {
        int cargoLimit = maxWeight - uWeight;
        return cargoLimit;
    }

    public static class U1 extends Rocket {
        int cargoLimit1 = calcCargoLimit(10000, 18000);

        @Override
        public boolean launch() {
            float explosionChanceU11 = 5 * (currentWeight / cargoLimit1);
            // currentWeight is our cargo carried
            int randomNumber = (int) (Math.random() * 101);
            if (randomNumber <= explosionChanceU11) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public boolean land() {
            float explosionChanceU12 = currentWeight / cargoLimit1;
            int randomNumber = (int) (Math.random() * 101);
            if (randomNumber <= explosionChanceU12) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class U2 extends Rocket {
        int cargoLimit2 = calcCargoLimit(18000, 29000);

        @Override
        public boolean launch() {
            float explosionChanceU21 = 4 * (currentWeight / cargoLimit2);
            int randomNumber = (int) (Math.random() * 101);
            if (randomNumber <= explosionChanceU21) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public boolean land() {
            float explosionChanceU22 = 8 * (currentWeight / cargoLimit2);
            int randomNumber = (int) (Math.random() * 101);
            if (randomNumber <= explosionChanceU22) {
                return false;
            } else {
                return true;
            }
        }
    }

    // Part 2

    public static class Simulation1 extends U1 {

        public ArrayList loadItems1(String fileName) throws FileNotFoundException {

            File supplies = new File(fileName);
            Scanner supplyScanner = new Scanner(supplies);
            ArrayList supplyItems = new ArrayList();

            while (supplyScanner.hasNextLine()) {
                String line = supplyScanner.nextLine();
                String[] splitLine = line.split("=");

                Item item = new Item();
                item.name = splitLine[0];
                item.weight = Integer.parseInt(splitLine[1]);

                supplyItems.add(item);
            }
            return supplyItems;
        }

        public ArrayList loadU1() throws FileNotFoundException {

            ArrayList loadedU1s = new ArrayList();
            int totalU1s = 0;

            //Phase 1
            ArrayList allSuppliesU1P1 = new ArrayList();
            allSuppliesU1P1 = loadItems1("buildingTools.txt");
            int sizeP1 = allSuppliesU1P1.size();

            for (int i1 = 1; i1 < sizeP1; i1 += 2) {
                Item itemWeightP1 = (Item) allSuppliesU1P1.get(i1);
                if (canCarry(itemWeightP1)) {
                    carry(itemWeightP1);
                } else {
                    totalU1s++;
                    loadedU1s.add("U1-" + totalU1s);
                    currentWeight = 0;
                }
            }

            //Phase 2
            ArrayList allSuppliesU1P2 = new ArrayList();
            allSuppliesU1P2 = loadItems1("peopleFood.txt");
            int sizeP2 = allSuppliesU1P2.size();

            for (int i2 = 1; i2 < sizeP2; i2 += 2) {
                Item itemWeightP2 = (Item) allSuppliesU1P2.get(i2);
                if (canCarry(itemWeightP2)) {
                    carry(itemWeightP2);
                } else {
                    totalU1s++;
                    loadedU1s.add("U1-" + totalU1s);
                    currentWeight = 0;
                }
            }
            return loadedU1s;
        }
        public int runSimulation1() throws FileNotFoundException {
            int numLoadedU1s = loadU1().size();
            int totalBudgetU1s = 0;

            for (int iR1 = 0; iR1 < numLoadedU1s; iR1 += 0) {
                if (launch() && land()) {
                    totalBudgetU1s += 100;
                    iR1++;
                } else {
                    totalBudgetU1s += 100;
                    System.out.println("U1 Crashed!");
                }
            }
            return totalBudgetU1s;
        }
    }

    public static class Simulation2 extends U2 {

        public ArrayList loadItems2(String fileName) throws FileNotFoundException {

            File supplies = new File(fileName);
            Scanner supplyScanner = new Scanner(supplies);
            ArrayList supplyItems = new ArrayList();

            while (supplyScanner.hasNextLine()) {
                String line = supplyScanner.nextLine();
                String[] splitLine = line.split("=");

                Item item = new Item();
                item.name = splitLine[0];
                item.weight = Integer.parseInt(splitLine[1]);

                supplyItems.add(item);
            }
            return supplyItems;
        }

        public ArrayList loadU2() throws FileNotFoundException {

            ArrayList loadedU2s = new ArrayList();
            int totalU2s = 0;

            //Phase 1
            ArrayList allSuppliesU2P1 = new ArrayList();
            allSuppliesU2P1 = loadItems2("buildingTools.txt");
            int size2P1 = allSuppliesU2P1.size();

            for (int i21 = 1; i21 < size2P1; i21 += 2) { //U2 P1
                Item itemWeight2P1 = (Item) allSuppliesU2P1.get(i21);
                if (canCarry(itemWeight2P1)) {
                    carry(itemWeight2P1);
                } else {
                    totalU2s++;
                    loadedU2s.add("U2-" + totalU2s);
                    currentWeight = 0;
                }
            }

            //Phase 2
            ArrayList allSuppliesU2P2 = new ArrayList();
            allSuppliesU2P2 = loadItems2("peopleFood.txt");
            int size2P2 = allSuppliesU2P2.size();

            for (int i22 = 1; i22 < size2P2; i22 += 2) {
                Item itemWeight2P2 = (Item) allSuppliesU2P2.get(i22);
                if (canCarry(itemWeight2P2)) {
                    carry(itemWeight2P2);
                } else {
                    totalU2s++;
                    loadedU2s.add("U2-" + totalU2s);
                    currentWeight = 0;
                }
            }
            return loadedU2s;
        }
        public int runSimulation2() throws FileNotFoundException {
            int numLoadedU2s = loadU2().size();
            int totalBudgetU2s = 0;

            for (int iR2 = 0; iR2 < numLoadedU2s; iR2 += 0) {
                if (launch() && land()) {
                    totalBudgetU2s += 120;
                    iR2++;
                } else {
                    totalBudgetU2s += 120;
                    System.out.println("U2 Crashed!");
                }
            }
            return totalBudgetU2s;
        }
    }

    public static class Main {

        public static void main (String [] args) throws FileNotFoundException {
            Simulation1 simU1 = new Simulation1();
            simU1.loadU1();
            int budgetU1 = simU1.runSimulation1();
            System.out.println("U1 budget: " + budgetU1 + " million dollars");

            Simulation2 simU2 = new Simulation2();
            simU2.loadU2();
            int budgetU2 = simU2.runSimulation2();
            System.out.println("U2 budget: " + budgetU2 + " million dollars");
        }
    }
}

//Made a separate simulation for each extending the U1 and U2 classes and I think that worked.
//They rarely crash so numbers usually look similar but otherwise this is working. Nice.