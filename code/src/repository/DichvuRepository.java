package repository;

import model.Dichvu;

import java.util.List;

public interface DichvuRepository {
    List<Dichvu> finAll();
    void  save(Dichvu dichvu);
    List<Dichvu>  finByName(String name);
    Dichvu update(String id,  Dichvu dichvu);
    void remove(String id);
    Dichvu finById1(String id);

}
