package service;

import model.User_vaitro;
import repository.Vaitro_usrerRepository;
import repository.Vaitro_usrerRepositorylmpl;

import java.util.List;

public class Vaitro_usrerServicelmpl implements Vaitro_usrerService {
    private Vaitro_usrerRepository vaitro_usrerRepository = new Vaitro_usrerRepositorylmpl();
    @Override
    public List<User_vaitro> finAll() {
        return vaitro_usrerRepository.finAll();
    }

    @Override
    public void save(User_vaitro user_vaitro) {
        vaitro_usrerRepository.save(user_vaitro);

    }

    @Override
    public boolean finByName(String vaitro, String ten) {
        return vaitro_usrerRepository.finByName(vaitro,ten);
    }

    @Override
    public User_vaitro update(String vaitro, User_vaitro user_vaitro) {
        return vaitro_usrerRepository.update(vaitro,user_vaitro);
    }

    @Override
    public void remove(String id) {
        vaitro_usrerRepository.remove(id);

    }

    @Override
    public List<User_vaitro> finById(String vaitro) {
        return vaitro_usrerRepository.finById(vaitro);
    }

    @Override
    public boolean finBygiamdoc(String ten_user) {
        return vaitro_usrerRepository.finBygiamdoc(ten_user);
    }

    @Override
    public boolean finBynv(String ten_user) {

        return vaitro_usrerRepository.finBynv(ten_user);
    }

    @Override
    public boolean finBykh(String ten_user)
    {
        return vaitro_usrerRepository.finBykh(ten_user);
    }

    @Override
    public boolean finBydv(String ten_user)
    {
        return vaitro_usrerRepository.finBydv(ten_user);
    }

    @Override
    public boolean finByhd(String ten_user) {

        return vaitro_usrerRepository.finByhd(ten_user);
    }

    @Override
    public boolean finByXem(String ten_user) {
        return vaitro_usrerRepository.finByXem(ten_user);
    }
}
