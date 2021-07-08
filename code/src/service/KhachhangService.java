package service;

import model.Khachhang;

import java.util.List;

public interface KhachhangService {
    List<Khachhang> finAll();
    void  save(Khachhang khachhang);
    List<Khachhang>  finByName(String name);
    Khachhang update(String id,  Khachhang khachhang);
    void remove(String id);
    Khachhang finById1(String id);
}
