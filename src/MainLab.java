import java.util.Scanner;

public class MainLab {
    public static void main(String[] args) {       
        Scanner scanner = new Scanner(System.in);
        
        // details for person 1
        System.out.println("Enter details for person 1:");
        System.out.println("First Name: ");
        String firstName1 = scanner.next();
        System.out.println("Last Name: ");
        String lastName1 = scanner.next();
        System.out.println("Age: ");
        int age1 = scanner.nextInt();
        System.out.println("Email: ");
        String email1 = scanner.next();
    
        Person person1 = new Person(firstName1, lastName1, age1, email1);
        
        // details for person 2
        System.out.println("Enter details for person 2:");
        System.out.println("First Name: ");
        String firstName2 = scanner.next();
        System.out.println("Last Name: ");
        String lastName2 = scanner.next();
        System.out.println("Age: ");
        int age2 = scanner.nextInt();
        System.out.println("Email: ");
        String email2 = scanner.next();
    
        Person person2 = new Person(firstName2, lastName2, age2, email2);
        
        // display person 1 information
        System.out.println("Person 1:");
        System.out.println("First Name: " + person1.getFirstName());
        System.out.println("Last Name: " + person1.getLastName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Email: " + person1.getEmail());

        // display person 2 information
        System.out.println("Person 2:");
        System.out.println("First Name: " + person2.getFirstName());
        System.out.println("Last Name: " + person2.getLastName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Email: " + person2.getEmail());

        // check if either person is an adult
        System.out.println("Adult: " + person1.adultChecker());
        System.out.println("Adult: " + person2.adultChecker());
        
        // block scope
        for (int i = 0; i < 5; i++) {
            int loopVariable = i;
            System.out.println("Inside the loop: " + loopVariable);
        }

        //System.out.println("Inside the loop: " + loopVariable) leads to a compilation error

        // close scanner
        scanner.close();
    }
}
