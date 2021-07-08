package repository;

import model.Dichvu;
import model.Hopdong;
import model.Khachhang;
import model.Nhanvien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HopdongRepositorylmpl implements  HopdongRepository{
    public  static  final String SELECT_HOPDONG = "select id_hopdong,ngaybatau,ngayketthuc,sotiendatcuoc ,tongsotienthanhtoan,nhanvien.ten_nhanvien," +
            "khachhang.ten_khachhang, dichvu.ten_dichvu,hopdong.id_nhanvien,hopdong.id_khachhang,hopdong.id_dichvu from hopdong" +
            " inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang" +
            " inner join dichvu on hopdong.id_dichvu = dichvu.id_dichvu " +
            " inner join nhanvien on hopdong.id_nhanvien = nhanvien.id_nhanvien;";
    public  static  final String SELECT_HOPDONG_NAME = "select id_hopdong,ngaybatau,ngayketthuc,sotiendatcuoc ,tongsotienthanhtoan,nhanvien.ten_nhanvien," +
            "khachhang.ten_khachhang, dichvu.ten_dichvu,hopdong.id_nhanvien,hopdong.id_khachhang,hopdong.id_dichvu from hopdong" +
            " inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang" +
            " inner join dichvu on hopdong.id_dichvu = dichvu.id_dichvu " +
            " inner join nhanvien on hopdong.id_nhanvien = nhanvien.id_nhanvien where khachhang.ten_khachhang=?;";
    public  static  final String SELECT_HOPDONG_ID = "select id_hopdong,ngaybatau,ngayketthuc,sotiendatcuoc ,tongsotienthanhtoan,nhanvien.ten_nhanvien," +
            "khachhang.ten_khachhang, dichvu.ten_dichvu,hopdong.id_nhanvien,hopdong.id_khachhang,hopdong.id_dichvu from hopdong" +
            " inner join khachhang on khachhang.id_khachhang = hopdong.id_khachhang" +
            " inner join dichvu on hopdong.id_dichvu = dichvu.id_dichvu " +
            " inner join nhanvien on hopdong.id_nhanvien = nhanvien.id_nhanvien where id_hopdong =?;";
    public  static  final String DELETE_HOPDONG = "delete from hopdong where id_hopdong = ?;";
    public  static  final String INSERT_HOPDONG = "insert into hopdong( id_hopdong, ngaybatau,  ngayketthuc, sotiendatcuoc,tongsotienthanhtoan ,id_nhanvien, id_khachhang ,id_dichvu) value (?,?,?,?,?,?,?,?);";
    public  static  final String  UPDATE_HOPDONG ="update hopdong set id_hopdong =?, ngaybatau =?, ngayketthuc =?, sotiendatcuoc =?,tongsotienthanhtoan  =?,id_nhanvien =?, id_khachhang  =?,id_dichvu =? where id_hopdong =?;";


    @Override
    public List<Hopdong> finAll() {
        List<Hopdong> hopdongList =  new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_HOPDONG);
                resultSet =statement.executeQuery();
                Hopdong hopdong = null;
                while (resultSet.next())
                {
                    String id_hopdong = resultSet.getString("id_hopdong");
                    String ngaybatdau = resultSet.getString("ngaybatau");
                    String ngayketthuc = resultSet.getString("ngayketthuc");
                    float  sotiendatcuoc =resultSet.getFloat("sotiendatcuoc");
                    float  tongsotienthanhtoan =resultSet.getFloat("tongsotienthanhtoan");
                    String ten_nhanvien = resultSet.getString("ten_nhanvien");
                    String ten_khachhang = resultSet.getString("ten_khachhang");
                    String ten_dichvu = resultSet.getString("ten_dichvu");
                    String id_nhanvien = resultSet.getString("id_nhanvien");
                    String id_khachhang = resultSet.getString("id_khachhang");
                    String id_dichvu = resultSet.getString("id_dichvu");
                    hopdong = new Hopdong(id_hopdong,ngaybatdau,ngayketthuc,sotiendatcuoc,tongsotienthanhtoan,new Nhanvien(id_nhanvien,ten_nhanvien), new Khachhang(id_khachhang,ten_khachhang), new Dichvu(id_dichvu,ten_dichvu));
                    hopdongList.add(hopdong);
//                    System.out.println("Danh sach hop dong: "+  ten_nhanvien );
//                    System.out.println("Danh sach hop dong: "+ new Nhanvien(id_nhanvien).getTen_nhanvien());
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
        return hopdongList;
    }

    @Override
    public void save(Hopdong hopdong) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(INSERT_HOPDONG);
                System.out.println("SQL1:" +statement);
                statement.setString(1,hopdong.getId_hopdong());
                statement.setString(2,hopdong.getNgaybatdau());
                statement.setString(3,hopdong.getNgayketthuc());
                statement.setFloat(4,hopdong.getSotiendatco());
                statement.setFloat(5,hopdong.getTongsotienthanhtoan());
                statement.setString(6,hopdong.getNhanvien().getId_nhanvien());
                statement.setString(7,hopdong.getKhachhang().getId_khachhang());
                statement.setString(8,hopdong.getDichvu().getId_dichvu());
                System.out.println("SQL2:" +statement);
                statement.executeUpdate();
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
    public List<Hopdong> finByName(String name) {
        List<Hopdong> hopdongList =  new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_HOPDONG_NAME);
                statement.setString(1 ,name);
                System.out.println("sql2: "+ statement);
                resultSet =statement.executeQuery();
                Hopdong hopdong = null;
                while (resultSet.next())
                {
                    String id_hopdong = resultSet.getString("id_hopdong");
                    String ngaybatdau = resultSet.getString("ngaybatau");
                    String ngayketthuc = resultSet.getString("ngayketthuc");
                    float  sotiendatcuoc =resultSet.getFloat("sotiendatcuoc");
                    float  tongsotienthanhtoan =resultSet.getFloat("tongsotienthanhtoan");
                    String ten_nhanvien = resultSet.getString("ten_nhanvien");
                    String ten_khachhang = resultSet.getString("ten_khachhang");
                    String ten_dichvu = resultSet.getString("ten_dichvu");
                    String id_nhanvien = resultSet.getString("id_nhanvien");
                    String id_khachhang = resultSet.getString("id_khachhang");
                    String id_dichvu = resultSet.getString("id_dichvu");
                    hopdong = new Hopdong(id_hopdong,ngaybatdau,ngayketthuc,sotiendatcuoc,tongsotienthanhtoan,new Nhanvien(id_nhanvien,ten_nhanvien), new Khachhang(id_khachhang,ten_khachhang), new Dichvu(id_dichvu,ten_dichvu));
                    hopdongList.add(hopdong);
                    System.out.println("Danh sach hop dong khach hang: "+ ten_khachhang );
                    System.out.println("sql2: "+ statement);
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
        return hopdongList;
    }

    @Override
    public Hopdong update(String id, Hopdong hopdong) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_HOPDONG);
                System.out.println("SQL1:" + statement);
                statement.setString(1, hopdong.getId_hopdong());
                statement.setString(2, hopdong.getNgaybatdau());
                statement.setString(3, hopdong.getNgayketthuc());
                statement.setFloat(4, hopdong.getSotiendatco());
                statement.setFloat(5, hopdong.getTongsotienthanhtoan());
                statement.setString(6, hopdong.getNhanvien().getId_nhanvien());
                statement.setString(7, hopdong.getKhachhang().getId_khachhang());
                statement.setString(8, hopdong.getDichvu().getId_dichvu());
                statement.setString(9, hopdong.getId_hopdong());
                System.out.println("SQL2:" + statement);
                statement.executeUpdate();
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
        return  hopdong;
    }

    @Override
    public void remove(String id) {
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(DELETE_HOPDONG);
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
    public Hopdong finById1(String id) {
        Hopdong hopdong = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_HOPDONG_ID);
                statement.setString(1 ,id);
                resultSet =statement.executeQuery();
                System.out.println("SQL1" + statement);
                while (resultSet.next())
                {
                    String id_hopdong = resultSet.getString("id_hopdong");
                    String ngaybatdau = resultSet.getString("ngaybatau");
                    String ngayketthuc = resultSet.getString("ngayketthuc");
                    float  sotiendatcuoc =resultSet.getFloat("sotiendatcuoc");
                    float  tongsotienthanhtoan =resultSet.getFloat("tongsotienthanhtoan");
                    String ten_nhanvien = resultSet.getString("ten_nhanvien");
                    String ten_khachhang = resultSet.getString("ten_khachhang");
                    String ten_dichvu = resultSet.getString("ten_dichvu");
                    String id_nhanvien = resultSet.getString("id_nhanvien");
                    String id_khachhang = resultSet.getString("id_khachhang");
                    String id_dichvu = resultSet.getString("id_dichvu");
                    hopdong = new Hopdong(id_hopdong,ngaybatdau,ngayketthuc,sotiendatcuoc,tongsotienthanhtoan,new Nhanvien(id_nhanvien,ten_nhanvien), new Khachhang(id_khachhang,ten_khachhang), new Dichvu(id_dichvu,ten_dichvu));
                    System.out.println(" hop dong tim thay" + hopdong);
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
        return hopdong;
    }
}
