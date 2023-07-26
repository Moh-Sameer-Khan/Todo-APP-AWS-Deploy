package com.geekster.Todoapp.Controller;

import com.geekster.Todoapp.Entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {


    //    we want to save our todo task anywhere then we will use List
    private List<Todo> myTodos; // import the Todo class // it's every element will be like this who passing in --> <Todo>

//    here we are using temporarily otherswise it should be in different class then inject in this claa thats good
    public TodoController() {
        myTodos = new ArrayList<>();
//        here we are using high coupling code
    }

//    see all todos list from here
    @GetMapping("todos")
    public List<Todo> getTodos(){
//        System.out.println("Todo is working");  //only formaility
        return myTodos;
    }
//    its add all true todos
    @GetMapping("todo/done")
    public List<Todo> getDoneTodos() {
//        System.out.println("Done Todo working.");  //only formaility
        List<Todo> doneTodos = new ArrayList<>();
        for(Todo myTodo : myTodos) {
            if(myTodo.isTodoDoneStatus()) {
                doneTodos.add(myTodo);
            }
        }
        return doneTodos;
    }



//    its add all false todos
    @GetMapping("todo/undone")
    public List<Todo> getNotDoneTodos() {
//        System.out.println("Undone Todos working.."); //only formaility
        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo myTodo : myTodos) {
            if(!myTodo.isTodoDoneStatus()) {
                unDoneTodos.add(myTodo);
            }
        }
        return unDoneTodos;
    }

    //   without Todo json in postman it will give error // give data in the form of Json On based Todo class member
//    order should in same order in json form in postman
    @PostMapping("todo") // @PostMapping is used bcz this method is creating something
//    Here we will try multiple todos by array Home work but now only we are adding one todo at a time @Requestbody Todo todo make this array
    public String addTodo(@RequestBody Todo todo) { // we will send in the json form so @RequestBody
        myTodos.add(todo);
        return "Todo Added";
    }

//    For marking done the todo task
//    we will change the status on this id
    @PutMapping("todo/{todoId}/{status}") // bcz updating here so putMapping // and we will pass todoid and status so taking Path variable
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status) {
        for(Todo myTodo : myTodos) {
            if(myTodo.getTodoId().equals(todoId)) { // Integer an object so we use equals comparison object not use ==
                myTodo.setTodoDoneStatus(status);
                return "Todo updated for todo ID : " + todoId;
            }
        }
        return "Todo not Found todo ID : " + todoId;
    }

//    we want to delete any task from my todo
    @DeleteMapping("todo") // we are using @RequestParam use postman not path set here
    public String removeTodo(@RequestParam Integer todoId) {
        for(Todo myTodo : myTodos) {
            if(myTodo.getTodoId().equals(todoId)) {
                myTodos.remove(myTodo);
                return "Todo removed for todo ID : " + todoId;
            }
        }
        return "Todo ID " + todoId + " was not deleted as it does not exist";

//        or we can use funtion loop
//        myTodos.removeIf(myTodo -> myTodo.getTodoId().equals(todoId));
//        return "Todo removed for todo ID : " + todoId;
    }

}
