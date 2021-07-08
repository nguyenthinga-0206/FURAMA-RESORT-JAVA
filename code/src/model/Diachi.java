package model;


public class Diachi {
    private  String id_diachi;
    private String sonha;
    private String xa;
    private String huyen;
    private String tinh;
    private String quocgia;

    public Diachi(String id_diachi, String sonha, String xa, String huyen, String tinh, String quocgia) {
        this.id_diachi = id_diachi;
        this.sonha = sonha;
        this.xa = xa;
        this.huyen = huyen;
        this.tinh = tinh;
        this.quocgia = quocgia;
    }
//    public Diachi( String sonha, String xa, String huyen, String tinh, String quocgia) {
//        this.sonha = sonha;
//        this.xa = xa;
//        this.huyen = huyen;
//        this.tinh = tinh;
//        this.quocgia = quocgia;
//    }
    public Diachi(String id_diachi)
    {
        this.id_diachi = id_diachi;
    }

    public String getId_diachi() {
        return id_diachi;
    }

    public void setId_diachi(String id_diachi) {
        this.id_diachi = id_diachi;
    }

    public String getSonha() {
        return sonha;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }
}
