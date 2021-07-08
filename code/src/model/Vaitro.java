package model;

public class Vaitro {
    private  String vaitro_id;
    private  String ten_vaitro;

    public Vaitro(String vaitro_id, String ten_vaitro) {
        this.vaitro_id = vaitro_id;
        this.ten_vaitro = ten_vaitro;
    }

    public String getVaitro_id() {
        return vaitro_id;
    }

    public void setVaitro_id(String vaitro_id) {
        this.vaitro_id = vaitro_id;
    }

    public String getTen_vaitro() {
        return ten_vaitro;
    }

    public void setTen_vaitro(String ten_vaitro) {
        this.ten_vaitro = ten_vaitro;
    }
}
