package com.ls.dao.imp;

import com.ls.dao.StudentDao;
import com.ls.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> findAllStudent() {

//        String sql = "select id,name,age,gender,classes as class from Students;";
        String sql = "select id , name , age , gender , class as classes from students ;";

        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return  studentList;

    }
}
