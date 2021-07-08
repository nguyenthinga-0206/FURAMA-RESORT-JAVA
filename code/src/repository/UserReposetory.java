package repository;

import model.User;
import model.Vitri;

import java.util.List;

public interface UserReposetory {
    List<User> finAll();
    void  save(User user);
    boolean  finByName(String name,String mk);
    User update(String id,  User user);
    void remove(String id);
    List<User> finById1(String id);
}
