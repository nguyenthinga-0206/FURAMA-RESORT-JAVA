package model;

public class Kieuthue {
    private String id_kieuthue;
    private String ten_kieuthue;

    public Kieuthue(String id_kieuthue, String ten_kieuthue) {
        this.id_kieuthue = id_kieuthue;
        this.ten_kieuthue = ten_kieuthue;
    }

    public Kieuthue(String id_kieuthue) {
        this.id_kieuthue = id_kieuthue;
    }

    public String getId_kieuthue() {
        return id_kieuthue;
    }

    public void setId_kieuthue(String id_kieuthue) {
        this.id_kieuthue = id_kieuthue;
    }

    public String getTen_kieuthue() {
        return ten_kieuthue;
    }

    public void setTen_kieuthue(String ten_kieuthue) {
        this.ten_kieuthue = ten_kieuthue;
    }
}
