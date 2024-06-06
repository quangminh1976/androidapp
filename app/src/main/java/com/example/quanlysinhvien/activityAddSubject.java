package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysinhvien.database.database;
import com.example.quanlysinhvien.model.Monhoc;

import javax.security.auth.Subject;

public class activityAddSubject extends AppCompatActivity {
    Button buttonThemMonhoc;

    EditText edittenmonhoc,editmonhocid,editmonhoctime,editmonhocdiadiem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        buttonThemMonhoc =findViewById(R.id.buttonThemMonhoc);
        edittenmonhoc=findViewById(R.id.editTenmonhoc);
        editmonhocid =findViewById(R.id.editMonhocid);
        editmonhoctime =findViewById(R.id.editMonhoctime);
        editmonhocdiadiem =findViewById(R.id.editMonhocDiadiem);
        database database = new database(this);
        buttonThemMonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogadd();
            }
        });


    }
    private void Dialogadd(){
        Dialog dialog=new Dialog(this);

        dialog.setContentView(R.layout.dialogadd);
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes=dialog.findViewById(R.id.btyes);
        Button btnNo=dialog.findViewById(R.id.btno);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tenmonhoc=edittenmonhoc.getText().toString().trim();
                String credit=editmonhocid.getText().toString().trim();
                String time=editmonhoctime.getText().toString().trim();
                String place=editmonhocdiadiem.getText().toString().trim();

                if(tenmonhoc.equals("")||credit.equals("")||time.equals("")||place.equals("")){
                    Toast.makeText(activityAddSubject.this,"Bạn cần điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else {

                    Monhoc monhoc = CreatMonhoc();
                    database database = new database(activityAddSubject.this);
                    database.Addmonhoc(monhoc);


                    Intent intent=new Intent(activityAddSubject.this,Activitymonhoc.class);
                    startActivity(intent);
                    Toast.makeText(activityAddSubject.this, "thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    private Monhoc CreatMonhoc(){
        String tenmonhoc=edittenmonhoc.getText().toString().trim();
        int credit=Integer.parseInt(editmonhocid.getText().toString().trim());
        String time=editmonhoctime.getText().toString().trim();
        String place=editmonhocdiadiem.getText().toString().trim();
        Monhoc monho=new Monhoc(tenmonhoc,credit,time,place);
        return monho;
    }
}
