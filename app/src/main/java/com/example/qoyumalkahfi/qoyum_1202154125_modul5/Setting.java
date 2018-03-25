package com.example.qoyumalkahfi.qoyum_1202154125_modul5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    private TextView warna;
    int colorid;
    AlertDialog.Builder alert;
    SharedPreferences.Editor sharedpref;
    //berisi variabel yang digunakan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        alert = new AlertDialog.Builder(this);
        SharedPreferences sharedP = getApplicationContext().getSharedPreferences("Preferences", 0);
        sharedpref = sharedP.edit();
        colorid = sharedP.getInt("Colourground", R.color.white);
        warna = findViewById(R.id.shapecolor);
        warna.setText(getShapeColor(colorid));
        //inisialisasi variabel yang digunakan
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Setting.this, ToDoList.class);
        startActivity(intent);
        finish();
        //memulai intent baru pada class ToDoList
    }

    //method yang dijalankan ketika pilihan pada menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            //menjalankan method onbackpressed
            this.onBackPressed();
        }
        return true;
    }

    public String getShapeColor(int i){
        if (i==R.color.red){
            return "Red";
        }else if (i==R.color.green){
            return "Green";
        }else if (i==R.color.blue){
            return "Blue";
        }else{
            return "Default";
        }
    }//menentukan string warna yang digunakan

    public int getColorid(int i){
        if (i==R.color.red){
            return R.id.red;
        }else if (i==R.color.green){
            return R.id.green;
        }else if (i==R.color.blue){
            return R.id.blue;
        }else{
            return R.id.white;
        }
    }//mendapatkan id dari warna yang digunakan

    public void pilihWarna(View view) {
        alert.setTitle("Shape Color");
        View view1 = getLayoutInflater().inflate(R.layout.color_setting, null);
        alert.setView(view1);
        //menampilkan view yang telah dibuat

        //mengakses radio group pada layout
        final RadioGroup radG = view1.findViewById(R.id.radio_color);
        radG.check(getColorid(colorid));

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { //ketika menekan Cancel Ok alert dialog
                int a = radG.getCheckedRadioButtonId();
                switch (a){
                    case R.id.red:
                        colorid = R.color.red;
                        break;
                    case R.id.green:
                        colorid = R.color.green;
                        break;
                    case R.id.blue:
                        colorid = R.color.blue;
                        break;
                    case R.id.white:
                        colorid = R.color.white;
                        break;
                }//mendapatkan id radio button yang di pilih

                warna.setText(getShapeColor(colorid));
                sharedpref.putInt("Colourground", colorid);
                sharedpref.commit();
                //set shape color sesuai color id yang dipilih
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }); //ketika menekan Cancel pada alert dialog

        alert.create().show();
        //membuat dan menampilkan alert dialog
    }
}

