package my.smvc.hib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.smvc.hib.dao.StudentDao;
import my.smvc.hib.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDaoImpl;

    @Override
    @Transactional
    public List < Student > getStudents() {
        return studentDaoImpl.getStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        studentDaoImpl.saveStudent(theStudent);
    }

    @Override
    @Transactional
    public Student getStudent(int theId) {
        return studentDaoImpl.getStudent(theId);
    }

    @Override
    @Transactional
    public void deleteStudent(int theId) {
        studentDaoImpl.deleteStudent(theId);
    }
}
