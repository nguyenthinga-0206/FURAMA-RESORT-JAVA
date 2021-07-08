package repository;

import model.Vitri;

import java.util.List;

public interface VitriRepository {
    List<Vitri> finAll();
    void  save(Vitri vitri);
    List<Vitri>  finByName(String name);
    Vitri update(String id,  Vitri vitri);
    void remove(String id);
    Vitri finById1(String id);
}
