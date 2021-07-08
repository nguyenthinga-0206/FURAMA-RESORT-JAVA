package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> finAll();
    void  save(User user);
    boolean finByName(String name,String mk);
    User update(String id,  User user);
    void remove(String id);
    List<User> finById1(String id);
}
