package model;

public class Dvdikem {
    private  String id_dvdikem;
    private String ten_dvdikem;
    private String dongia;
    private  float tien;

    public Dvdikem(String id_dvdikem, String ten_dvdikem, String dongia, float tien) {
        this.id_dvdikem = id_dvdikem;
        this.ten_dvdikem = ten_dvdikem;
        this.dongia = dongia;
        this.tien = tien;
    }

    public String getId_dvdikem() {
        return id_dvdikem;
    }

    public void setId_dvdikem(String id_dvdikem) {
        this.id_dvdikem = id_dvdikem;
    }

    public String getTen_dvdikem() {
        return ten_dvdikem;
    }

    public void setTen_dvdikem(String ten_dvdikem) {
        this.ten_dvdikem = ten_dvdikem;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }
}
