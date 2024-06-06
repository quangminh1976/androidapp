package com.example.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quanlysinhvien.Activitymonhoc;
import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.model.Monhoc;

import java.util.ArrayList;

public class adapterSubject extends BaseAdapter {

    private Activitymonhoc context;
    private ArrayList<Monhoc> arrayListSubject;

    public adapterSubject(Activitymonhoc context, ArrayList<Monhoc> arrayListSubject) {
        this.context = context;
        this.arrayListSubject = arrayListSubject;
    }

    @Override
    public int getCount() {
        return arrayListSubject.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListSubject.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.listsubject,null);
        TextView TextViewSubjectTile=view.findViewById(R.id.textViewSubJectTiltle);
        TextView TextViewCredit=view.findViewById(R.id.textViewCredit);
        ImageButton imageDelete=view.findViewById(R.id.subjectDelete);
        ImageButton imageInfomation=view.findViewById(R.id.subjectInfomaTion);
        ImageButton imageUpdate=view.findViewById(R.id.subjectUpdate);

        Monhoc monhoc=arrayListSubject.get(i);
        TextViewCredit.setText(monhoc.getSotinchi()+"");
        TextViewSubjectTile.setText(monhoc.getTenmonhoc());
        int id=monhoc.getId();
        imageInfomation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Thongtin(id);
            }
        });
        imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.delete(id);
            }
        });

        imageUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.update(id);
            }
        });
        return view;
    }
}
