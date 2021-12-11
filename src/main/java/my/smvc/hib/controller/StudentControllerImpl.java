package my.smvc.hib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.smvc.hib.entity.Student;
import my.smvc.hib.service.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentControllerImpl implements StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@Override
	@RequestMapping("/list")
	public String listStudents(Model model) {

		System.out.println("Inside the StudentController -> ");

		// get the Students from db;
		List<Student> studentsList = studentServiceImpl.getStudents();

		// add to the spring model
		model.addAttribute("studentsList", studentsList);

		return "index";
//		return "list-students";// list-Students
	}

	@Override
	@RequestMapping("/addstudent")
	public String addStudent(Model model) {
		// create model attribute to bind form data.
		Student newStudent = new Student();
		model.addAttribute("student", newStudent);

		return "student-form";// Student-form
	}

	@Override
	@RequestMapping("/updatestudent")
	public String updateStudent(@RequestParam("id") int id, Model model) {

		// get the Student from the service
		Student student = studentServiceImpl.getStudent(id);

		// set Student as a model attribute to pre-populate the form
		model.addAttribute("student", student);

		// send over to our form
		return "student-form";
	}

	@Override
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println("Saving with Id :" + id);

		Student student;
		if (id != 0) {
			// Update Operation
			student = studentServiceImpl.getStudent(id);

			// put updated values to the Student object found from database.
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);

		} else {
			// Create Operation
			student = new Student(name, department, country);
		}

		studentServiceImpl.saveStudent(student);
		return "redirect:/students/list";
	}

	@Override
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		// delete the student
		studentServiceImpl.deleteStudent(id);
		return "redirect:/students/list";
	}
}
