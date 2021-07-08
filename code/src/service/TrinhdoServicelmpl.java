package service;

import model.Trinhdo;
import repository.TrinhdoRepository;
import repository.TrinhdoRepositorylmpl;

import java.util.List;

public class TrinhdoServicelmpl implements  TrinhdoService {
    private TrinhdoRepository trinhdoRepository = new TrinhdoRepositorylmpl();
    @Override
    public List<Trinhdo> finAll() {
        return trinhdoRepository.finAll();
    }

    @Override
    public void save(Trinhdo trinhdo) {
        trinhdoRepository.save(trinhdo);

    }

    @Override
    public List<Trinhdo> finByName(String name) {
        return trinhdoRepository.finByName(name);
    }

    @Override
    public Trinhdo update(String id, Trinhdo trinhdo) {
        return trinhdoRepository.update(id,trinhdo);
    }

    @Override
    public void remove(String id) {
        trinhdoRepository.remove(id);

    }

    @Override
    public Trinhdo finById1(String id) {
        return trinhdoRepository.finById1(id);
    }
}
