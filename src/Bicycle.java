public class Bicycle {
    private int cadence = 0;
    private int speed = 0;
    private int gear = 1;

    public void changeCadence(int cadence) {
        this.cadence = cadence;
    }

    public void changeGear(int gear) {
        this.gear = gear;
    }

    public void speedUp(int speed) {
        this.speed += speed;
    }

    public void applyBrakes(int speed) {
        this.speed -= speed;
    }

    public void printStates() {
        System.out.print("Cadence: " + cadence);
        System.out.print(" Speed: " + speed);
        System.out.println(" Gear: " + gear);
    }

}
