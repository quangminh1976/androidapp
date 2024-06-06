package com.example.quanlysinhvien;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.quanlysinhvien.adapter.adapterSubject;
import com.example.quanlysinhvien.database.database;
import com.example.quanlysinhvien.model.Monhoc;

import java.util.ArrayList;

public class Activitymonhoc extends AppCompatActivity {
    Toolbar toolbar;
    ListView listViewSubject;
    ArrayList<Monhoc> arrayListMonhoc;
    com.example.quanlysinhvien.database.database database;
    com.example.quanlysinhvien.adapter.adapterSubject adapterSubject;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitymonhoc);


        toolbar =findViewById(R.id.toolbarmonhoc);
        listViewSubject=findViewById(R.id.listViewmonhoc);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database =new database(this);
        arrayListMonhoc=new ArrayList<>();

        Cursor cursor =database.Getdatamonhoc();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String title=cursor.getString(1);
            int credit=cursor.getInt(2);
            String time=cursor.getString(3);
            String place =cursor.getString(4);
            arrayListMonhoc.add(new Monhoc(id,title,credit,time,place));

        }
        adapterSubject=new adapterSubject(Activitymonhoc.this,arrayListMonhoc);
        listViewSubject.setAdapter(adapterSubject);
        cursor.moveToFirst();
        cursor.close();
        listViewSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(Activitymonhoc.this,activityHocsinh.class);
                int id_Monhoc=arrayListMonhoc.get(position).getId();
                intent.putExtra("id_Monhoc",id_Monhoc);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuadd,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if (item.getItemId() == R.id.menuadd) {
            Intent intent1 = new Intent(Activitymonhoc.this, activityAddSubject.class);
            startActivity(intent1);
        } else {
            Intent intent = new Intent(Activitymonhoc.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        count++;
        if(count>=1){
            Intent intent=new Intent(Activitymonhoc.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }
    public void Thongtin(final int pos){
        Cursor cursor  =database.Getdatamonhoc();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            if(id==pos){
                Intent intent=new Intent(Activitymonhoc.this,ActivityMonhocThongtin.class);
                intent.putExtra("id",id);
                String title=cursor.getString(1);
                int credit= cursor.getInt(2);
                String time=cursor.getString(3);
                String place=cursor.getString(4);
                intent.putExtra("title",title);
                intent.putExtra("credit",credit);
                intent.putExtra("time",time);
                intent.putExtra("place",place);
                startActivity(intent);
            }
        }
    }
    public void delete(final int position){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialoggdeletemonhoc);
        dialog.setCanceledOnTouchOutside(false);
        Button btyes=dialog.findViewById(R.id.btyesdelete);
        Button btno= dialog.findViewById(R.id.btnodelete);
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database =new database(Activitymonhoc.this);
                database.xoamonhoc(position);
                database.Xoahocsinh(position);
                Intent intent =new Intent(Activitymonhoc.this,Activitymonhoc.class);
                startActivity(intent);
            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    public void update(final int pos){
        Cursor cursor=database.Getdatamonhoc();
        while(cursor.moveToNext()){
            int id=cursor.getInt(0);
            if(id==pos){
                Intent intent=new Intent(Activitymonhoc.this,ActivityUpdate.class);
                intent.putExtra("id",id);
                String title=cursor.getString(1);
                int credit=cursor.getInt(2);
                String time=cursor.getString(3);
                String place=cursor.getString(4);
                intent.putExtra("title",title);
                intent.putExtra("credit",credit);
                intent.putExtra("time",time);
                intent.putExtra("place",place);
                startActivity(intent);
            }
        }
    }

}
