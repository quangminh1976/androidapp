package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysinhvien.database.database;
import com.example.quanlysinhvien.model.Monhoc;

public class ActivityUpdate extends AppCompatActivity {
    EditText edittenmonhoc,editSoTinChi,editmonhoctime,editmonhocdiadiem;
    Button btnUpdateMonhoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edittenmonhoc =findViewById(R.id.editUpdateTenmonhoc);
        editSoTinChi =findViewById(R.id.editUpdateMonhocid);
        editmonhoctime =findViewById(R.id.editUpdateMonhoctime);
        editmonhocdiadiem =findViewById(R.id.editUpdateMonhocDiadiem);
        btnUpdateMonhoc =findViewById(R.id.buttonUpdateMonhoc);
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        String tilte    = intent.getStringExtra("title");
        int credit   = intent.getIntExtra("credit",0);
        String time     = intent.getStringExtra("time");
        String place    = intent.getStringExtra("place");
        edittenmonhoc.setText(tilte);
        editSoTinChi.setText(String.valueOf(credit));
        editmonhoctime.setText(time);
        editmonhocdiadiem.setText(place);
        btnUpdateMonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogupdate(id);
            }
        });


    }
    private void Dialogupdate(int id) {
        Dialog dialogg=new Dialog(this);
        dialogg.setContentView(R.layout.dialogupdate);
        dialogg.setCanceledOnTouchOutside(false);
        Button btyes=dialogg.findViewById(R.id.btyesUpdate);
        Button btno=dialogg.findViewById(R.id.btnoUpdate);
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjecttitle=edittenmonhoc.getText().toString().trim();
                String credit=editSoTinChi.getText().toString().trim();
                String time=editmonhoctime.getText().toString().trim();
                String place=editmonhocdiadiem.getText().toString().trim();

                if(subjecttitle.equals("")||credit.equals("")||time.equals("")||place.equals("")){
                    Toast.makeText(ActivityUpdate.this, "Bạn chưa điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    Monhoc monhoc= updateMonhoc();
                    database database=new database(ActivityUpdate.this);
                    database.capnhatmonhoc(monhoc,id);
                    Intent intent    =new Intent(ActivityUpdate.this,Activitymonhoc.class);
                    startActivity(intent);
                    Toast.makeText(ActivityUpdate.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogg.cancel();
            }
        });
        dialogg.show();
    }
    private Monhoc updateMonhoc(){
        String subjecttitle=edittenmonhoc.getText().toString().trim();
        int credit=Integer.parseInt(editSoTinChi.getText().toString().trim());
        String time=editmonhoctime.getText().toString().trim();
        String place=editmonhocdiadiem.getText().toString().trim();
        Monhoc monhoc=new Monhoc(subjecttitle,credit,time,place);
        return monhoc;
    }
}