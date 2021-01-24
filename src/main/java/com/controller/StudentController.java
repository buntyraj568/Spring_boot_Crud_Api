package com.controller;
import com.model.Employee;
import com.model.Student;
import com.service.DocStorageService;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.service.EmployeeService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class StudentController
{

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentServiceImpl StorageService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        // create model attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student ) {
        // save Student to database
        studentService.saveStudent(student);

        return "demo_db";
    }

    @GetMapping("/showFormForUpdateStudent/{id}")
    public String showFormForUpdateStudent(@PathVariable( value = "id") long id, Model model) {

        // get student from the service
        Student student = studentService.getStudentById(id);

        // set student as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id) {

        // call delete Student method
        this.studentService.deleteStudentById(id);
         return "redirect:/";
    }


    @GetMapping("/pageStudent/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page < Student > page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List < Student > listStudent = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listStudent", listStudent);
        return "student_index";
    }

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file: files) {
            StorageService.saveFile(file);

        }
        return "redirect:/";
    }
    @GetMapping("/downloadFiles/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
       Student doc = StorageService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }
    @GetMapping("/down")
    public String deleteStudents()
    {


        return "download";
    }

}
