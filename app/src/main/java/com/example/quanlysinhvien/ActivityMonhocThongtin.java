package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityMonhocThongtin extends AppCompatActivity {
    TextView edittenmonhoc,editSoTinChi,editmonhoctime,editmonhocdiadiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monhoc_thongtin);
        editSoTinChi=findViewById(R.id.textSoTinChi);
        edittenmonhoc =findViewById(R.id.textTenMonhoc);
        editmonhoctime =findViewById(R.id.textThoiGian);
        editmonhocdiadiem =findViewById(R.id.textDiaDiem);
        Intent intent=getIntent();
        String tilte    = intent.getStringExtra("title");
        int credit   = intent.getIntExtra("credit",0);
        String time     = intent.getStringExtra("time");
        String place    = intent.getStringExtra("place");
        edittenmonhoc.setText(tilte);
        editSoTinChi.setText(String.valueOf(credit));
        editmonhoctime.setText(time);
        editmonhocdiadiem.setText(place);
    }
}