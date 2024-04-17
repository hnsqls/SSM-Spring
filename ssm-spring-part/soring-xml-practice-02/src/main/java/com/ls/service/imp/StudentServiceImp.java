package com.ls.service.imp;

import com.ls.Dao.StudentDao;
import com.ls.pojo.Student;
import com.ls.service.StudentService;

import java.util.List;

public class StudentServiceImp implements StudentService {
    //需要调用Dao层服务
    private StudentDao studentDao;
    //通过setter注入
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询所有学生信息 业务的实现
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        List<Student> allStudents = studentDao.findAllStudents();
        System.out.println("Service层----"+allStudents);
        return allStudents;
    }
}
