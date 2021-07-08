package model;

public class House {
    private  String id_house;
    private String ten_house;
    private String tieuchuanphong;
    private String mota;
    private int sotang;
    private  Dichvu dichvu;

    public House(String id_house, String ten_house, String tieuchuanphong, String mota, int sotang, Dichvu dichvu) {
        this.id_house = id_house;
        this.ten_house = ten_house;
        this.tieuchuanphong = tieuchuanphong;
        this.mota = mota;
        this.sotang = sotang;
        this.dichvu = dichvu;
    }

    public String getId_house() {
        return id_house;
    }

    public void setId_house(String id_house) {
        this.id_house = id_house;
    }

    public String getTen_house() {
        return ten_house;
    }

    public void setTen_house(String ten_house) {
        this.ten_house = ten_house;
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
