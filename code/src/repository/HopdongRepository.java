package repository;

import model.Hopdong;

import java.util.List;

public interface HopdongRepository {
    List<Hopdong> finAll();
    void  save(Hopdong hopdong);
    List<Hopdong>  finByName(String name);
    Hopdong update(String id,  Hopdong hopdong);
    void remove(String id);
    Hopdong finById1(String id);
}
