/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.demo.controllers;

import com.bigdata.demo.entities.Student;
import com.bigdata.demo.repositories.StudentRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author binod
 * restcontrollelr=controller+responsebody
 */
@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/students")
    public List<Student> findAllStudent(){
      return studentRepository.findAll();
    }
    
     @GetMapping("/students/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Long id){
        
    Student student= studentRepository.findOne(id);
    if(student==null){
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(student);
    }
    
      @GetMapping(value = "/students",params ={"email"})
    public ResponseEntity<?> findStudentByEmail(@RequestParam String email){
        
    Student student= studentRepository.findByEmail(email);
    if(student==null){
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(student);
    }
    
     @GetMapping(value = "/students",params ={"email","action=search"})
    public ResponseEntity<?> searchStudentByEmail(@RequestParam String email){
        
    List<Student> studentList= studentRepository.findByEmailContaining(email);
    if(studentList.isEmpty()){
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(studentList);
    }
    
    @Transactional
    @PutMapping(value = "/students/{id}",params = {"action=update"})
    public ResponseEntity<?> updateStudentById(@PathVariable Long id,@RequestBody Student student){
        Student oldStudent =studentRepository.findOne(id);
        oldStudent.setAddress(student.getAddress());
        oldStudent.setName(student.getName());
        oldStudent.setEmail(student.getEmail());
        return ResponseEntity.ok("Student updated");
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentRepository.delete(id);
    }
   
    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        try {
              studentRepository.save(student);
              return ResponseEntity.ok("Data saved to prashant's database");
        } catch (Exception e) {
            
        return    ResponseEntity.badRequest().body("Couldn't insert data");
            
        }
      
        
    }
    @GetMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }
    
}
