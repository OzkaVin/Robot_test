import java.util.ArrayList;
import java.util.List;

public class lesson14 {
    public static void main(String[] args) {
        /*Student firstStudentA = new Student("Ivan", "Tkachenko");
        StudentsGroup groupA = new StudentsGroup(firstStudentA);
        Student secondStudentA = new Student("Irina", "Boyko");
        groupA.addStudent(secondStudentA);
        Student thirdStudentA = new Student("Oleh", "Vitrenko");
        groupA.addStudent(thirdStudentA);

        groupA.printStudents();

        groupA.changeHead(secondStudentA);
        System.out.println("=> After head change:");
        groupA.printStudents();

        groupA.deleteStudent(firstStudentA);
        System.out.println("=> After first student deleting:");
        groupA.printStudents();

        int thirdStudentId = thirdStudentA.getID();
        groupA.renameStudent(thirdStudentId, "Oleh", "Franchuk");
        System.out.println("=> After third student renaming:");
        groupA.printStudents();

        groupA.addTask("Pass Phisics test1");
        groupA.completeTask("Pass Phisics test1", secondStudentA.getID());
        groupA.printTasks();*/


        List<Student> listB = new ArrayList<>();
        Student firstStudentB = new Student("Olha", "Koval");
        Student secondStudentB = new Student("Ihor", "Malukha");
        Student thirdStudentB = new Student("Vitalii", "Lozinskyi");
        listB.add(firstStudentB);
        listB.add(thirdStudentB);
        StudentsGroup groupB = new StudentsGroup(secondStudentB, listB);

        groupB.printStudents();

        groupB.deleteStudent(secondStudentB);
    }
}
