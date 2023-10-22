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

        // System.out.println("Inside the loop: " + loopVariable) leads to a compilation
        // error

        // close scanner
        scanner.close();
    }
}

class Person {
    // class attributes
    private String firstName;
    private String lastName;
    private int Age;
    private String email;

    // class constructor
    public Person(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        Age = age;
        this.email = email;
    }

    // getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return Age;
    }

    public String getEmail() {
        return email;
    }

    // setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // special methods
    public Boolean adultChecker() {
        if (Age >= 18) {
            return true;
        }
        return false;
    }
}
