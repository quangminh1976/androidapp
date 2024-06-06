package com.example.quanlysinhvien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlysinhvien.model.Monhoc;
import com.example.quanlysinhvien.model.student;

public class database extends SQLiteOpenHelper {

    //Tên database
    private static String DATABASE_NAME = "studentmanagement";
    //Bảng môn học
    private static String TABLE_SUBJECTS = "subject";
    private static String ID_SUBJECTS = "idsubject";
    private static String SUBJECT_TITLE = "subjecttitle";
    private static String CREDITS = "credits";
    private static String TIME = "time";
    private static String PLACE = "place";
    private static final int VERSION = 1;

    //Bảng sinh viên
    private static String TABLE_STUDENT = "student";
    private static String ID_STUDENT = "idstudent";
    private static String STUDENT_NAME = "sudentname";
    private static String SEX = "sex";
    private static String STUDENT_CODE = "studentcode";
    private static String DATE_OF_BIRTH = "dateofbirth";


    //Tạo bảng môn học
    private String SQLQuery = "CREATE TABLE "+ TABLE_SUBJECTS +" ( "+ID_SUBJECTS+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +SUBJECT_TITLE+" TEXT, "
            +CREDITS+" INTEGER, "

            +TIME+" TEXT, "
            + PLACE+" TEXT) ";

    //Tạo bảng sinh viên
    private String SQLQuery1 = "CREATE TABLE "+ TABLE_STUDENT +" ( "+ID_STUDENT+" integer primary key AUTOINCREMENT, "
            +STUDENT_NAME+" TEXT, "
            +SEX+" TEXT, "
            +STUDENT_CODE+" TEXT, "
            +DATE_OF_BIRTH+" TEXT, "
            +ID_SUBJECTS+" INTEGER , FOREIGN KEY ( "+ ID_SUBJECTS +" ) REFERENCES "+
            TABLE_SUBJECTS+"("+ID_SUBJECTS+"))";

    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        sqLiteDatabase.execSQL(SQLQuery1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    };
    //phương thức ínert subject
    public void Addmonhoc(Monhoc monhoc){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SUBJECT_TITLE,monhoc.getTenmonhoc());
        values.put(CREDITS,monhoc.getSotinchi());
        values.put(TIME,monhoc.getThoigianhoc());
        values.put(PLACE,monhoc.getDiadiem());
        db.insert(TABLE_SUBJECTS,null,values);
        db.close();
    };
    //cập nhật môn học
    public boolean capnhatmonhoc(Monhoc monhoc,int id){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();values.put(SUBJECT_TITLE,monhoc.getTenmonhoc());
        values.put(CREDITS,monhoc.getSotinchi());
        values.put(TIME,monhoc.getThoigianhoc());
        values.put(PLACE,monhoc.getDiadiem());
        db.update(TABLE_SUBJECTS,values,ID_SUBJECTS+"="+id,null);
        return true;
    };
    //lấy dữ liệu môn học
    public Cursor Getdatamonhoc(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor curso=db.rawQuery("SELECT * FROM "+TABLE_SUBJECTS,null);
        return curso;
    };
    //xóa môn học
    public int xoamonhoc(int i){
        SQLiteDatabase db=this.getWritableDatabase();
        int res=db.delete(TABLE_SUBJECTS,ID_SUBJECTS+"="+i,null);
        return res;
    }
    public int Xoahocsinh(int i){
        SQLiteDatabase db=this.getWritableDatabase();
        int res=db.delete(TABLE_STUDENT,ID_SUBJECTS+"="+i,null);
        return res;
    }
    public void AddHocsinh(student hocsinh){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(STUDENT_NAME,hocsinh.getId_Hocsinh());
        values.put(SEX,hocsinh.getGioi_tinh());
        values.put(STUDENT_CODE,hocsinh.getMa_sinh_vien());
        values.put(DATE_OF_BIRTH,hocsinh.getNgay_sinh());
        values.put(ID_SUBJECTS,hocsinh.getId_monhoc());
        db.insert(TABLE_STUDENT,null,values);
        db.close();
    };
    public Cursor GetdataHocsinh(int id_monhoc){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor curso=db.rawQuery("SELECT * FROM "+TABLE_STUDENT+" WHERE "+ID_SUBJECTS+" = "+id_monhoc,null);
        return curso;
    };
    public int Xoáinhvien(int i){
        SQLiteDatabase db=this.getWritableDatabase();
        int res=db.delete(TABLE_STUDENT,ID_STUDENT+"="+i,null);
        return res;
    };
}
