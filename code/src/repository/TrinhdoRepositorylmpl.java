package repository;

import model.Trinhdo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrinhdoRepositorylmpl implements  TrinhdoRepository {
    public static final String SELECT_TRINHDO = "select * from trinhdo";
    public static final String INSERT_TRINHDO  = "insert into tirnhdo(id_trinhdo,ten_trinhdo) value (?,?);";
    private static final String SELECT_TRINHDO_ID= "select * from trinhdo where id_trinhdo= ?;";
    @Override
    public List<Trinhdo> finAll() {
        List<Trinhdo> trinhdoList= new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet =  null;
        if(connection != null)
        {
            try
            {
                statement = connection.prepareStatement(SELECT_TRINHDO);
                resultSet= statement.executeQuery();
                Trinhdo trinhdo = null;
                while (resultSet.next())
                {
                    String id_trinhdo = resultSet.getString("id_trinhdo");
                    String ten_trinhdo = resultSet.getString("ten_trinhdo");
                    trinhdo = new Trinhdo(id_trinhdo,ten_trinhdo);
                    trinhdoList.add(trinhdo);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return trinhdoList;
    }

    @Override
    public void save(Trinhdo trinhdo) {

    }

    @Override
    public List<Trinhdo> finByName(String name) {
        return null;
    }

    @Override
    public Trinhdo update(String id, Trinhdo trinhdo) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Trinhdo finById1(String id) {
        Trinhdo trinhdo = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet =  null;
        if(connection != null)
        {
            try
            {
                statement = connection.prepareStatement(SELECT_TRINHDO_ID);
                statement.setString(1,"id_trinhdo");
                resultSet= statement.executeQuery();

                while (resultSet.next())
                {
                    String id_trinhdo = resultSet.getString("id_trinhdo");
                    String ten_trinhdo = resultSet.getString("ten_trinhdo");
                    trinhdo = new Trinhdo(id_trinhdo,ten_trinhdo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return trinhdo;
    }
}
