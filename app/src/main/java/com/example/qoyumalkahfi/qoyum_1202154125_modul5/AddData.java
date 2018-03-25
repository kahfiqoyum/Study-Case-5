package com.example.qoyumalkahfi.qoyum_1202154125_modul5;

public class AddData {
    String todo, desc, prior;
    //berisi variabel yang digunakan

    public AddData(String todo, String desc, String prior){
        this.todo=todo;
        this.desc=desc;
        this.prior=prior;
        //inisialisasi variabel yang digunakan
    }

    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    //method setter dan getter pada to do

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    //method setter dan getter pada description

    public String getPrior() {
        return prior;
    }
    public void setPrior(String prior) {
        this.prior = prior;
    }
    //method setter dan getter pada priority
}
