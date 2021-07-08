package repository;

import model.Khachhang;
import model.Nhanvien;

import java.util.List;

public interface NhanvienRepository {
    List<Nhanvien> finAll();
    void  save(Nhanvien nhanvien);
    List<Nhanvien>  finByName(String name);
    Nhanvien update(String id,  Nhanvien nhanvien);
    void remove(String id);
    Nhanvien finById1(String id);

}
