package com.ls.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.ls.service","com.ls.advice"})
@EnableAspectJAutoProxy
public class MainConfig {
}
