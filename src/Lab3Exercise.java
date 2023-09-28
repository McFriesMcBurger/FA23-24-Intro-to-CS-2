import java.util.Scanner; // import input scanner

public class Lab3Exercise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // declare an array of size 4 with bicycle objects
        Bicycle bicycle[] = new Bicycle[4];

        // iterate through empty array
        for (int i = 0; i < bicycle.length; i++) {
            bicycle[i] = new Bicycle(); // declare new bicycle object

            System.out.println("\nBicycle " + (i + 1) + ":");

            // set cadence per bicycle
            System.out.print("Cadence: ");
            bicycle[i].changeCadence(scan.nextInt());

            // set speed per bicycle
            System.out.print("Speed: ");
            bicycle[i].speedUp(scan.nextInt());

            // set gear per bicycle
            System.out.print("Gear: ");
            bicycle[i].changeGear(scan.nextInt());

            // System.out.println(""); // new line per iteration
        }

        // iterate through existing array
        for (int i = 0; i < bicycle.length; i++) {
            System.out.println("\nBicycle " + (i + 1) + ":");
            bicycle[i].printStates(); // print the attribute states of each bicycle object
            // System.out.println(""); // new line per iteration
        }

        // experimenting with the methods
        bicycle[2].applyBrakes(10);
        System.out.println("\nBicycle 3: (Updated)");
        bicycle[2].printStates();

        bicycle[0].speedUp(50);
        System.out.println("\nBicycle 1: (Updated)");
        bicycle[0].printStates();

        bicycle[3].changeCadence(1);
        bicycle[3].changeGear(6);
        System.out.println("\nBicycle 4: (Updated)");
        bicycle[3].printStates();

        scan.close(); // close scanner
    }
}
