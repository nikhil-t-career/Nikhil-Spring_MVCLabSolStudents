package my.smvc.hib.controller;

import org.springframework.ui.Model;

public interface StudentController {

	String delete(int studentId);

	String listStudents(Model model);

	String addStudent(Model theModel);

	String updateStudent(int theId, Model theModel);

	String saveStudent(int id, String name, String department, String country);

}
