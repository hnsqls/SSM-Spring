package com.ls.service;

import com.ls.dao.StudentDao;
import com.ls.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> finAll();

}
