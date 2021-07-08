package model;

public class User {
    private  String ten_user;
    private  String matkhau;

    public User(String ten_user, String matkhau) {
        this.ten_user = ten_user;
        this.matkhau = matkhau;
    }


    public User(String ten_user) {
        this.ten_user = ten_user;
    //    this.matkhau = matkhau;
    }
//    public User( String matkhaum) {
////        this.ten_user = ten_user;
//        this.matkhau = matkhau;
//    }




    public String getTen_user() {
        return ten_user;
    }

    public void setTen_user(String ten_user) {
        this.ten_user = ten_user;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
