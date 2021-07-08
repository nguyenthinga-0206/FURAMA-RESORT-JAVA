package repository;

import model.Kieuthue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KieuthuRepositprylmpl implements  KieuthuRepositpry {
    public static final String SELECT_KIEUTHUE= "select *from kieuthue";
    @Override
    public List<Kieuthue> finAll() {
        List<Kieuthue> kieuthueList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_KIEUTHUE);
                resultSet = statement.executeQuery();
                Kieuthue kieuthue = null;
                while (resultSet.next()) {
                    String id_kieuthue = resultSet.getString("id_kieuthue");
                    String ten_kieuthue = resultSet.getString("ten_kieuthue");
                    kieuthue = new Kieuthue(id_kieuthue,ten_kieuthue);
                    kieuthueList.add(kieuthue);
                    System.out.println(statement);
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
        return kieuthueList;
    }

    @Override
    public void save(Kieuthue kieuthue) {

    }

    @Override
    public List<Kieuthue> finByName(String name) {
        return null;
    }

    @Override
    public Kieuthue update(String id, Kieuthue kieuthue) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Kieuthue finById1(String id) {
        return null;
    }
}
