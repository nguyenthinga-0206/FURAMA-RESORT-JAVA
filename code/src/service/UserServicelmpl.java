package service;

import model.User;
import repository.UserReposetory;
import repository.UserReposetorylmpl;

import java.util.List;

public class UserServicelmpl implements UserService {
    private UserReposetory userReposetory = new UserReposetorylmpl();
    @Override
    public List<User> finAll() {
        return userReposetory.finAll();
    }

    @Override
    public void save(User user) {
        userReposetory.save(user);
    }

    @Override
    public boolean finByName(String name, String mk) {
        return userReposetory.finByName(name,mk);
    }

//    @Override
//    boolean finByName(String name,String mk) {
//        return userReposetory.finByName(name,mk);
//    }

    @Override
    public User update(String id, User user) {
        return userReposetory.update(id,user);
    }

    @Override
    public void remove(String id) {
        userReposetory.remove(id);

    }

    @Override
    public  List<User> finById1(String id) {
        return userReposetory.finById1(id);
    }
}
