package com.example.ktckdidongnhom16.models;

public class ThongTinCN {
    private String ten;
    private String mssv;
    private String lop;
    private int hinhAnh;

    public ThongTinCN(String ten, String mssv, String lop, int hinhAnh) {
        this.ten = ten;
        this.mssv = mssv;
        this.lop = lop;
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public String getMssv() {
        return mssv;
    }

    public String getLop() {
        return lop;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }
}

