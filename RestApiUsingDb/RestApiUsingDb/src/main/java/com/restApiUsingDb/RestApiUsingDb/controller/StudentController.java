package com.restApiUsingDb.RestApiUsingDb.controller;

import com.restApiUsingDb.RestApiUsingDb.model.Student;
import com.restApiUsingDb.RestApiUsingDb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //insert student
    @PostMapping
    public ResponseEntity<String> saveStudents(@RequestBody Student student){
        String s = studentService.saveStudent(student);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }


    //get single studnet
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        Student student = studentService.getStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    //update student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int id)
    {
        Student student1 = studentService.updateStudents(student, id);
        return new ResponseEntity<>(student1,HttpStatus.OK);

    }

    //get All student
    @GetMapping("/get-all")
    public ResponseEntity<List<Student> > getAllStudent(){
        List<Student> students =  studentService.getAllStudent();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
         studentService.delete(id);
         return new ResponseEntity<>("Delete Successfully",HttpStatus.OK);
    }
//    @ExceptionHandler
//    public ResponseEntity<String> exceptionHandler(Exception ex){
//        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//
//    }


}
