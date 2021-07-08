package model;

public class Trinhdo {
     private  String id_trinhdo;
     private String ten_trinhdo;

    public Trinhdo(String id_trinhdo, String ten_trinhdo) {
        this.id_trinhdo = id_trinhdo;
        this.ten_trinhdo = ten_trinhdo;
    }
    public Trinhdo(String id_trinhdo) {

        this.id_trinhdo = id_trinhdo;
    }

    public String getId_trinhdo() {
        return id_trinhdo;
    }

    public void setId_trinhdo(String id_trinhdo) {
        this.id_trinhdo = id_trinhdo;
    }

    public String getTen_trinhdo() {
        return ten_trinhdo;
    }

    public void setTen_trinhdo(String ten_trinhdo) {
        this.ten_trinhdo = ten_trinhdo;
    }
}
