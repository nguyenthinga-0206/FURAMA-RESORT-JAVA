package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserReposetorylmpl implements UserReposetory {
    public static final String SELECT_USER = "select * from user";
    public static final String INSERT_USER = "insert into user(ten_user,matkhau) value (?,?);";
    private static final String SELECT_USER_TEN = "select * from user where ten_user= ? and matkhau=?;";
    private static final String SELECT_USER_MK = "select * from user where matkhau= ?;";

    @Override
    public List<User> finAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    String ten_user = resultSet.getString("ten_user");
                    String matkhau = resultSet.getString("matkhau");
                    user = new User(ten_user, matkhau);
                    userList.add(user);
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

        return userList;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_USER);
                System.out.println("SQL1:" + statement);
                statement.setString(1, user.getTen_user());
                statement.setString(2, user.getMatkhau());
                statement.executeUpdate();
                System.out.println("SQL2:" + statement);
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
    }

    @Override
    public boolean finByName(String name, String mk) {
        // List<User> userList = new ArrayList<>();
        User user = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_TEN);
                statement.setString(1, name);
                statement.setString(2, mk);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String ten_user = resultSet.getString("ten_user");
                    String matkhau = resultSet.getString("matkhau");
                    user = new User(ten_user);
                    // userList.add(user);
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
        if (user == null)
            return false;
        else
            return true;
    }

    @Override
    public User update(String id, User user) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<User> finById1(String id) {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_MK);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                System.out.println("SQL1" + statement);
                User user = null;
                while (resultSet.next()) {
                    String ten_user = resultSet.getString("ten_user");
                    String matkhau = resultSet.getString("matkhau");
                    user = new User(ten_user, matkhau);
                    userList.add(user);
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
        return userList;
    }
}
