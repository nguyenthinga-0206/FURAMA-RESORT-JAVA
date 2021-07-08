package repository;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanvienRepositorylmpl implements NhanvienRepository {
    public static  final  String SELECT_NHANVIEN ="select nhanvien.id_nhanvien, ten_nhanvien,ngaysinh,socmnd,sdt,email,trinhdo.ten_trinhdo,vitri.ten_vitri, bophan.ten_bophan,luong,diachi.id_diachi,trinhdo.id_trinhdo,bophan.id_bophan,vitri.id_vitri ,user.ten_user from nhanvien\n" +
            "inner join diachi  on diachi.id_diachi = nhanvien.id_diachi\n" +
            "inner join trinhdo on trinhdo.id_trinhdo = nhanvien.id_trinhdo\n" +
            "inner join bophan on bophan.id_bophan = nhanvien.id_bophan\n" +
            "inner join vitri on vitri.id_vitri =  nhanvien.id_vitri\n" +
            "inner join user on user.ten_user = nhanvien.ten_user; ";
    public static  final  String DELETE_NHANVIEN ="delete from nhanvien where id_nhanvien =?;";
    public static  final  String UPDATE_NHANVIEN = "update nhanvien set ten_nhanvien =?, ngaysinh=?,socmnd=?,sdt=?,email=?, id_trinhdo =?,id_vitri=?, id_bophan=?,luong=?,id_diachi=?, ten_user=?  where id_nhanvien = ?;";
    public static  final  String SELECT_NHANVIEN_ID ="select nhanvien.id_nhanvien, ten_nhanvien,ngaysinh,socmnd,sdt,email,trinhdo.ten_trinhdo,vitri.ten_vitri, bophan.ten_bophan,luong,diachi.id_diachi,trinhdo.id_trinhdo,bophan.id_bophan,vitri.id_vitri ,user.ten_user from nhanvien\n" +
            "inner join diachi  on diachi.id_diachi = nhanvien.id_diachi\n" +
            "inner join trinhdo on trinhdo.id_trinhdo = nhanvien.id_trinhdo\n" +
            "inner join bophan on bophan.id_bophan = nhanvien.id_bophan\n" +
            "inner join vitri on vitri.id_vitri =  nhanvien.id_vitri\n" +
            "inner join user on user.ten_user = nhanvien.ten_user where id_nhanvien =? ;";
    public static  final  String SELECT_NHANVIEN_NAME ="select nhanvien.id_nhanvien, ten_nhanvien,ngaysinh,socmnd,sdt,email,trinhdo.ten_trinhdo,vitri.ten_vitri, bophan.ten_bophan,luong,diachi.id_diachi,trinhdo.id_trinhdo,bophan.id_bophan,vitri.id_vitri ,user.ten_user from nhanvien\n" +
            "inner join diachi  on diachi.id_diachi = nhanvien.id_diachi\n" +
            "inner join trinhdo on trinhdo.id_trinhdo = nhanvien.id_trinhdo\n" +
            "inner join bophan on bophan.id_bophan = nhanvien.id_bophan\n" +
            "inner join vitri on vitri.id_vitri =  nhanvien.id_vitri\n" +
            "inner join user on user.ten_user = nhanvien.ten_user where ten_nhanvien =? ;";
    public static  final  String INSERT_NHANVIEN =  "insert into nhanvien (id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email,id_trinhdo,id_vitri,id_bophan,luong,id_diachi,ten_user) value (?,?,?,?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Nhanvien> finAll() {
        List<Nhanvien> nhanvienList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_NHANVIEN);
                resultSet = statement.executeQuery();
                Nhanvien nhanvien = null;
                while (resultSet.next())
                {
                    String id_nhanvien = resultSet.getString("id_nhanvien");
                    String ten_nhanvien = resultSet.getString("ten_nhanvien");
                    String ngaysinh = resultSet.getString("ngaysinh");
                    int socmnd = resultSet.getInt("socmnd");
                    int sdt = resultSet.getInt("sdt");
                    String email = resultSet.getString("email");
                    String ten_trinhdo = resultSet.getString("ten_trinhdo");
                    String ten_vitri = resultSet.getString("ten_vitri");
                    String ten_bophan = resultSet.getString("ten_bophan");
                    float luong =Float.parseFloat(resultSet.getString("luong"));
                    String id_diachi = resultSet.getString("id_diachi");
                    String id_trinhdo = resultSet.getString("id_trinhdo");
                    String id_bophan = resultSet.getString("id_bophan");
                    String id_vitri = resultSet.getString("id_vitri");
                    String ten_user = resultSet.getString("ten_user");
                    nhanvien = new Nhanvien(id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email, new Trinhdo(id_trinhdo,ten_trinhdo),new Vitri(id_vitri,ten_vitri), new Bophan(id_bophan,ten_bophan), luong,new Diachi(id_diachi), new User(ten_user));
                    nhanvienList.add(nhanvien);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return  nhanvienList;
    }

    @Override
    public void save(Nhanvien nhanvien) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try
            {
                statement = connection.prepareStatement(INSERT_NHANVIEN);
                statement.setString(1,nhanvien.getId_nhanvien());
                statement.setString(2,nhanvien.getTen_nhanvien());
                statement.setString(3,nhanvien.getNgaysinh());
                statement.setInt(4,nhanvien.getSocmnd());
                statement.setInt(5,nhanvien.getSdt());
                statement.setString(6,nhanvien.getEmail());
                statement.setString(7,nhanvien.getTrinhdo().getId_trinhdo());
                statement.setString(8,nhanvien.getVitri().getId_vitri());
                statement.setString(9,nhanvien.getBophan().getId_bophan());
                statement.setFloat(10,nhanvien.getLuong());
                statement.setString(11,nhanvien.getDiachi().getId_diachi());
                statement.setString(12,nhanvien.getUser().getTen_user());
                System.out.println("nhan vien them:" + statement);
                statement.executeUpdate();
                System.out.println("nhan vien them:" + statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Nhanvien> finByName(String name) {
        List<Nhanvien> nhanvienList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_NHANVIEN_NAME);
                statement.setString(1,name);
                resultSet = statement.executeQuery();
                System.out.println("SQL1" + statement);
                Nhanvien nhanvien = null;
                while (resultSet.next())
                {
                    String id_nhanvien = resultSet.getString("id_nhanvien");
                    String ten_nhanvien = resultSet.getString("ten_nhanvien");
                    String ngaysinh = resultSet.getString("ngaysinh");
                    int socmnd = resultSet.getInt("socmnd");
                    int sdt = resultSet.getInt("sdt");
                    String email = resultSet.getString("email");
                    String ten_trinhdo = resultSet.getString("ten_trinhdo");
                    String ten_vitri = resultSet.getString("ten_vitri");
                    String ten_bophan = resultSet.getString("ten_bophan");
                    float luong =Float.parseFloat(resultSet.getString("luong"));
                    String id_diachi = resultSet.getString("id_diachi");
                    String id_trinhdo = resultSet.getString("id_trinhdo");
                    String id_bophan = resultSet.getString("id_bophan");
                    String id_vitri = resultSet.getString("id_vitri");
                    String ten_user = resultSet.getString("ten_user");
                    nhanvien = new Nhanvien(id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email, new Trinhdo(id_trinhdo,ten_trinhdo),new Vitri(id_vitri,ten_vitri), new Bophan(id_bophan,ten_bophan), luong,new Diachi(id_diachi), new User(ten_user));
                    System.out.println("nhan tìm kiếm được là: " + nhanvien);
                    nhanvienList.add(nhanvien);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return nhanvienList;
    }

    @Override
    public Nhanvien update(String id, Nhanvien nhanvien) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try
            {
                statement = connection.prepareStatement(UPDATE_NHANVIEN);
                statement.setString(1,nhanvien.getTen_nhanvien());
                statement.setString(2,nhanvien.getNgaysinh());
                statement.setInt(3,nhanvien.getSocmnd());
                statement.setInt(4,nhanvien.getSdt());
                statement.setString(5,nhanvien.getEmail());
                statement.setString(6,nhanvien.getTrinhdo().getId_trinhdo());
                statement.setString(7,nhanvien.getVitri().getId_vitri());
                statement.setString(8,nhanvien.getBophan().getId_bophan());
                statement.setFloat(9,nhanvien.getLuong());
                statement.setString(10,nhanvien.getDiachi().getId_diachi());
                statement.setString(11,nhanvien.getUser().getTen_user());
                statement.setString(12,nhanvien.getId_nhanvien());
                statement.executeUpdate();
                System.out.println("nhan vien edit:" + statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return nhanvien;
    }


    @Override
    public void remove(String id) {
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(DELETE_NHANVIEN );
                statement.setString(1,id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }  finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }
    @Override
    public Nhanvien finById1(String id) {
        Nhanvien nhanvien = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_NHANVIEN_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String id_nhanvien = resultSet.getString("id_nhanvien");
                    String ten_nhanvien = resultSet.getString("ten_nhanvien");
                    String ngaysinh = resultSet.getString("ngaysinh");
                    int socmnd = resultSet.getInt("socmnd");
                    int sdt = resultSet.getInt("sdt");
                    String email = resultSet.getString("email");
                    String ten_trinhdo = resultSet.getString("ten_trinhdo");
                    String ten_vitri = resultSet.getString("ten_vitri");
                    String ten_bophan = resultSet.getString("ten_bophan");
                    float luong = Float.parseFloat(resultSet.getString("luong"));
                    String id_diachi = resultSet.getString("id_diachi");
                    String id_trinhdo = resultSet.getString("id_trinhdo");
                    String id_bophan = resultSet.getString("id_bophan");
                    String id_vitri = resultSet.getString("id_vitri");
                    String ten_user = resultSet.getString("ten_user");
                    nhanvien = new Nhanvien(id_nhanvien, ten_nhanvien, ngaysinh, socmnd, sdt, email, new Trinhdo(id_trinhdo, ten_trinhdo), new Vitri(id_vitri, ten_vitri), new Bophan(id_bophan, ten_bophan), luong, new Diachi(id_diachi), new User(ten_user));
                    System.out.println("nhan vien them id la: " + nhanvien);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return nhanvien;
    }
}
