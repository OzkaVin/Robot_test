public class RegistrationFormData {
    String firstName;
    String lastName;
    String email;
    int age;
    int salary;
    String dept;

    public RegistrationFormData(String firstName, String lastName, String email, int age, int salary, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

    public String getValue(){
        return firstName + lastName + Integer.toString(age) + email + Integer.toString(salary) + dept;
    }
}
