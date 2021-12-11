package my.smvc.hib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.smvc.hib.entity.Student;
import my.smvc.hib.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentControllerImpl implements StudentController {

	@Autowired
	StudentService studentService;

	@Override
	@GetMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "list-students";
	}

	@Override
	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@Override
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students/list";
	}

	@Override
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Student student = studentService.getStudent(id);
		model.addAttribute("student", student);
		return "student-form";
	}

	@Override
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		studentService.deleteStudent(id);
		return "redirect:/students/list";
	}
}
