package model;

import java.util.Date;

public class Khachhang {
    private String id_khachhang;
    private String ten_khachhang;
    private String ngaysinh;
    private String gioitinh;
    private  int socmnd;
    private  int sdt;
    private String email;
    private Loaikhach loaikhach;
    private Diachi diachi;

    public Khachhang(String id_khachhang, String ten_khachhang, String ngaysinh, String gioitinh, int socmnd, int sdt, String email, Loaikhach loaikhach, Diachi diachi) {
        this.id_khachhang = id_khachhang;
        this.ten_khachhang = ten_khachhang;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.socmnd = socmnd;
        this.sdt = sdt;
        this.email = email;
        this.loaikhach = loaikhach;
        this.diachi = diachi;
    }
    public Khachhang(String id_khachhang)
    {
        this.id_khachhang = id_khachhang;
    }

    public Khachhang(String ten_khachhang, String ngaysinh, String gioitinh, int socmnd, int sdt, String email, Loaikhach loaikhach, Diachi diachi) {
    }

    public Khachhang(String id_khachhang, String ten_khachhang) {
        this.id_khachhang = id_khachhang;
        this.ten_khachhang = ten_khachhang;

    }

    public String getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(String id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getTen_khachhang() {
        return ten_khachhang;
    }

    public void setTen_khachhang(String ten_khachhang) {
        this.ten_khachhang = ten_khachhang;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getSocmnd() {
        return socmnd;
    }

    public void setSocmnd(int socmnd) {
        this.socmnd = socmnd;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Loaikhach getLoaikhach() {
        return loaikhach;
    }

    public void setLoaikhach(Loaikhach loaikhach) {
        this.loaikhach = loaikhach;
    }

    public Diachi getDiachi() {
        return diachi;
    }

    public void setDiachi(Diachi diachi) {
        this.diachi = diachi;
    }
}
