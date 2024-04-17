package com.ls.Dao.imp;

import com.ls.Dao.StudentDao;
import com.ls.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImp implements StudentDao {

    //使用jdbcTemplate
    private JdbcTemplate jdbcTemplate;
    //要使用setter注入 将jdbcTemplate 注入到 Dao层中
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查找所有的学生信息
     * @return
     */
    @Override
    public List<Student> findAllStudents() {
        String sql = "select id,name,age,gender,class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));

        System.out.println("dao-------------"+studentList);
        return studentList;
    }
}
