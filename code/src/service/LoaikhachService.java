package service;

import model.Loaikhach;

import java.util.List;

public interface LoaikhachService {
    List<Loaikhach> finAll();
    void  save(Loaikhach loaikhach);
    List<Loaikhach>  finByName(String name);
    Loaikhach update(String id,  Loaikhach loaikhach) ;
    void remove(String id);
    Loaikhach finById1(String id);
}
