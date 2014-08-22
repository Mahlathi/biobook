package com.example.biobook.repository;

import com.example.biobook.domain.Student;

import java.util.List;

/**
 * Created by Davinci on 17/08/2014.
 */
public interface studentDatasourceDAO {
    public void createStudent(Student stud);
    public void updateStudent(Student stud);
    public Student findStudentById(int id);
    public void deleteStudent(Student stud);
    public Student getStudent();
    public List<Student> getStudentList();
}
