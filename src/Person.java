public class Person {
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
