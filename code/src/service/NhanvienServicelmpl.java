package service;

import model.Nhanvien;
import repository.NhanvienRepository;
import repository.NhanvienRepositorylmpl;

import java.util.List;

public class NhanvienServicelmpl implements NhanvienService {
    private NhanvienRepository nhanvienRepository= new NhanvienRepositorylmpl();
    @Override
    public List<Nhanvien> finAll() {
        return nhanvienRepository.finAll();
    }

    @Override
    public void save(Nhanvien nhanvien) {
        nhanvienRepository.save(nhanvien);
    }

    @Override
    public List<Nhanvien> finByName(String name) {
        return nhanvienRepository.finByName(name);
    }

    @Override
    public Nhanvien update(String id, Nhanvien nhanvien) {
        return nhanvienRepository.update(id,nhanvien);
    }

    @Override
    public void remove(String id) {
        nhanvienRepository.remove(id);

    }

    @Override
    public Nhanvien finById1(String id) {
        return nhanvienRepository.finById1(id);
    }
}
