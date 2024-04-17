package com.ls.dao;

import com.ls.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> findAllStudent();
}
