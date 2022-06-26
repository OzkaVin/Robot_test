public class Main {
    public static void main(String[] args) {
        Person firstPerson = new Man("Oleg", "Sorokin", 34, null);
        Person secondPerson = new Woman("Irina", "Bondar", 30, null);

        firstPerson.changePartner(secondPerson);
        secondPerson.changePartner(firstPerson);
        firstPerson.getInfo();
        secondPerson.getInfo();

        firstPerson.registerPartnership(secondPerson);
        secondPerson.registerPartnership(firstPerson);
        firstPerson.getInfo();
        secondPerson.getInfo();
    }
}
