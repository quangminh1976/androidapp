package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quanlysinhvien.database.database;
import com.example.quanlysinhvien.model.student;

public class ActivityThemHocsinh extends AppCompatActivity {
    Button buttonThemhocsinh;
    EditText editTenSinhVien,editMaSinhVien,editNgaySinh;
    RadioButton radioButtonNam,radioButtonNu;
    database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hocsinh);


        buttonThemhocsinh=findViewById(R.id.buttonThemHocSinh);

        editTenSinhVien =findViewById(R.id.editTenSinhVien);
        editMaSinhVien =findViewById(R.id.editMaSinhVien);
        editNgaySinh =findViewById(R.id.editNgaySinh);
        radioButtonNam =findViewById(R.id.radioButtonNam);
        radioButtonNu =findViewById(R.id.radioButtonNu);


        Intent intent=getIntent();
        int id_Monhoc=intent.getIntExtra("id_Monhoc",0);
        database=new database(this);
        buttonThemhocsinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd(id_Monhoc);
            }
        });
    }
    private void DialogAdd(int id_Monhoc) {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialogaddhocsinh);
        dialog.setCanceledOnTouchOutside(false);


        Button btyes=dialog.findViewById(R.id.btyesThemsv);
        Button btno=dialog.findViewById(R.id.btnoThemsv);
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editTenSinhVien.getText().toString().trim();
                String id=editMaSinhVien.getText().toString().trim();
                String date=editNgaySinh.getText().toString().trim();
                String gioitinh="";
                if(radioButtonNam.isChecked()){
                    gioitinh="Nam";
                }else if(radioButtonNu.isChecked()){
                    gioitinh="Nữ";
                }
                if(name.equals("")||id.equals("")||date.equals("")||gioitinh.equals("")) {
                    Toast.makeText(ActivityThemHocsinh.this, "Vui Lòng Nhập Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                }else {
                    student student=CreateStudent(id_Monhoc);
                    database.AddHocsinh(student);
                    Intent intent =new Intent(ActivityThemHocsinh.this,activityHocsinh.class);
                    intent.putExtra("id_Monhoc",id_Monhoc);
                    startActivity(intent);
                    Toast.makeText(ActivityThemHocsinh.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                }

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
    private student CreateStudent(int id_subject){
        String name=editTenSinhVien.getText().toString().trim();
        String id=editMaSinhVien.getText().toString().trim();
        String date=editNgaySinh.getText().toString().trim();
        String gioitinh="";
        if(radioButtonNam.isChecked()){
            gioitinh="Nam";
        }else if(radioButtonNu.isChecked()){
            gioitinh="Nữ";
        }
        student student=new student(name,gioitinh,id,date,id_subject);
        return student;
    }
}