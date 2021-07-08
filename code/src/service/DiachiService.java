package service;

import model.Diachi;

import java.util.List;

public interface DiachiService {
    List<Diachi> finAll();
    void  save(Diachi diachi);
    List<Diachi>  finByName(String name);
    Diachi update(String id,  Diachi diachi);
    void remove(String id);
    Diachi finById1(String id);
}
