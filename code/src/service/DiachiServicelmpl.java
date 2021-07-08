package service;

import model.Diachi;
import repository.DiachiRepositpry;
import repository.DiachiRepositprylmpl;

import java.util.List;

public class DiachiServicelmpl  implements  DiachiService{
    private DiachiRepositpry diachiRepositpry = new DiachiRepositprylmpl();
    @Override
    public List<Diachi> finAll() {
        return diachiRepositpry.finAll();
    }

    @Override
    public void save(Diachi diachi) {
        diachiRepositpry.save(diachi);

    }

    @Override
    public List<Diachi> finByName(String name) {
        return diachiRepositpry.finByName(name);
    }

    @Override
    public Diachi update(String id, Diachi diachi) {
        return diachiRepositpry.update(id,diachi);
    }

    @Override
    public void remove(String id) {
        diachiRepositpry.remove(id);

    }
    @Override
    public Diachi finById1(String id) {
        return diachiRepositpry.finById1(id);
    }
}
