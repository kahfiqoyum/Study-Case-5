package com.example.qoyumalkahfi.qoyum_1202154125_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDo extends AppCompatActivity {

    private EditText ToDo, Description, Priority;
    private Database db;
    //berisi variabel yang digunakan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        setTitle("Add To Do");
        ToDo = (EditText) findViewById(R.id.edt_Todo);
        Description = (EditText) findViewById(R.id.edt_Desc);
        Priority = (EditText) findViewById(R.id.edt_Priority);
        db = new Database(this);
        //inisialisasi variabel yang digunakan
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddToDo.this, ToDoList.class);
        startActivity(intent);
        this.finish();
        //memulai intent baru pada class ToDoList
    }

    public void addTodo(View view) {
        //berisi methoh bila button tambah di klik
        if (db.inputdata(new AddData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //Menambahkan data input ke database
            Toast.makeText(this, "Berhasil menambahkan", Toast.LENGTH_SHORT).show();
            //memunculkan toast bila semua edit text sudah di isi
            startActivity(new Intent(AddToDo.this, ToDoList.class));
            this.finish();
            //memulai intent baru pada class ToDoList
        }else {
            Toast.makeText(this, "Isi list terlebih dahulu", Toast.LENGTH_SHORT).show();
            //memunculkan toast bila ada edit text yang belum di isi
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
            //membuat edit text menjadi kosong
        }
    }
}
