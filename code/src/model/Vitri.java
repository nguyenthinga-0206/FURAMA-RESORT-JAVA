package model;

public class Vitri {
    private  String id_vitri;
    private String ten_vitri;

    public Vitri(String id_vitri, String ten_vitri) {
        this.id_vitri = id_vitri;
        this.ten_vitri = ten_vitri;
    }

    public Vitri(String  id_vitri) {
        this.id_vitri = id_vitri;

    }

    public String getId_vitri() {
        return id_vitri;
    }

    public void setId_vitri(String id_vitri) {
        this.id_vitri = id_vitri;
    }

    public String getTen_vitri() {
        return ten_vitri;
    }

    public void setTen_vitri(String ten_vitri) {
        this.ten_vitri = ten_vitri;
    }
}
