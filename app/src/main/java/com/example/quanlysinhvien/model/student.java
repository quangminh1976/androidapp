package com.example.quanlysinhvien.model;

public class student {
    private int id_Hocsinh;
    private String ho_ten;
    private String gioi_tinh;
    private String ma_sinh_vien;
    private String ngay_sinh;
    private int id_monhoc;

    public student(String ho_ten, String gioi_tinh, String ma_sinh_vien, String ngay_sinh) {
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.ma_sinh_vien = ma_sinh_vien;
        this.ngay_sinh = ngay_sinh;
    }

    public student(String ho_ten, String gioi_tinh, String ma_sinh_vien, String ngay_sinh, int id_monhoc) {
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.ma_sinh_vien = ma_sinh_vien;
        this.ngay_sinh = ngay_sinh;
        this.id_monhoc = id_monhoc;
    }

    public student(int id_Hocsinh, String ho_ten, String gioi_tinh, String ma_sinh_vien, String ngay_sinh, int id_monhoc) {
        this.id_Hocsinh = id_Hocsinh;
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.ma_sinh_vien = ma_sinh_vien;
        this.ngay_sinh = ngay_sinh;
        this.id_monhoc = id_monhoc;
    }

    public int getId_Hocsinh() {
        return id_Hocsinh;
    }

    public void setId_Hocsinh(int id_Hocsinh) {
        this.id_Hocsinh = id_Hocsinh;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getMa_sinh_vien() {
        return ma_sinh_vien;
    }

    public void setMa_sinh_vien(String ma_sinh_vien) {
        this.ma_sinh_vien = ma_sinh_vien;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public int getId_monhoc() {
        return id_monhoc;
    }

    public void setId_monhoc(int id_monhoc) {
        this.id_monhoc = id_monhoc;
    }
}
