package repository;

import model.Dichvu;
import model.Dvdikem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DvdikemRepositorylmpl implements DvdikemRepository {
    public static final String SELECT_DVDK = "select * from dvdikem";
    public static final String SELECT_DVDK_ID ="select * from dvdikem where id_dvdikem=?";
    @Override
    public List<Dvdikem> finAll() {
        List<Dvdikem> dvdikemList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_DVDK);
                resultSet = statement.executeQuery();
                Dvdikem dvdikem = null;
                while (resultSet.next())
                {
                    String id_dvdikem = resultSet.getString("id_dvdikem");
                    String ten_dvdikem = resultSet.getString("ten_dvdikem");
                    String dongia = resultSet.getString("dongia");
                    Float tien = resultSet.getFloat("tien");
                    dvdikem = new Dvdikem(id_dvdikem,ten_dvdikem,dongia,tien);
                    dvdikemList.add(dvdikem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return dvdikemList;
    }

    @Override
    public void save(Dvdikem dvdikem) {

    }

    @Override
    public List<Dvdikem> finByName(String name) {
        List<Dvdikem> dvdikemList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_DVDK_ID);
                statement.setString(1,name);
                resultSet = statement.executeQuery();
                Dvdikem dvdikem = null;
                while (resultSet.next())
                {
                    String id_dvdikem = resultSet.getString("id_dvdikem");
                    String ten_dvdikem = resultSet.getString("ten_dvdikem");
                    String dongia = resultSet.getString("dongia");
                    Float tien = resultSet.getFloat("tien");
                    dvdikem = new Dvdikem(id_dvdikem,ten_dvdikem,dongia,tien);
                    dvdikemList.add(dvdikem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return dvdikemList;
    }

    @Override
    public Dvdikem update(String id, Dvdikem dvdikem) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Dvdikem finById1(String id) {
        Dvdikem dvdikem = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement("SELECT_DVDK_ID");
                statement.setString(1,id);
                resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    String id_dvdikem = resultSet.getString("id_dvdikem");
                    String ten_dvdikem = resultSet.getString("ten_dvdikem");
                    String dongia = resultSet.getString("dongia");
                    Float tien = resultSet.getFloat("tien");
                    dvdikem = new Dvdikem(id_dvdikem,ten_dvdikem,dongia,tien);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return dvdikem;
    }
}
