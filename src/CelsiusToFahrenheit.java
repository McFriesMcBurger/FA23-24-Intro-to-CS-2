// import input scanner feature
import java.util.Scanner;

// initialize public class 
public class CelsiusToFahrenheit {
  // initialize object of class CelsiusToFahrenheit
  public static void main(String[] args) {
    
    double celsius;  // initialize celsius and fahrenheit as doubles data type
    double fahrenheit;  
    Scanner input = new Scanner(System.in);  // constructs new scanner to take inputs
    
    System.out.println("Enter the temp in degrees C: ");  // takes input of user as temp in degrees C
    celsius = input.nextDouble();
    fahrenheit = ((9/5.0)*(celsius)+32);  // converts degrees C to degrees F
    System.out.println("Converted degrees in F: " + fahrenheit);  // prints converted degrees

    input.close();  // closes scanner to stop memory leak
  }
}
