package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.example.quanlysinhvien.adapter.adapterSubject;
import com.example.quanlysinhvien.adapter.adapterhocsinh;
import com.example.quanlysinhvien.model.student;
import com.example.quanlysinhvien.database.database;

import java.util.ArrayList;

public class activityHocsinh extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    ArrayList<student> arrayListHocsinh;
    database database;
    adapterhocsinh adapterStudent;

    int id_Monhoc=0;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hocsinh);


        toolbar=findViewById(R.id.toolbarHocsinh);
        listView=findViewById(R.id.listviewHocsinh);
        Intent intent=getIntent();
        id_Monhoc=intent.getIntExtra("id_Monhoc",0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        database=new database(this);
        arrayListHocsinh=new ArrayList<>();
        arrayListHocsinh.clear();
        Cursor cursor=database.GetdataHocsinh(id_Monhoc);
        while(cursor.moveToNext()){
            int id_sub=cursor.getInt(5);
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String sex=cursor.getString(2);
            String code=cursor.getString(3);
            String date=cursor.getString(4);
            arrayListHocsinh.add(new student(id,name,sex,code,date,id_sub));

        }
        adapterhocsinh adapterhocsinh = new adapterhocsinh(activityHocsinh.this, arrayListHocsinh);
        cursor.moveToFirst();
        cursor.close();
        listView.setAdapter(adapterhocsinh);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuaddhocsinh,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menuaddHocsinh) {
            Intent intent=new Intent(activityHocsinh.this,ActivityThemHocsinh.class);
            intent.putExtra("id_Monhoc",id_Monhoc);
            startActivity(intent);
        }else{
            Intent intent1=new Intent(activityHocsinh.this,Activitymonhoc.class);
            startActivity(intent1);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        counter++;
        if(counter>=1){
            Intent intent=new Intent(this,Activitymonhoc.class);
            startActivity(intent);
            finish();
        }
    }
}