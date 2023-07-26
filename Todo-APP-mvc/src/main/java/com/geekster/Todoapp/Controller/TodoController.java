package com.geekster.Todoapp.Controller;

import com.geekster.Todoapp.Entity.Todo;
import com.geekster.Todoapp.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

//  creating an object of service class // dependency injection by @autowired
    @Autowired // now  controller class have access of service class
    TodoService todoService;

//    here we are using temporarily otherwise it should be in different class then inject in this claa thats good
    public TodoController() {

    }

//    see all todos list from here
    @GetMapping("todos")
    public List<Todo> getTodos(){
//        System.out.println("Todo is working");  //only formaility
        return todoService.getAllTodos(); // calling from service class
    }

//    I want to get a particular todo --> how --> by id
    @GetMapping("todos/{todoId}") // name should be plural and noun
    public Todo getTodoById(@PathVariable Integer todoId) {
        return todoService.getTodoById(todoId);
    }

//    its add all true todos
    @GetMapping("todo/done")
    public List<Todo> getDoneTodos() {
//        System.out.println("Done Todo working.");  //only formaility
       return todoService.getAllDoneTodos();
    }



//    its add all false todos
    @GetMapping("todo/undone")
    public List<Todo> getNotDoneTodos() {
//        System.out.println("Undone Todos working.."); //only formality
       return todoService.getUnDoneTodos();
    }

    //   without Todo json in postman it will give error // give data in the form of Json On based Todo class member
//    order should in same order in json form in postman
    @PostMapping("todo") // @PostMapping is used bcz this method is creating something
//    Here we will try multiple todos by array Home work but now only we are adding one todo at a time @Requestbody Todo todo make this array
    public String addTodo(@RequestBody Todo todo) { // we will send in the json form so @RequestBody
        return todoService.addTodo(todo);
    }

//    For marking done the todo task
//    we will change the status on this id
    @PutMapping("todo/{todoId}/{status}") // bcz updating here so putMapping // and we will pass todoId and status so taking Path variable
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status) {
        return todoService.updateTodoStatus(todoId, status);
    }

//    we want to delete any task from my todo
    @DeleteMapping("todo") // we are using @RequestParam use postman not path set here
    public String removeTodo(@RequestParam Integer todoId) {
        return todoService.removeTodo(todoId);
    }

}
