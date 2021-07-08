package repository;

import model.Vitri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VitriRepositorylmpl implements VitriRepository {
    public static final String SELECT_VITRI = "select * from vitri";
    public static final String INSERT_VITRI = "insert into vitri(id_vitri,ten_vitri) value (?,?);";
    private static final String SELECT_VITRI_ID= "select * from vitri where id_vitri= ?;";
    @Override
    public List<Vitri> finAll(){
        List<Vitri> vitriList= new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_VITRI);
                resultSet = statement.executeQuery();
                Vitri vitri = null;
                while (resultSet.next())
                {
                    String id_vitri = resultSet.getString("id_vitri");
                    String ten_vitri = resultSet.getString("ten_vitri");
                    vitri = new Vitri(id_vitri,ten_vitri);
                    vitriList.add(vitri);
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

        return vitriList;
    }

    @Override
    public void save(Vitri vitri) {

    }

    @Override
    public List<Vitri> finByName(String name) {
        return null;
    }

    @Override
    public Vitri update(String id, Vitri vitri) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Vitri finById1(String id) {
        Vitri vitri = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_VITRI_ID);
                statement.setString(1,"id_vitri");
                resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    String id_vitri = resultSet.getString("id_vitri");
                    String ten_vitri = resultSet.getString("ten_vitri");
                    vitri = new Vitri(id_vitri,ten_vitri);
                    System.out.println("vi tri theo id:" + vitri);
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
        return vitri;
    }
}
