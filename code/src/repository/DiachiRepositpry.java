package repository;

import model.Diachi;
import model.Khachhang;

import java.util.List;

public interface DiachiRepositpry {
    List<Diachi> finAll();
    void  save(Diachi diachi);
    List<Diachi>  finByName(String name);
    Diachi update(String id,  Diachi diachi);
    void remove(String id);
    Diachi finById1(String id);
}
