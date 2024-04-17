package com.ls.service;

import com.ls.pojo.Student;

import java.util.List;

//service 层接口
public interface StudentService {

    /**
     * 查询所有学生信息 ---业务
     * @return
     */
    List<Student> findAllStudent();
}
