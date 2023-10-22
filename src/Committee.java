import java.util.Scanner;

public class Committee {
    public static void main(String[] args) {

        Person person = new Person("Ralph");
        int selection;
        int position;
        int edit;
        Scanner scanner = new Scanner(System.in);
        Student[] committee = new Student[5];

        System.out.println("Create a committee of five students or undergraduates.");

        for (int i = 0; i < committee.length; i++) {
            System.out.println("\n1 - Student | 2 - Undergraduate");
            selection = scanner.nextInt();
            System.out.println("Enter name, student number, and level if applicable: ");
            String name = scanner.next();
            int studentNumber = scanner.nextInt();
            if (selection == 1) {
                committee[i] = new Student(name, studentNumber);
            } else if (selection == 2) {
                int level = scanner.nextInt();
                committee[i] = new Undergraduate(name, studentNumber, level);
            } else {
                System.out.println("Invalid selection, try again.");
                i--;
                continue;
            }
        }

        System.out.println("1 - Edit Entries | 0 - Close Program");
        edit = scanner.nextInt();

        while (edit == 1) {
            System.out.print("\nSelect array position (1-5): ");
            position = scanner.nextInt();

            if (!(position > 0 && position < 6)) {
                System.out.println("Invalid selection, try again.");
                continue;
            }

            System.out.println("\n1 - Reset Attributes | 2 - Write Output | 3 - Compare Object");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("\nEnter new name, student number, and level if applicable:");
                    committee[position].resetInput();
                    continue;
                case 2:
                    committee[position].writeOutput();
                    continue;
                case 3:
                    System.out.println("\nSelect array position (1-5): ");
                    System.out.println("Result: " + committee[position].equals(committee[scanner.nextInt()]));
                    continue;
                default:
                    System.out.println("Invalid selection, try again.");
                    continue;
            }
        }
        scanner.close();
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        name = "No Name";
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void writeOutput() {
        System.out.println("Name: " + getName());
    }

    public boolean hasSameName(Person otherPerson) {
        return (name.equals(otherPerson.getName()));
    }
}

class Student extends Person {
    private int studentNumber;

    public Student(String name, int studentNumber) {
        super(name);
        this.studentNumber = studentNumber;
    }

    public Student() {
        super("No Name");
        studentNumber = 0;
    }

    public void setStudentNumber(int newStudentNumber) {
        studentNumber = newStudentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void resetInput() {
        Scanner scanner = new Scanner(System.in);
        reset(scanner.nextLine(), scanner.nextInt());
        scanner.close();
    }

    public void reset(String newName, int newStudentNumber) {
        setName(newName);
        setStudentNumber(newStudentNumber);
    }

    @Override
    public void writeOutput() {
        System.out.println("Name: " + getName() + "\nStudent Number: " + getStudentNumber());
    }

    public boolean equals(Student otherStudent) {
        return (getName() == otherStudent.getName() && getStudentNumber() == otherStudent.getStudentNumber());
    }
}

class Undergraduate extends Student {
    private int level;

    public Undergraduate(String name, int studentNumber, int level) {
        super(name, studentNumber);
        this.level = level;
    }

    public Undergraduate() {
        super("No Name", 0);
        level = 1;
    }

    public void setLevel(int newLevel) {
        if (newLevel > 0 && newLevel < 5) {
            level = newLevel;
        } else {
            System.out.println("Illegal level!");
        }
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void resetInput() {
        Scanner scanner = new Scanner(System.in);
        reset(scanner.nextLine(), scanner.nextInt(), scanner.nextInt());
        scanner.close();
    }

    public void reset(String newName, int newStudentNumber, int newLevel) {
        setName(newName);
        setStudentNumber(newStudentNumber);
        setLevel(newLevel); // TODO: bugtest
    }

    @Override
    public void writeOutput() {
        System.out.println("Name: " + getName() + "\nStudent Number: " + getStudentNumber() + "\nLevel: " + getLevel());
    }

    public boolean equals(Undergraduate otherUndergraduate) {
        return (getName() == otherUndergraduate.getName()
                && getStudentNumber() == otherUndergraduate.getStudentNumber()
                && getLevel() == otherUndergraduate.getLevel());
    }
}