package com.Vlad.database;





import java.sql.*;

public class Main {



    private static final String URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String INSERT_NEW = "INSERT INTO new_table(name, age, email) VALUES(?,?,?)";

    public static void main(String[] args) {

        connect("David", 35, "David@icloud.com");
    }

    public static void connect(String name, Integer age, String email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //Statement statement = connection.createStatement();


            //запросы
            //statement.execute("INSERT INTO new_table( name, age, email) VALUES ('Dima',20,'Dima@mail.com')");
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,email);

            preparedStatement.execute();

            System.out.println(connection.isClosed());
            System.out.println("successful");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                System.out.println("соединение закрыто");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
