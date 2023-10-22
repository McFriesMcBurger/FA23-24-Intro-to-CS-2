// Write a main method, inside the Driver class, that shows how you instantiate
// two instances from class Drone. One instance, d1, is created using the
// default constructor and the other, d2, is created using the parameterized
// constructor with the model “DR-100” and speed of 40 km/hour. The main method
// should also display the full info about d2 (assuming toString() is
// implemented in the Drone class).

// Show the implementation of the Drone class that defines the two properties' 
// model and speed, and the two constructors used in Question 2. The default 
// constructor should initialize model to “DR-XYZ” and speed to 50 km/hour.

// In the Drone class, implement the toString() method that enables the 
// developer to write the following statement: System.out.println( d2 ) 
// to display info about the drone.

// Inside the Drone class, write the code of the setSpeed and getSpeed. 
// The setSpeed should validate the input.If it is a non-positive value,
// it should be set to 50(as a default value).Otherwise,the input value is accepted.

// The getSpeed method accepts one parameter,code,where it should return 
// the speed in km/hour if code is 1 and in miles if code is 2.

// Hint:you can convert from kilometers to miles by multiplying by 0.625.

class Drone {
    private String model;
    private double speed;

    public Drone() {
        this("DR-XYZ", 50);
    }

    public Drone(String model, double speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Drone: " + model + "\nSpeed: " + speed + " km/hour";
    }

    public double getSpeed(int code) {
        if (code == 2) {
            return speed * 0.625;
        }
        return speed;

    }

    public void setSpeed(double speed) {
        if (speed <= 0) {
            this.speed = 50;
        }
        this.speed = speed;
    }
}

public class Driver {
    public static void main(String[] args) {
        Drone d2 = new Drone("DR-100", 40);
        System.out.println(d2.toString());
    }
}