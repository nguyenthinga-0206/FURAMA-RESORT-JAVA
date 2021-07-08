package service;

import model.Diachi;
import model.Kieuthue;

import java.util.List;

public interface KieuthuService {
    List<Kieuthue> finAll();
    void  save(Kieuthue kieuthue);
    List<Kieuthue>  finByName(String name);
    Kieuthue update(String id,  Kieuthue kieuthue);
    void remove(String id);
    Kieuthue finById1(String id);
}
