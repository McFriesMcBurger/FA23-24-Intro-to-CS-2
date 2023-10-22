import java.util.Scanner;

// Superclass
class SmartDevice {
    private int device_Id;

    // Constructor taking parameter
    public SmartDevice(int device_Id) {
        this.device_Id = device_Id;
    }

    // Default constructor
    public SmartDevice() {
        this(0000);
    }

    public void turnOn() {
        System.out.println("Smart device #" + device_Id + " is turning on.");
    }

    public int getDevice_Id() {
        return device_Id;
    }

    public void setDevice_Id(int device_Id) {
        this.device_Id = device_Id;
    }
}

// Subclass #1
class SmartBulb extends SmartDevice {
    public SmartBulb(int device_Id) {
        super(device_Id);
    }

    public void changeColor() {
        System.out.println("Smart bulb is changing color.");
    }
}

// Subclass #2
class SmartThermostat extends SmartDevice {
    public SmartThermostat(int device_Id) {
        super(device_Id);
    }

    public void adjustTemperature() {
        System.out.println("Smart thermostat is adjusting temperature.");
    }
}

// Subclass #3
class SmartLock extends SmartDevice {
    protected int doorNumber;

    public SmartLock(int device_Id, int doorNumber) {
        super(device_Id);
        this.doorNumber = doorNumber;
    }

    public void lockDoor() {
        System.out.println("Door #" + doorNumber + " has been locked.");
    }

    public void unlockDoor() {
        System.out.println("Door #" + doorNumber + " has been unlocked.");
    }
}

// Subclass of Subclass #3
class VaultLock extends SmartLock {
    private int key;

    public VaultLock(int device_Id, int vaultNumber, int key) {
        super(device_Id, vaultNumber);
        this.key = key;
    }

    @Override
    public void unlockDoor() {
        System.out.println("No key provided! Try again.");
    }

    public void unlockDoor(int inputKey) {
        if (this.key == inputKey) {
            System.out.println("Correct key. Door #" + doorNumber + " has been unlocked.");
        } else {
            System.out.println("Incorrect key! Try again.");
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartBulb sb = new SmartBulb(1);
        SmartThermostat st = new SmartThermostat(2);
        SmartLock sl = new SmartLock(3, 1);
        VaultLock vl = new VaultLock(4, 2, 10);
        sb.turnOn();
        st.turnOn();
        sb.changeColor();
        st.adjustTemperature();
        sl.turnOn();
        sl.lockDoor();
        sl.unlockDoor();
        vl.turnOn();
        vl.lockDoor();
        System.out.print("Enter key: ");
        vl.unlockDoor(scanner.nextInt());
        System.out.print("Enter key: ");
        vl.unlockDoor(scanner.nextInt());
        vl.unlockDoor();
        scanner.close();
    }
}
