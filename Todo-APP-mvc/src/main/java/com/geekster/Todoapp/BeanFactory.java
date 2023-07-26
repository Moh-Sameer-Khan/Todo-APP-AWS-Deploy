package com.geekster.Todoapp;

import com.geekster.Todoapp.Entity.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanFactory {
    @Bean
    public List<Todo> getDataSource() {
        return new ArrayList<>(); // its match by list from in todoRepo, list will find object here will find Arraylist<> object
//        we can use now linked list anything / anytype of list pass from here
    }
}
