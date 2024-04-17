package com.ls.controller;

import com.ls.pojo.Student;
import com.ls.service.StudentService;

import java.util.List;

//控制层： 接受用户请求，处理请求参数 --->调用服务层，处理业务逻辑 --->将响应结果返回给用户（页面跳转）
public class StudentController {
    //调用服务层，处理业务逻辑
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public  void findAll(){
        List<Student> studentList = studentService.findAllStudent();
        System.out.println("controller---------"+studentList);
    }
}
