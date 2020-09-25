package com.example.thuongky;

public class SinhVien {
    private int productID;
    private String ten;
    private String sdt;
    private String diachi;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public SinhVien() {
    }

    public SinhVien(int productID, String ten, String sdt, String diachi) {
        this.productID = productID;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "productID=" + productID +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
