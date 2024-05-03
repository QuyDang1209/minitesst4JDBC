package controller;

import model.Glasses;
import model.IGlasessDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GlassDAO implements IGlasessDAO {
    public GlassDAO(){

    }
    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/glasses?useSSL=false","root","quydang123456");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Override
    public void insertGlasses(Glasses glass) {
        System.out.println();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO glasses (id,code,price,color,decription,img) values (?,?,?,?,?,?)");
            preparedStatement.setInt(1,glass.getId());
            preparedStatement.setString(2,glass.getCode());
            preparedStatement.setInt(3,glass.getPrice());
            preparedStatement.setString(4, glass.getColor());
            preparedStatement.setString(5, glass.getDecription());
            preparedStatement.setString(6,glass.getImg());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Glasses findGlass(int id) {
        Glasses glasses = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select id,code,price,color,decription,img from glasses where id=?");
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String code = rs.getString("code");
                int price = rs.getInt("price");
                String color = rs.getString("color");
                String decription = rs.getString("decription");
                String img = rs.getString("img");
                glasses = new Glasses(id,code,price,color,decription,img);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return glasses;
    }

    @Override
    public List<Glasses> selectAllGlasess() {
        List<Glasses> glasses = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM glasses");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String code = rs.getString("code");
                int price = rs.getInt("price");
                String color = rs.getString("color");
                String decription = rs.getString("decription");
                String img = rs.getString("img");
                glasses.add(new Glasses(id, code, price, color,decription,img));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return glasses;
    }

    @Override
    public boolean deleteGlasses(int id) throws Exception {
        boolean rowDelete;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from glasses where id =?");
        statement.setInt(1,id);
        rowDelete = statement.executeUpdate() >0;
        return rowDelete;
    }

    @Override
    public boolean updateGlasses(Glasses glass) throws Exception {
        boolean rowUpdate;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("update glasses set code=?,price=?,color=?,decription=?,img=? where id =?");
        statement.setString(1, glass.getCode());
        statement.setInt(2,glass.getPrice());
        statement.setString(3,glass.getColor());
        statement.setString(4,glass.getDecription());
        statement.setString(5,glass.getImg());
        statement.setInt(6, glass.getId());
        rowUpdate = statement.executeUpdate() >0;
        return rowUpdate;
    }
    private void printSQLException(SQLException ex){
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
