package model;

public class Villa {
    private  String id_villa;
    private String ten_villa;
    private String tieuchuanphong;
    private String mota;
    private  float dientichhoboi;
    private int sotang;
    private  Dichvu dichvu;

    public Villa(String id_villa, String ten_villa, String tieuchuanphong, String mota, float dientichhoboi, int sotang, Dichvu dichvu) {
        this.id_villa = id_villa;
        this.ten_villa = ten_villa;
        this.tieuchuanphong = tieuchuanphong;
        this.mota = mota;
        this.dientichhoboi = dientichhoboi;
        this.sotang = sotang;
        this.dichvu = dichvu;
    }

    public String getId_villa() {
        return id_villa;
    }

    public void setId_villa(String id_villa) {
        this.id_villa = id_villa;
    }

    public String getTen_villa() {
        return ten_villa;
    }

    public void setTen_villa(String ten_villa) {
        this.ten_villa = ten_villa;
    }

    public String getTieuchuanphong() {
        return tieuchuanphong;
    }

    public void setTieuchuanphong(String tieuchuanphong) {
        this.tieuchuanphong = tieuchuanphong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public float getDientichhoboi() {
        return dientichhoboi;
    }

    public void setDientichhoboi(float dientichhoboi) {
        this.dientichhoboi = dientichhoboi;
    }

    public int getSotang() {
        return sotang;
    }

    public void setSotang(int sotang) {
        this.sotang = sotang;
    }

    public Dichvu getDichvu() {
        return dichvu;
    }

    public void setDichvu(Dichvu dichvu) {
        this.dichvu = dichvu;
    }
}
