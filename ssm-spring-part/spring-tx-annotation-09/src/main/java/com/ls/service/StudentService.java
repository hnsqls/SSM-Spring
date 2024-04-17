package com.ls.service;

import com.ls.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = -1)
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 1. 只读模式 根据属性 readOnly = false 默认
     *      开启只读模式可以提升查询效率.
     *      但是一般查询没有必要添加事务，为什么还有只读模式
     *      因为有时候事务是添加在类上了，类中的查询方法要想提升效率，可以使用只读模式。
     *
     *
     *  2. 超时时间 timeout = -1 默认
     *  需要注意的是如果在类上设置了超时时间，
     *  但是在方法上又重新设置了事务，此时方法上的事务会覆盖类上的事务。
     *  如果类上事务设置了超时时间，但是方法上设置事务，但是没设置超时时间，此时就该方法的事务就无超时间。
     *
     *
     */

    public void changeInfo(){
        studentDao.updateAgeById(1000,1);

        System.out.println("-----------");
        studentDao.updateNameById("test222",1);
    }

    @Transactional(readOnly = true)
    public void getInfo(){
        //查询
    }
}
