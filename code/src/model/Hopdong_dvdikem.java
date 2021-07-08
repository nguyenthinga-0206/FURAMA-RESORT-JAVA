package model;

public class Hopdong_dvdikem {
    private Dvdikem dvdikem;
    private Hopdong hopdong;
    private  int soluong;

    public Hopdong_dvdikem(Dvdikem dvdikem, Hopdong hopdong, int soluong) {
        this.dvdikem = dvdikem;
        this.hopdong = hopdong;
        this.soluong = soluong;
    }

    public Dvdikem getDvdikem() {
        return dvdikem;
    }

    public void setDvdikem(Dvdikem dvdikem) {
        this.dvdikem = dvdikem;
    }

    public Hopdong getHopdong() {
        return hopdong;
    }

    public void setHopdong(Hopdong hopdong) {
        this.hopdong = hopdong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
