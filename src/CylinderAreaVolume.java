// import input scanner feature
import java.util.Scanner;

// initialize public class 
public class CylinderAreaVolume {
  // initialize object of class CylinderAreaVolume
    public static void main(String[] args) {
        
        double radius;  // initialize radius, height, area, and volume as doubles data type
        double height;  
        double area;
        double volume;
        Scanner input = new Scanner(System.in);  // constructs new scanner to take inputs
        
        System.out.println("Enter the radius of the cylinder: ");  // takes input of user as radius of cylinder
        radius = input.nextDouble();
        System.out.println("Enter the height of the cylinder: ");  // takes input of user as height of cylinder
        height = input.nextDouble();

        area = (2*Math.PI*radius*height) + (2*Math.PI*Math.pow(radius, 2));  // formulas for surface area and volume
        volume = (Math.PI*Math.pow(radius, 2)*height);

        System.out.println("Cylinder's surface area: " + area);  // prints surface area of cylinder
        System.out.println("Cylinder's volume: " + volume);  // prints volume of cylinder

        input.close();  // closes scanner to stop memory leak
    }
}
