package com.example.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.activityHocsinh;
import com.example.quanlysinhvien.model.student;

import java.util.ArrayList;

public class adapterhocsinh extends BaseAdapter {
    private activityHocsinh context;
    private ArrayList<student> ArraylistHocSinh;

    public adapterhocsinh(activityHocsinh context, ArrayList<student> arraylistHocSinh) {
        this.context = context;
        ArraylistHocSinh = arraylistHocSinh;
    }
    @Override
    public int getCount() {
        return ArraylistHocSinh.size();
    }

    @Override
    public Object getItem(int position) {
        return ArraylistHocSinh.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.liststudent,null);
        TextView txtName=view.findViewById(R.id.textViewName);
        TextView txtSdt=view.findViewById(R.id.textViewMsv);


        ImageButton imgXoa=view.findViewById(R.id.studentDelete);
        ImageButton imgSua=view.findViewById(R.id.studentUpdate);
        ImageButton imgThongTin=view.findViewById(R.id.studentInfomaTion);

        student student=ArraylistHocSinh.get(i);
        txtName.setText(student.getHo_ten());
        txtSdt.setText(student.getMa_sinh_vien());
        int id=student.getId_Hocsinh();
        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
