package repository;

import model.Dichvu;
import model.Kieuthue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichvuRepositorylmpl implements  DichvuRepository{
    public static final String SELECT_DICHVU ="select dichvu.id_dichvu,ten_dichvu,dientich,chiphi,songuoi,dichvu.id_kieuthue,kieuthue.ten_kieuthue from dichvu inner join kieuthue on  dichvu.id_kieuthue = kieuthue.id_kieuthue ;";
    public static final String INSERT_DICHVU =" insert into dichvu(id_dichvu,ten_dichvu,dientich,chiphi,songuoi,id_kieuthue) value (?,?,?,?,?,?);";
    public static final String DELETE_DICHVU ="delete from dichvu where id_dichvu=?;";
    public static final String SELECT_DICHVU_NAME = "select dichvu.id_dichvu,ten_dichvu,dientich,chiphi,songuoi,kieuthue.id_kieuthue,kieuthue.ten_kieuthue from dichvu inner join kieuthue on  dichvu.id_kieuthue = kieuthue.id_kieuthue where ten_dichvu =?;";
    public static final String UPDATE_DICHVU ="update dichvu set ten_dichvu=?,dientich=?,chiphi=?,songuoi=?,id_kieuthue=? where id_dichvu = ?;";
    public static final String SELECT_DICHVU_ID = "select dichvu.id_dichvu,ten_dichvu,dientich,chiphi,songuoi,dichvu.id_kieuthue,kieuthue.ten_kieuthue from dichvu inner join kieuthue on  dichvu.id_kieuthue = kieuthue.id_kieuthue where id_dichvu =?;";

    @Override

    public List<Dichvu> finAll() {
        List<Dichvu> dichvuList= new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_DICHVU);
                resultSet = statement.executeQuery();
                Dichvu dichvu = null;
                while (resultSet.next()) {
                    String id_dichvu = resultSet.getString("id_dichvu");
                    String ten_dichvu = resultSet.getString("ten_dichvu");
                    float dientich=Float.parseFloat(resultSet.getString("dientich"));
                    float chiphi= Float.parseFloat(resultSet.getString("chiphi"));
                    String songuoi = resultSet.getString("songuoi");
                    String id_kieuthue = resultSet.getString("id_kieuthue");
                    String ten_kieuthue = resultSet.getString("ten_kieuthue");
                    dichvu = new Dichvu(id_dichvu,ten_dichvu,dientich,chiphi,songuoi, new  Kieuthue(id_kieuthue,ten_kieuthue));
                    dichvuList.add(dichvu);
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
        return dichvuList;
    }
    @Override
    public void save(Dichvu dichvu) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(INSERT_DICHVU);
                statement.setString(1,dichvu.getId_dichvu());
                statement.setString(2,dichvu.getTen_dichvu());
                statement.setFloat(3,dichvu.getDientich());
                statement.setFloat(4,dichvu.getChiphi());
                statement.setString(5,dichvu.getSonguoi());
                statement.setString(6,dichvu.getKieuthue().getId_kieuthue());
                System.out.println("statemem save" + statement);
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
    public List<Dichvu> finByName(String name) {
        List<Dichvu> dichvuList = new ArrayList<>();
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
    {
        try{
            statement = connection.prepareStatement(SELECT_DICHVU_NAME);
            statement.setString(1,name );
            resultSet = statement.executeQuery();
            Dichvu dichvu = null;
            while (resultSet.next())
            {
                String id_dichvu = resultSet.getString("id_dichvu");
                String ten_dichvu = resultSet.getString("ten_dichvu");
                float dientich=Float.parseFloat(resultSet.getString("dientich"));
                float chiphi= Float.parseFloat(resultSet.getString("chiphi"));
                String songuoi = resultSet.getString("songuoi");
                String id_kieuthue = resultSet.getString("id_kieuthue");
                String ten_kieuthue = resultSet.getString("ten_kieuthue");
                System.out.println("tem kiem name:" +statement);
                System.out.println("Id_dich vu" +id_dichvu);
                dichvu = new Dichvu(id_dichvu,ten_dichvu,dientich,chiphi,songuoi, new  Kieuthue( id_kieuthue,ten_kieuthue));
                dichvuList.add(dichvu);
                System.out.println("dichv u; "+ dichvuList);
                System.out.println();
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
        return dichvuList;
}


    @Override
    public Dichvu update(String id, Dichvu dichvu) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
        try{
        statement= connection.prepareStatement(UPDATE_DICHVU);
            statement.setString(1,dichvu.getTen_dichvu());
            statement.setFloat(2,dichvu.getDientich());
            statement.setFloat(3,dichvu.getChiphi());
            statement.setString(4,dichvu.getSonguoi());
            statement.setString(5,dichvu.getKieuthue().getId_kieuthue());
            statement.setString(6,dichvu.getId_dichvu());
        System.out.println("Dich vu 01"+  statement);
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
        return dichvu;
    }

    @Override
    public void remove(String id) {
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection != null)
        {
        try{
            statement = connection.prepareStatement(DELETE_DICHVU);
            statement.setString(1,id);
            statement.executeUpdate();
            System.out.println("xoa tc " +statement);
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
    public Dichvu finById1(String id) {
        Dichvu dichvu = null;
        Connection connection= DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement = connection.prepareStatement(SELECT_DICHVU_ID);
                statement.setString(1,id );
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String id_dichvu = resultSet.getString("id_dichvu");
                    String ten_dichvu = resultSet.getString("ten_dichvu");
                    float dientich=Float.parseFloat(resultSet.getString("dientich"));
                    float chiphi= Float.parseFloat(resultSet.getString("chiphi"));
                    String songuoi = resultSet.getString("songuoi");
                    String id_kieuthue = resultSet.getString("id_kieuthue");
                    String ten_kieuthue = resultSet.getString("ten_kieuthue");
                    dichvu = new Dichvu(id_dichvu,ten_dichvu,dientich,chiphi,songuoi, new  Kieuthue(id_kieuthue,ten_kieuthue));
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
        return dichvu;
    }
}
