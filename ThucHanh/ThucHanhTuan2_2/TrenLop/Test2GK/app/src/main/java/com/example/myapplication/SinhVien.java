package com.example.myapplication;

public class SinhVien {
    private String ten;
    private String diachi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public SinhVien(String ten, String diachi) {
        this.ten = ten;
        this.diachi = diachi;
    }

    public SinhVien() {
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + ten + '\'' +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
