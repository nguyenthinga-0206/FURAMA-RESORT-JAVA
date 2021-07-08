package model;

import java.util.Date;

public class Hopdong {
    private String id_hopdong;
    private String ngaybatdau;
    private String ngayketthuc;
    private float sotiendatco;
    private float tongsotienthanhtoan;
    private Nhanvien nhanvien;
    private Khachhang khachhang;
    private Dichvu dichvu;

    public Hopdong(String id_hopdong, String ngaybatdau, String ngayketthuc, float sotiendatco, float tongsotienthanhtoan, Nhanvien nhanvien, Khachhang khachhang, Dichvu dichvu) {
        this.id_hopdong = id_hopdong;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.sotiendatco = sotiendatco;
        this.tongsotienthanhtoan = tongsotienthanhtoan;
        this.nhanvien = nhanvien;
        this.khachhang = khachhang;
        this.dichvu = dichvu;
    }

    public String getId_hopdong() {
        return id_hopdong;
    }

    public void setId_hopdong(String id_hopdong) {
        this.id_hopdong = id_hopdong;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public float getSotiendatco() {
        return sotiendatco;
    }

    public void setSotiendatco(float sotiendatco) {
        this.sotiendatco = sotiendatco;
    }

    public float getTongsotienthanhtoan() {
        return tongsotienthanhtoan;
    }

    public void setTongsotienthanhtoan(float tongsotienthanhtoan) {
        this.tongsotienthanhtoan = tongsotienthanhtoan;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public Dichvu getDichvu() {
        return dichvu;
    }

    public void setDichvu(Dichvu dichvu) {
        this.dichvu = dichvu;
    }
}
