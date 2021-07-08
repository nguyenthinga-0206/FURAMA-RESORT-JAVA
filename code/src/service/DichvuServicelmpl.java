package service;

import model.Dichvu;
import repository.DichvuRepository;
import repository.DichvuRepositorylmpl;

import java.util.List;

public class DichvuServicelmpl implements DichvuService {
    private DichvuRepository dichvuRepository = new DichvuRepositorylmpl();
    @Override
    public List<Dichvu> finAll() {
        return dichvuRepository.finAll();
    }

    @Override
    public void save(Dichvu dichvu) {
        dichvuRepository.save(dichvu);

    }
    @Override
    public List<Dichvu> finByName(String name) {
        return dichvuRepository.finByName(name);
    }

    @Override
    public Dichvu update(String id, Dichvu dichvu) {
        return dichvuRepository.update(id,dichvu);
    }

    @Override
    public void remove(String id) {
        dichvuRepository.remove(id);

    }

    @Override
    public Dichvu finById1(String id) {
        return dichvuRepository.finById1(id);
    }
}
