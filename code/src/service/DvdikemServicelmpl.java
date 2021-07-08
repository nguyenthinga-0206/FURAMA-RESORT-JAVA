package service;

import model.Dvdikem;
import repository.DvdikemRepository;
import repository.DvdikemRepositorylmpl;

import java.util.List;

public class DvdikemServicelmpl implements DvdikemService {
    public DvdikemRepository dvdikemRepository = new DvdikemRepositorylmpl();
    @Override
    public List<Dvdikem> finAll() {
        return dvdikemRepository.finAll();
    }

    @Override
    public void save(Dvdikem dvdikem) {
        dvdikemRepository.save(dvdikem);
    }

    @Override
    public List<Dvdikem> finByName(String name) {
        return dvdikemRepository.finByName(name);
    }

    @Override
    public Dvdikem update(String id, Dvdikem dvdikem) {
        return dvdikemRepository.update(id,dvdikem);
    }

    @Override
    public void remove(String id) {
        dvdikemRepository.remove(id);
    }
    @Override
    public Dvdikem finById1(String id) {
        return dvdikemRepository.finById1(id);
    }
}
