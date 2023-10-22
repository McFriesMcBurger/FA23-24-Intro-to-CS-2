public class Committee {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
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