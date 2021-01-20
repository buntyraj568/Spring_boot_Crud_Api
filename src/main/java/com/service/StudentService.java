package com.service;
import java.util.List;

import com.model.Employee;
import com.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;


public interface StudentService
{
    List<Student> getAllStudent();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
    Page<Student> findPaginated(int pageNo, int pageSize);
    Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
