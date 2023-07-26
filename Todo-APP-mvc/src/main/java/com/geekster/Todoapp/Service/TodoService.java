package com.geekster.Todoapp.Service;

import com.geekster.Todoapp.Entity.Todo;
import com.geekster.Todoapp.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Component // making for object from side of spring side
//or
//@Service//
//@Component
//or
@Service // its have inside @Component same work like that check by ctrl + c
public class TodoService {
//    here will write Business logic code // and creates an object in controller class

    @Autowired
    TodoRepo todoRepo;


    //    see all todos list from here
    public List<Todo> getAllTodos() {
        return todoRepo.getMyTodos();
    }

    //    its add all true todos
    public List<Todo> getAllDoneTodos() {
        List<Todo> doneTodos = new ArrayList<>();
        for(Todo myTodo : todoRepo.getMyTodos()) {
            if(myTodo.isTodoDoneStatus()) {
                doneTodos.add(myTodo);
            }
        }
        return doneTodos;
    }

    //    its add all false todos
    public List<Todo> getUnDoneTodos() {
        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo myTodo : todoRepo.getMyTodos()) {
            if(!myTodo.isTodoDoneStatus()) {
                unDoneTodos.add(myTodo);
            }
        }
        return unDoneTodos;
    }

    //   without Todo json in postman it will give error // give data in the form of Json On based Todo class member
//    adding the todos in my Todo and return a message
    public String addTodo(Todo myTodo) {
        todoRepo.add(myTodo);
        return "Todo Added";
    }

    //    For marking done the todo task
//    we will change the status on this id
    public String updateTodoStatus(Integer todoId, boolean status) {
        for(Todo myTodo : todoRepo.getMyTodos()) {
            if(myTodo.getTodoId().equals(todoId)) { // Integer an object So we use equals comparison object not use ==
                myTodo.setTodoDoneStatus(status);
                return "Todo updated for todo ID : " + todoId;
            }
        }
        return "Todo not Found todo ID : " + todoId;
    }

    //    we want to delete any task from my todo
    public String removeTodo(Integer todoId) {
        for(Todo myTodo : todoRepo.getMyTodos()) {
            if(myTodo.getTodoId().equals(todoId)) {
                todoRepo.delete(myTodo);
                return "Todo removed for todo ID : " + todoId;
            }
        }
        return "Todo ID " + todoId + " was not deleted as it does not exist";

//        or we can use function loop
//        myTodos.removeIf(myTodo -> myTodo.getTodoId().equals(todoId));
//        return "Todo removed for todo ID : " + todoId;
    }

//    I want to get a particular todo from Todo
    public Todo getTodoById(Integer todoId) {
//        I need iterator on todo for that id todo
        for (Todo todo : todoRepo.getMyTodos()) {
            if(todo.getTodoId().equals(todoId)) {
                return todo;
            }
        }
        return null;
//        for just practicing this one // show 500(Internal server error) in postman
//        if postman api path wrong then 400/404 not found error
//        throw new IllegalStateException("id not found");

    }
}
