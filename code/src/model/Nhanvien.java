package model;

import java.util.Date;

public class Nhanvien {
    private String id_nhanvien;
    private  String ten_nhanvien;
    private String ngaysinh;
    private int socmnd;
    private int sdt;
    private String email;
    private Trinhdo trinhdo;
    private Vitri vitri;
    private  Bophan bophan;
    private  float luong;
    private Diachi diachi;
    private  User user;

    public Nhanvien(String id_nhanvien, String ten_nhanvien, String ngaysinh, int socmnd, int sdt, String email, Trinhdo trinhdo, Vitri vitri, Bophan bophan, float luong, Diachi diachi, User user) {
        this.id_nhanvien = id_nhanvien;
        this.ten_nhanvien = ten_nhanvien;
        this.ngaysinh = ngaysinh;
        this.socmnd = socmnd;
        this.sdt = sdt;
        this.email = email;
        this.trinhdo = trinhdo;
        this.vitri = vitri;
        this.bophan = bophan;
        this.luong = luong;
        this.diachi = diachi;
        this.user = user;
    }

    public Nhanvien(String id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public Nhanvien(String id_nhanvien, String ten_nhanvien) {
        this.id_nhanvien = id_nhanvien;
        this.ten_nhanvien = ten_nhanvien;
    }


    public String getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(String id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public String getTen_nhanvien() {
        return ten_nhanvien;
    }

    public void setTen_nhanvien(String ten_nhanvien) {
        this.ten_nhanvien = ten_nhanvien;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
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

    public Trinhdo getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(Trinhdo trinhdo) {
        this.trinhdo = trinhdo;
    }

    public Vitri getVitri() {
        return vitri;
    }

    public void setVitri(Vitri vitri) {
        this.vitri = vitri;
    }

    public Bophan getBophan() {
        return bophan;
    }

    public void setBophan(Bophan bophan) {
        this.bophan = bophan;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public Diachi getDiachi() {
        return diachi;
    }

    public void setDiachi(Diachi diachi) {
        this.diachi = diachi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
