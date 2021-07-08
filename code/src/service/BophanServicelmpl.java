package service;

import model.Bophan;
import repository.BophanRepository;
import repository.BophanRepositorylmpl;

import java.util.List;

public class BophanServicelmpl implements  BophanService {
     public BophanRepository bophanRepository = new BophanRepositorylmpl();
    @Override
    public List<Bophan> finAll() {
        return bophanRepository.finAll();
    }

    @Override
    public void save(Bophan bophan) {
        bophanRepository.save(bophan);

    }

    @Override
    public List<Bophan> finByName(String name) {
        return bophanRepository.finByName(name);
    }

    @Override
    public Bophan update(String id, Bophan bophan) {

        return bophanRepository.update(id, bophan);
    }

    @Override
    public void remove(String id) {
        bophanRepository.remove(id);

    }

    @Override
    public Bophan finById1(String id) {

        return bophanRepository.finById1(id);
    }
}
