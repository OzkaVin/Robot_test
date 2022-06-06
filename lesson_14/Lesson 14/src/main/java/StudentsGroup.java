import java.util.*;

public class StudentsGroup {
    private Student groupHead;
    private List<Student> students = new ArrayList<Student>();
    private HashMap<String, Set<Integer>> tasks = new HashMap<String, Set<Integer>>();

    public StudentsGroup(Student groupHead, List<Student> students) {
        this.groupHead = groupHead;
        this.students = students;

        students.add(groupHead);
    }

    public StudentsGroup(Student groupHead) {
        this.groupHead = groupHead;
        students.add(groupHead);
    }

    public void printStudents()
    {
        for(Student student : students) {
            if (student == groupHead)
                System.out.print("Head of group: ");
            System.out.println(student.getID() + " " + student.getName() + " " + student.getSurname());
        }
    }

    public void changeHead(Student newHead){
        groupHead = newHead;

        if(!students.contains(groupHead))
            students.add(groupHead);
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void deleteStudent(Student student){
        if(student == groupHead){
            System.out.println("Head of group can't be removed from group!");
            return;
        }

        if(students.contains(student))
            students.remove(student);
    }

    public void renameStudent(int uid, String newName, String newSurname){
        for (Student student: students) {
            if(student.getID() == uid) {
                student.setName(newName);
                student.setSurname(newSurname);
            }
        }
    }

    public void addTask(String newTask){
        Set<Integer> emptySet = new HashSet<Integer>();
        tasks.put(newTask, emptySet);
    }

    public void completeTask(String task, int uid){
        Set<Integer> currentSet = tasks.get(task);
        currentSet.add(uid);
        tasks.put(task, currentSet);
    }

    private String getStudentbyId(int uid){
        for (Student student : students) {
            if (student.getID() == uid)
                return student.getName() + " " + student.getSurname();
        }
        return null;
    }

    public void printTasks(){
        for (Map.Entry<String, Set<Integer>> mapEntry : tasks.entrySet()) {
            String key = mapEntry.getKey();
            Set<Integer> currentSet = mapEntry.getValue();

            System.out.println("Task: " + key + " performed by: ");

            for(Integer taskPerformerId : currentSet) {
                String performer = getStudentbyId(taskPerformerId);
                if(performer != null) {
                    System.out.println(taskPerformerId + " " + performer);
                    break;
                }
            }
        }
    }
}
