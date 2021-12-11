package my.smvc.hib.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import my.smvc.hib.entity.Student;

public interface StudentDao {

	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
}
