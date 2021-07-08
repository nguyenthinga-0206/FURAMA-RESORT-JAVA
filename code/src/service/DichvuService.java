package service;
import model.Dichvu;

import java.util.List;

public interface DichvuService {
    List<Dichvu> finAll();
    void  save(Dichvu dichvu);
    List<Dichvu>  finByName(String name);
    Dichvu update(String id,  Dichvu dichvu);
    void remove(String id);
    Dichvu finById1(String id);
}
