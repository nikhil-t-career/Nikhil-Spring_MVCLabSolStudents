package my.smvc.hib.controller;

import org.springframework.ui.Model;

import my.smvc.hib.entity.Student;

public interface StudentController {

	String showFormForUpdate(int theId, Model theModel);

	String listStudents(Model theModel);

	String showFormForAdd(Model theModel);

	String saveStudent(Student theStudent);

	String deleteStudent(int theId);

	

}
