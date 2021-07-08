package repository;

import model.Bophan;
import model.Vitri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BophanRepositorylmpl implements  BophanRepository {
    public static final String SELECT_BOPHAN = "select * from bophan";
    public static final String INSERT_BOPHAN = "insert into bophan(id_bophan,ten_bophan) value (?,?);";
    private static final String SELECT_BOPHAN_ID= "select * from bophan where id_bophan= ?;";

    @Override
    public List<Bophan> finAll() {
        List<Bophan> bophanList= new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_BOPHAN);
                resultSet = statement.executeQuery();
                Bophan bophan = null;
                while (resultSet.next())
                {
                    String id_bophan = resultSet.getString("id_bophan");
                    String ten_bophan = resultSet.getString("ten_bophan");
                    bophan = new Bophan(id_bophan,ten_bophan);
                    bophanList.add(bophan);
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
        return bophanList;
    }

    @Override
    public void save(Bophan bophan) {

    }

    @Override
    public List<Bophan> finByName(String name) {
        return null;
    }

    @Override
    public Bophan update(String id, Bophan bophan) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Bophan finById1(String id) {
        Bophan bophan = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_BOPHAN_ID);
                statement.setString(1,"id_bophan");
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String id_bophan = resultSet.getString("id_bophan");
                    String ten_bophan = resultSet.getString("ten_bophan");
                    bophan = new Bophan(id_bophan,ten_bophan);
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
        return bophan;
    }
}
