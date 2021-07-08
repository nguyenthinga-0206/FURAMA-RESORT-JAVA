package service;

import model.Trinhdo;

import java.util.List;

public interface TrinhdoService {
    List<Trinhdo> finAll();
    void  save(Trinhdo trinhdo);
    List<Trinhdo>  finByName(String name);
    Trinhdo update(String id,  Trinhdo trinhdo);
    void remove(String id);
    Trinhdo finById1(String id);
}
