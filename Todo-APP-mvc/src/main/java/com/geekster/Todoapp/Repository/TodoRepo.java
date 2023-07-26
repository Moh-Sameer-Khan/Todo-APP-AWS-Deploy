package com.geekster.Todoapp.Repository;

import com.geekster.Todoapp.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
//or
@Repository // making an object // and its meaningful
public class TodoRepo {
    @Autowired
    private List<Todo> myTodos; // import the Todo class // it's every element will be like this who passing in --> <Todo>

    public List<Todo> getMyTodos() {
        return myTodos;
    }

    // for make loose coupling the make a class and pass by an object and Autowired use in this class
//    public TodoRepo() {
//        //    we want to save our todo task anywhere then we will use List
//        //    this is source code so use here now but it use in repository (Note ; now is perfect location)
//        myTodos = new ArrayList<>();
////        here we are using high coupling code
//    }

//    for adding
    public void add(Todo todo) {
        myTodos.add(todo);
    }

//    for removing
    public void delete(Todo todo) {
        myTodos.remove(todo);
    }

}
