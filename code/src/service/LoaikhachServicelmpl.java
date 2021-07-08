package service;

import model.Loaikhach;
import repository.LoaikhachRepository;
import repository.LoaikhachRepositorylmpl;

import java.util.List;

public class LoaikhachServicelmpl implements LoaikhachService {
    private LoaikhachRepository loaikhachRepository = new LoaikhachRepositorylmpl();
    @Override
    public List<Loaikhach> finAll() {
        return loaikhachRepository.finAll();
    }

    @Override
    public void save(Loaikhach loaikhach) {
        loaikhachRepository.save(loaikhach);

    }

    @Override
    public List<Loaikhach> finByName(String name) {
        return loaikhachRepository.finByName(name);
    }

    @Override
    public Loaikhach update(String id, Loaikhach loaikhach) {
        return loaikhachRepository.update(id,loaikhach);
    }

    @Override
    public void remove(String id) {
        loaikhachRepository.remove(id);

    }

    @Override
    public Loaikhach finById1(String id) {
        return loaikhachRepository.finById1(id);
    }
}
