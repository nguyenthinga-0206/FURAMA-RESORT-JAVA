package repository;

import model.User;
import model.User_vaitro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Vaitro_usrerRepositorylmpl implements Vaitro_usrerRepository {
    public static final String SELECT_admin = "select ten_user from user_vaitro inner join vaitro \n" +
            " on user_vaitro.vaitro_id= vaitro.vaitro_id where ten_user =? and vaitro.ten_vaitro='giamdoc';";
    public static final String SELECT_NV = "select ten_user from user_vaitro inner join vaitro \n" +
            " on user_vaitro.vaitro_id= vaitro.vaitro_id where ten_user =? and vaitro.ten_vaitro='quanlysv';";
    public static final String SELECT_KH = "select ten_user from user_vaitro inner join vaitro \n" +
            " on user_vaitro.vaitro_id= vaitro.vaitro_id where ten_user =? and vaitro.ten_vaitro='quanlykh';";
    public static final String SELECT_DV = "select ten_user from user_vaitro inner join vaitro \n" +
            " on user_vaitro.vaitro_id= vaitro.vaitro_id where ten_user =? and vaitro.ten_vaitro='quanlydv';";
    public static final String SELECT_HD = "select ten_user from user_vaitro inner join vaitro \n" +
            " on user_vaitro.vaitro_id= vaitro.vaitro_id where ten_user =? and vaitro.ten_vaitro='quanlyhd';";
    public static final String SELECT_XEM = " select user.ten_user from user_vaitro  right join user on user_vaitro.ten_user = user.ten_user where   user.ten_user not in (select ten_user from user_vaitro inner join vaitro on user_vaitro.vaitro_id= vaitro.vaitro_id) and  user.ten_user =?;";
    @Override
    public List<User_vaitro> finAll() {
        return null;
    }

    @Override
    public void save(User_vaitro user_vaitro) {

    }

    @Override
    public boolean finByName(String vaitro, String ten) {
        return false;
    }

    @Override
    public User_vaitro update(String vaitro, User_vaitro user_vaitro) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<User_vaitro> finById(String vaitro) {
        return null;
    }

    @Override
    public boolean finBygiamdoc(String ten_user1) {
        User_vaitro user_vaitro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement( SELECT_admin);
                statement.setString(1,ten_user1);
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String ten_user = resultSet.getString("ten_user");
                    user_vaitro = new User_vaitro(ten_user);
                    // userList.add(user);
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
        if(user_vaitro == null)
            return false;
        else
            return  true;
    }

    @Override
    public boolean finBynv(String ten_user1) {
        User_vaitro user_vaitro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement( SELECT_NV);
                statement.setString(1,ten_user1);
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String ten_user = resultSet.getString("ten_user");
                    user_vaitro = new User_vaitro(ten_user);
                    // userList.add(user);
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
        if(user_vaitro == null)
            return false;
        else
            return  true;
    }

    @Override
    public boolean finBykh(String ten_user1) {
        User_vaitro user_vaitro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement( SELECT_KH);
                statement.setString(1,ten_user1);
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String ten_user = resultSet.getString("ten_user");
                    user_vaitro = new User_vaitro(ten_user);
                    // userList.add(user);
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
        if(user_vaitro == null)
            return false;
        else
            return  true;
    }

    @Override
    public boolean finBydv(String ten_user1) {
        User_vaitro user_vaitro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement( SELECT_DV);
                statement.setString(1,ten_user1);
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String ten_user = resultSet.getString("ten_user");
                    user_vaitro = new User_vaitro(ten_user);
                    // userList.add(user);
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
        if(user_vaitro == null)
            return false;
        else
            return  true;
    }

    @Override
    public boolean finByhd(String ten_user1) {
        User_vaitro user_vaitro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement( SELECT_HD);
                statement.setString(1,ten_user1);
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String ten_user = resultSet.getString("ten_user");
                    user_vaitro = new User_vaitro(ten_user);
                    // userList.add(user);
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
        if(user_vaitro == null)
            return false;
        else
            return  true;
    }

    @Override
    public boolean finByXem(String ten_user) {
        User_vaitro user_vaitro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        if(connection != null)
        {
            try{
                statement= connection.prepareStatement(SELECT_XEM);
                statement.setString(1,ten_user);
                resultSet = statement.executeQuery();

                while (resultSet.next())
                {
                    String ten_user1 = resultSet.getString("ten_user");
                    user_vaitro = new User_vaitro(ten_user1);
                    // userList.add(user);
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
        if(user_vaitro == null)
            return false;
        else
            return  true;
    }
}
