public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected boolean isRegisteredPartnership;
    protected Person partner;

    public Person(String firstName, String lastName, int age, Person partner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = partner;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void changePartner(Person partner) {
        this.partner = partner;
    }

    public abstract boolean isRetired();

    protected void registerPartnership(Person partner){
        isRegisteredPartnership = true;
    }

    protected void deregisterPartnership(boolean bToPreviousSurname){
        isRegisteredPartnership = false;
    }

    public boolean isRegisteredPartnership(){
        return isRegisteredPartnership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                age == that.age;
    }

    public void getInfo(){
        System.out.println(firstName + " " + lastName + " " + age + " years old");
        if (partner != null)
            System.out.println("Partner: " + partner.firstName + " " + partner.lastName);
        System.out.println("Partnership registered: " + isRegisteredPartnership);
    }
}

