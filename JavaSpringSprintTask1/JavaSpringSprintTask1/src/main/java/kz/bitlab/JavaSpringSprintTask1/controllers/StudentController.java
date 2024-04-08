package kz.bitlab.JavaSpringSprintTask1.controllers;

import kz.bitlab.JavaSpringSprintTask1.models.DBManager;
import kz.bitlab.JavaSpringSprintTask1.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class StudentController {
    @GetMapping(value = "/")
    public String students(Model model){
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("studenty", students);
        return "student";
    }
    @GetMapping(value = "/addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        DBManager.addStudent(student);
        return "redirect:/";
    }
}
