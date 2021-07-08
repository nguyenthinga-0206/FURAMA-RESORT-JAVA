package service;

import model.Khachhang;
import repository.KhachhangRepository;
import repository.KhachhangRepositorylmpl;

import java.util.List;

public class KhachhangServicelpml implements  KhachhangService {
    private   KhachhangRepository khachhangRepository = new KhachhangRepositorylmpl();
    @Override
    public List<Khachhang> finAll()
    {
        return khachhangRepository.finAll();
    }

    @Override
    public void save(Khachhang khachhang) {
        khachhangRepository.save(khachhang);

    }

    @Override
    public List<Khachhang> finByName(String name) {
        return khachhangRepository.finByName(name);
    }

    @Override
    public Khachhang update(String id, Khachhang khachhang)
    {
        return khachhangRepository.update(id,khachhang);
    }

    @Override
    public void remove(String id) {
        khachhangRepository.remove(id);

    }

    @Override
    public Khachhang finById1(String id) {
        return khachhangRepository.finById1(id);
    }
}
