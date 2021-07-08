package service;

import model.Kieuthue;
import repository.KieuthuRepositpry;
import repository.KieuthuRepositprylmpl;

import java.util.List;

public class KieuthuServicelmpl implements KieuthuService {
    private KieuthuRepositpry kieuthuRepositpry= new KieuthuRepositprylmpl();
    @Override
    public List<Kieuthue> finAll() {
        return kieuthuRepositpry.finAll();
    }

    @Override
    public void save(Kieuthue kieuthue) {
        kieuthuRepositpry.save(kieuthue);
    }

    @Override
    public List<Kieuthue> finByName(String name) {
        return kieuthuRepositpry.finByName(name);
    }

    @Override
    public Kieuthue update(String id, Kieuthue kieuthue) {
        return kieuthuRepositpry.update(id,kieuthue);
    }

    @Override
    public void remove(String id) {
        kieuthuRepositpry.remove(id);
    }

    @Override
    public Kieuthue finById1(String id) {
        return kieuthuRepositpry.finById1(id);
    }
}
