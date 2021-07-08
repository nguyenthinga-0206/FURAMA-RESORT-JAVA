package service;

import model.Bophan;

import java.util.List;

public interface BophanService {
    List<Bophan> finAll();
    void  save(Bophan bophan);
    List<Bophan>  finByName(String name);
    Bophan update(String id,  Bophan bophan);
    void remove(String id);
    Bophan finById1(String id);
}
