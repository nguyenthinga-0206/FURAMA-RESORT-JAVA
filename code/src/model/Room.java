package model;

public class Room {
    private  String id_room;
    private String ten_rooom;
    private String tendichvufreedikem;
    private  Dichvu dichvu;

    public Room(String id_room, String ten_rooom, String tendichvufreedikem, Dichvu dichvu) {
        this.id_room = id_room;
        this.ten_rooom = ten_rooom;
        this.tendichvufreedikem = tendichvufreedikem;
        this.dichvu = dichvu;
    }

    public String getId_room() {
        return id_room;
    }

    public void setId_room(String id_room) {
        this.id_room = id_room;
    }

    public String getTen_rooom() {
        return ten_rooom;
    }

    public void setTen_rooom(String ten_rooom) {
        this.ten_rooom = ten_rooom;
    }

    public String getTendichvufreedikem() {
        return tendichvufreedikem;
    }

    public void setTendichvufreedikem(String tendichvufreedikem) {
        this.tendichvufreedikem = tendichvufreedikem;
    }

    public Dichvu getDichvu() {
        return dichvu;
    }

    public void setDichvu(Dichvu dichvu) {
        this.dichvu = dichvu;
    }
}
