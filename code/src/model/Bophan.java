package model;

public class Bophan {
    private String id_bophan;
    private  String ten_bophan;
    public Bophan(String id_bophan, String ten_bophan) {
        this.id_bophan = id_bophan;
        this.ten_bophan = ten_bophan;
    }
//    public Bophan(String ten_bophan) {
//        this.ten_bophan = ten_bophan;
//    }
    public Bophan(String id_bophan) {
        this.id_bophan = id_bophan;
    }
    public String getId_bophan() {
        return id_bophan;
    }

    public void setId_bophan(String id_bophan) {
        this.id_bophan = id_bophan;
    }

    public String getTen_bophan() {
        return ten_bophan;
    }

    public void setTen_bophan(String ten_bophan) {
        this.ten_bophan = ten_bophan;
    }
}
