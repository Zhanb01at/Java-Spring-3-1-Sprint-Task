package kz.bitlab.JavaSpringSprintTask1.models;


import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 7L;
    static {
        students.add(new Student(1L, "Zhanbolat", "Dauylbayev", 90, "A"));
        students.add(new Student(2L, "Killian", "Mbappe", 95, "A"));
        students.add(new Student(3L, "Mike", "Miller", 75, "B"));
        students.add(new Student(4L, "Leo", "Messi", 80, "B"));
        students.add(new Student(5L, "Cristiano", "Ronaldo", 50, "D"));
        students.add(new Student(6L, "Luis", "Suarez", 40, "F"));
    }
    public static void addStudent(Student student){
        if(student.getExam() >= 90 && student.getExam() <= 100){
            student.setMark("A");
        } else if (student.getExam() >= 75 && student.getExam() < 90) {
            student.setMark("B");
        } else if (student.getExam() >= 60 && student.getExam() < 75) {
            student.setMark("C");
        } else if (student.getExam() >= 50 && student.getExam() < 60) {
            student.setMark("D");
        } else if (student.getExam() >= 0 && student.getExam() < 50) {
            student.setMark("F");
        } else {
            student.setMark("ERROR");
        }
        students.add(student);
        student.setId(id++);
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static Student getStudent(Long id){
        return students.stream().filter(student -> student.getId()==id).findFirst().orElseThrow();
    }
}
