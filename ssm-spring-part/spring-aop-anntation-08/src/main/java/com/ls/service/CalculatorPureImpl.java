package com.ls.service;

import org.springframework.stereotype.Service;

/**
 * 实现计算接口,单纯添加 + - * / 实现! 掺杂其他功能!
 */

@Service
public class CalculatorPureImpl implements Calculator {
    
    @Override
    public int add(int i, int j) {

        int result = i + j;

        return result;
    }
    
    @Override
    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }
    
    @Override
    public int mul(int i, int j) {

        int result = i * j;

        return result;
    }
    
    @Override
    public int div(int i, int j) {

        int result = i / j;

        return result;
    }
}
