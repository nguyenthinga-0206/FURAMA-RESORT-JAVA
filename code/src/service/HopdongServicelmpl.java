package service;

import model.Hopdong;
import repository.HopdongRepository;
import repository.HopdongRepositorylmpl;

import java.util.List;

public class HopdongServicelmpl implements HopdongService {
    public HopdongRepository hopdongRepository = new HopdongRepositorylmpl();
    @Override
    public List<Hopdong> finAll() {
        return  hopdongRepository.finAll();
    }

    @Override
    public void save(Hopdong hopdong) {
        hopdongRepository.save(hopdong);
    }

    @Override
    public List<Hopdong> finByName(String name) {
        return  hopdongRepository.finByName(name);
    }

    @Override
    public Hopdong update(String id, Hopdong hopdong) {
        return  hopdongRepository.update(id,hopdong);
    }

    @Override
    public void remove(String id) {
        hopdongRepository.remove(id);

    }
    @Override
    public Hopdong finById1(String id) {

        return hopdongRepository.finById1(id);
    }
}
