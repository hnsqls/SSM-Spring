package com.ls.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ls.dao","com.ls.service"})
public class MainConfig {
}
