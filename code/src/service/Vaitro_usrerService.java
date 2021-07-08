package service;

import model.User_vaitro;

import java.util.List;

public interface Vaitro_usrerService {
    List<User_vaitro> finAll();
    void  save(User_vaitro user_vaitro);
    boolean  finByName(String vaitro,String ten);
    User_vaitro update(String vaitro,  User_vaitro user_vaitro);
    void remove(String id);
    List<User_vaitro> finById(String vaitro);
    boolean  finBygiamdoc(String ten_user);
    boolean  finBynv(String ten_user);
    boolean  finBykh(String ten_user);
    boolean  finBydv(String ten_user);
    boolean  finByhd(String ten_user);
    boolean  finByXem(String ten_user);
}
