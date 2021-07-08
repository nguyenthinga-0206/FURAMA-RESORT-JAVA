package service;

import model.Vitri;
import repository.VitriRepository;
import repository.VitriRepositorylmpl;

import java.util.List;

public class VitriServicelmpl  implements VitriService{
    public VitriRepository vitriRepository = new VitriRepositorylmpl();
    @Override
    public List<Vitri> finAll() {
        return vitriRepository.finAll();
    }
    @Override
    public void save(Vitri vitri) {
        vitriRepository.save(vitri);
    }

    @Override
    public List<Vitri> finByName(String name) {
        return vitriRepository.finByName(name);
    }

    @Override
    public Vitri update(String id, Vitri vitri) {
        return vitriRepository.update(id,vitri);
    }

    @Override
    public void remove(String id) {
        vitriRepository.remove(id);
    }

    @Override
    public Vitri finById1(String id) {
        return vitriRepository.finById1(id);
    }
}
