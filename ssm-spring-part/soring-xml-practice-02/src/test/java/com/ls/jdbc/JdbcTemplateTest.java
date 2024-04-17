package com.ls.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.ls.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/** jdbcTemplate的使用
 *     作用时简化数据库的CRUD 但是不提供连接池
 *     连接池引入 DruidDataSource 负责连接的创建和数据库驱动的注册
 *   1.实例化对象
 *   2.调用方法
 */
public class JdbcTemplateTest {

    @Test
    public  void testForJava(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        //jdbcTemplate.update()方法  插入 删除  修改
        //插入一条语句
        String sql = "insert into students (id,name,gender,age,class) values(?,?,?,?,?)";
        /** 参数1： sql语句 参数可以用？ 占位符
         *  参数2： Object ....param  可变参数，依次传入值
         *  return: 改变的行数
         */
        int rows = jdbcTemplate.update(sql, 1199, "ls", "男", "20", "软工二班");
        System.out.println("更改了" + rows +"行");

        //查询单条数据 jdbcTemplate.queryForObject() ，并返回对应的数据对象,映射
        sql ="select *from students where id = ?";
        /** 参数1： sql
         * 参数2： RowMapper<T>  列名和属性名的映射器接口
         *          要实现接口的方法映射 手动创建所映射的对象，然后从结果集获取值对应赋值给对象，然后返回对象
         * 参数3：object .....param
         * return :  映射的类型
         */
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                //rs 是sql的结果集  rownum 行数 不在意即可
                //手动将结果集映射到实体对象上
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setClasses(rs.getString("class"));

                return student;
            }
        }, new Object[]{1});
        System.out.println(student);

        //查询多条语句 jdbcTemplate.query()
        sql = "select id,name,gender,age,class as classes from students";

        /** 参数一： sql
         *  参数二：RowMapper<T>  列名和属性名的映射器接口，
         *             接口可以自己实现如上所示，也可以用其实现类BeanPropertyRowMapper<T>(xxx.class)
         *                  自动将结果集映射，但是前提是列明和属性名一致，如果有不一致的可以as起别名
         *                  BeanPropertyRowMapper<T>(xxx.class) 会自动映射列和属性值
         * return ： list<T>
         */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(studentList);

    }

}
