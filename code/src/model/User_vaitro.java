package model;

public class  User_vaitro {
    private  String vaitro_id;
    private  User ten_user;

    public User_vaitro(String vaitro_id, User ten_user) {
        this.vaitro_id = vaitro_id;
        this.ten_user = ten_user;
    }

    public User_vaitro(String ten_user) {

    }

    public String getVaitro_id() {
        return vaitro_id;
    }

    public void setVaitro_id(String vaitro_id) {
        this.vaitro_id = vaitro_id;
    }

    public User getTen_user() {
        return ten_user;
    }

    public void setTen_user(User ten_user) {
        this.ten_user = ten_user;
    }
}
