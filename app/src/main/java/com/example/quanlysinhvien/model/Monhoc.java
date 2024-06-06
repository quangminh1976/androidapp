package com.example.quanlysinhvien.model;

public class Monhoc{
    //biến môn học
    private int id;
    private String tenmonhoc;
    private int sotinchi;
    private String thoigianhoc;
    private String diadiem;

    public int getId() {
        return id;
    }

    public Monhoc(int id, String tenmonhoc, int sotinchi, String thoigianhoc, String diadiem) {
        this.id = id;
        this.tenmonhoc = tenmonhoc;
        this.sotinchi = sotinchi;
        this.thoigianhoc = thoigianhoc;
        this.diadiem = diadiem;
    }

    public Monhoc(String tenmonhoc, int sotinchi, String thoigianhoc, String diadiem) {
        this.tenmonhoc = tenmonhoc;
        this.sotinchi = sotinchi;
        this.thoigianhoc = thoigianhoc;
        this.diadiem = diadiem;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public int getSotinchi() {
        return sotinchi;
    };

    public void setSotinchi(int sotinchi) {
        this.sotinchi = sotinchi;
    }

    public String getThoigianhoc() {
        return thoigianhoc;
    }

    public void setThoigianhoc(String thoigianhoc) {
        this.thoigianhoc = thoigianhoc;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }
}
