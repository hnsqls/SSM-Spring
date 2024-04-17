package com.ls.service.imp;

import com.ls.dao.StudentDao;
import com.ls.pojo.Student;
import com.ls.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> finAll() {
        List<Student> allStudent = studentDao.findAllStudent();
        System.out.println(allStudent);
        return  allStudent;
    }
}
