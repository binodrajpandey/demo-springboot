///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bigdata.demo.controllers;
//
//import com.bigdata.demo.entities.Student;
//import com.bigdata.demo.repositories.StudentRepository;
//import java.security.Principal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author binod
// */
////@Controller
//@RestController
//public class IndexController {
//    @Autowired
//    private StudentRepository studentRepository;
//    
//   @GetMapping("/hello")
//  //  @RequestMapping(method = RequestMethod.GET,value = "/hello")
//    public String hello(){
//        return "welcome to first app binod";
//    }
//     @RequestMapping("/user")
//  public Principal user(Principal principal) {
//    return principal;
//  }
//   @GetMapping("/binod")
//  Student findStudentByName(String name){
//      return studentRepository.findByName("binod");
//      
//  }
//}
