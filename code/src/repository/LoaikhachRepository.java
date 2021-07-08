package repository;

import model.Khachhang;
import model.Loaikhach;

import java.util.List;

public interface LoaikhachRepository {
    List<Loaikhach> finAll();
    void  save(Loaikhach loaikhach);
    List<Loaikhach>  finByName(String name);
    Loaikhach update(String id,  Loaikhach loaikhach) ;
    void remove(String id);
    Loaikhach finById1(String id);
}
