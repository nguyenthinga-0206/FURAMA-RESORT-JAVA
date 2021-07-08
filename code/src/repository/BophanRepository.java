package repository;

import model.Bophan;
import model.Diachi;

import java.util.List;

public interface BophanRepository {
    List<Bophan> finAll();
    void  save(Bophan bophan);
    List<Bophan>  finByName(String name);
    Bophan update(String id,  Bophan bophan);
    void remove(String id);
    Bophan finById1(String id);
}
