package model;

public class Loaikhach {
    private String id_loaikhach;
    private String ten_loaikhach;
    public Loaikhach(){}
    public Loaikhach(String id_loaikhach, String ten_loaikhach) {
        this.id_loaikhach = id_loaikhach;
        this.ten_loaikhach = ten_loaikhach;
    }
    public Loaikhach(String id_loaikhach) {
        this.id_loaikhach = id_loaikhach;
    }

    public String getId_loaikhach() {
        return id_loaikhach;
    }

    public void setId_loaikhach(String id_loaikhach) {
        this.id_loaikhach = id_loaikhach;
    }

    public String getTen_loaikhach() {
        return ten_loaikhach;
    }
    public void setTen_loaikhach(String ten_loaikhach) {
        this.ten_loaikhach = ten_loaikhach;
    }
}
