package repository;

import model.Dvdikem;

import java.util.List;

public interface DvdikemRepository {
    List<Dvdikem> finAll();
    void  save(Dvdikem dvdikem);
    List<Dvdikem>  finByName(String name);
    Dvdikem update(String id,Dvdikem dvdikem);
    void remove(String id);
    Dvdikem finById1(String id);
}
