package com.ls.Dao;

import com.ls.pojo.Student;

import java.util.List;

/**
 * 操作学生类数据库的接口
 */
public interface StudentDao {

    /**
     * 查询所有学生数据
     * @return  学生集合
     */
    List<Student> findAllStudents();
}
