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

public class DiachiRepositprylmpl implements  DiachiRepositpry {
    public static final String SELECT_DIACHI = "select * from diachi";
    public static final String INSERT_DIACHI = "insert into diachi(id_diachi,sonha,xa,huyen,tinh,quocgia) value (?,?,?,?,?,?);";
    private static final String SELECT_DIACHI_ID= "select * from diachi where id_diachi= ?;";
   @Override
    public List<Diachi> finAll() {
        List<Diachi> diachiList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_DIACHI);
                resultSet= statement.executeQuery();
                System.out.println("kết nối thanhg công");
                Diachi diachi = null;
                while (resultSet.next())
                {
                    String id_diachi=resultSet.getString("id_diachi");
                    String sonha = resultSet.getString("sonha");
                    String xa = resultSet.getString("xa");
                    String huyen = resultSet.getString("huyen");
                    String tinh = resultSet.getString("tinh");
                    String quocgia = resultSet.getString("quocgia");
                    diachi = new Diachi(id_diachi,sonha,xa,huyen,tinh,quocgia);
                    diachiList.add(diachi);
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
        return diachiList;
    }

    @Override
    public void save(Diachi diachi) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(INSERT_DIACHI);
                System.out.println("SQL1:" +statement);
                statement.setString(1,diachi.getId_diachi());
                statement.setString(2,diachi.getSonha());
                statement.setString(3,diachi.getXa());
                statement.setString(4,diachi.getHuyen());
                statement.setString(5,diachi.getTinh());
                statement.setString(6,diachi.getQuocgia());
                statement.executeUpdate();
                System.out.println("SQL2:" +statement);
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
    public List<Diachi> finByName(String name) {
        return null;
    }

    @Override
    public Diachi update(String id, Diachi diachi) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Diachi finById1(String id) {
        Diachi diachi = null;
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_DIACHI_ID);
                statement.setString(1,id);

                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String id_diachi=resultSet.getString("id_diachi");
                    String sonha = resultSet.getString("sonha");
                    String xa = resultSet.getString("xa");
                    String huyen = resultSet.getString("huyen");
                    String tinh = resultSet.getString("tinh");
                    String quocgia = resultSet.getString("quocgia");
                    diachi = new Diachi(id_diachi,sonha,xa,huyen,tinh,quocgia);
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
        return diachi;
    }
}
