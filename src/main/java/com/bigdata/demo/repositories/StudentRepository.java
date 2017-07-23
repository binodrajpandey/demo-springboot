/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdata.demo.repositories;

import com.bigdata.demo.entities.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author binod
 */
public interface StudentRepository extends  JpaRepository<Student, Long>{
    Student findByEmail(String email);
    List<Student> findByEmailContaining(String email);
    
    
}
