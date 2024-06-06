package com.example.quanlysinhvien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btmonhoc,bttacgia,btthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar=getSupportActionBar();
//        actionbar.hide();
        btmonhoc=findViewById(R.id.btmonhoc);
        bttacgia=findViewById(R.id.bttacgia);
        btthoat=findViewById(R.id.btthoat);
        //click môn học
        btmonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activitymonhoc.class);
                startActivity(intent);
            }
        });
        //click tác giả
        bttacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAuthor();
            }
        });
        //click thoát
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogthoat();
            }
        });
    }
    //dialog tác giả
    private void DialogAuthor() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialogloginfm);
        dialog.show();
        Button thoatne=dialog.findViewById(R.id.thoat);
        thoatne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
    //dialog thoát
    private void Dialogthoat(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialogthoat);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        Button btdongy= dialog.findViewById(R.id.btyes);
        Button btthoat=dialog.findViewById(R.id.btno);
        btdongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                Intent intent1= new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
}