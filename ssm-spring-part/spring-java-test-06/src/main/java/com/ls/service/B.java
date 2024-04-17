package com.ls.service;

import com.ls.dao.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class B {
    @Autowired
    private A a;
    public void hello(){
        a.hello();
    }
}
