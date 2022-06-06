import java.util.concurrent.ThreadLocalRandom;

public class Student {
    private String name;
    private String surname;
    private int uid;

    private static int lastId;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;

        uid = getNextId();
    }

    private int getNextId(){
        return ++lastId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getID() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

