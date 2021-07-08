package model;

public class Dichvu {
    private String id_dichvu;
    private String ten_dichvu;
    private float dientich;
    private float chiphi;
    private String songuoi;
    private Kieuthue kieuthue;

    public Dichvu(String id_dichvu, String ten_dichvu, float dientich, float chiphi, String songuoi, Kieuthue kieuthue) {
        this.id_dichvu = id_dichvu;
        this.ten_dichvu = ten_dichvu;
        this.dientich = dientich;
        this.chiphi = chiphi;
        this.songuoi = songuoi;
        this.kieuthue = kieuthue;
    }
    public Dichvu(String id_dichvu)
    {
        this.id_dichvu = id_dichvu;
    }

    public Dichvu(String id_dichvu, String ten_dichvu) {
        this.id_dichvu = id_dichvu;
        this.ten_dichvu = ten_dichvu;
    }

    public String getId_dichvu() {
        return id_dichvu;
    }

    public void setId_dichvu(String id_dichvu) {
        this.id_dichvu = id_dichvu;
    }

    public String getTen_dichvu() {
        return ten_dichvu;
    }

    public void setTen_dichvu(String ten_dichvu) {
        this.ten_dichvu = ten_dichvu;
    }

    public float getDientich() {
        return dientich;
    }

    public void setDientich(float dientich) {
        this.dientich = dientich;
    }

    public float getChiphi() {
        return chiphi;
    }

    public void setChiphi(float chiphi) {
        this.chiphi = chiphi;
    }

    public String getSonguoi() {
        return songuoi;
    }

    public void setSonguoi(String songuoi) {
        this.songuoi = songuoi;
    }

    public Kieuthue getKieuthue() {
        return kieuthue;
    }
    public String gettenKieuthue() {
        return kieuthue.getTen_kieuthue();
    }

    public void setKieuthue(Kieuthue kieuthue) {
        this.kieuthue = kieuthue;
    }
}
