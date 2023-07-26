package com.geekster.Todoapp.Entity;

public class Todo {
//    private int todoId; / or taking for unique task not duplicacy
    private Integer todoId;
    private String todoName; // task name
    private boolean isTodoDoneStatus; // that task is done or not

//    we want to save our todo task anywhere then we will use List // make repository pakcage and todoRepo class

//Making getter setter for all data members
    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public boolean isTodoDoneStatus() {
        return isTodoDoneStatus;
    }

    public void setTodoDoneStatus(boolean todoDoneStatus) {
        isTodoDoneStatus = todoDoneStatus;
    }
}
