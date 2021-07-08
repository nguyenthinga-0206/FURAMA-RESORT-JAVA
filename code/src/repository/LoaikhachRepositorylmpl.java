package repository;

import model.Diachi;
import model.Khachhang;
import model.Loaikhach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoaikhachRepositorylmpl implements LoaikhachRepository{
    public static final String SELECT_LOAIKHACH = "select * from loaikhach";
    private static final String SELECT_LOAIKHACH_ID = "select * from diachi where id_loaikhach= ?;";

    //    public static final String INSERT_KHACHHANG =" insert into khachhang(id_khachhang,ten_khachhang,ngaysinh,gioitinh,socmnd,sdt,email,id_loaikhach, id_diachi) value (?,?,?,?,?,?,?,?,?);";
//    public static final String DELETE_KHACHHANG ="delete from khachhang where id_khachhang=?;";
//    private static final String UPDATE_KHACHHANG ="update khachhang set ten_khachhang =?,ngaysinh=?,gioitinh=?,socmnd=?,sdt=?,email=?,id_loaikhach=?, id_diachi=? where id_khachhang=? ;";
//    private static final String SELECT_KHACHHANG_NAME= "select id_khachhang,ten_khachhang,ngaysinh,gioitinh,socmnd,sdt,email,ten_loaikhach,sonha,xa,huyen,tinh,quocgia,loaikhach.id_loaikhach, diachi.id_diachi from khachhang left join diachi on khachhang.id_diachi = diachi.id_diachi left join loaikhach on loaikhach.id_loaikhach = khachhang.id_loaikhach where khachhang.ten_khachhang= ?;";
//    private static final String SELECT_USERS_ID =  "select  * from khachhang where id_khachhang= ?";
    @Override
    public List<Loaikhach> finAll() {
        List<Loaikhach> loaikhachList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_LOAIKHACH);
                resultSet= statement.executeQuery();
                System.out.println("kết nối thanhg công");
                Loaikhach loaikhach = null;
                while (resultSet.next())
                {
                    String  id_loaikhach = resultSet.getString("id_loaikhach");
                    String  ten_loaikhach = resultSet.getString("ten_loaikhach");
                   loaikhach = new Loaikhach(id_loaikhach,ten_loaikhach);
                   loaikhachList.add(loaikhach);

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
        return loaikhachList;
    }

    @Override
    public void save(Loaikhach loaikhach) {

    }

    @Override
    public List<Loaikhach> finByName(String name) {
        return null;
    }

    @Override
    public Loaikhach update(String id, Loaikhach loaikhach) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Loaikhach finById1(String id) {
        Loaikhach loaikhach = null;
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_LOAIKHACH_ID );
                statement.setString(1,id);

                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String  id_loaikhach = resultSet.getString("id_loaikhach");
                    String  ten_loaikhach = resultSet.getString("ten_loaikhach");
                    loaikhach = new Loaikhach(id_loaikhach,ten_loaikhach);
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
        return loaikhach;
    }

}
