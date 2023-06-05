import java.sql.*;

public class dolgozatDb {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS dolgozat0605 CHARACTER SET utf8 COLLATE utf8_hungarian_ci;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS forgalom (id INT PRIMARY KEY, termek VARCHAR(255), vevo VARCHAR(255), kategoria_id INT, egyseg VARCHAR(50), nettoar INT, mennyiseg INT, kiadva TINYINT);");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kategoria (id INT PRIMARY KEY, kategoriaNev VARCHAR(255) ");
            statement.executeUpdate("LOAD DATA INFILE 'c:/bufeforgalom.txt' INTO TABLE forgalom FIELDS TERMINATED BY ';' ENCLOSED BY '\"' IGNORE 1 ROWS;");
            statement.executeUpdate("LOAD DATA INFILE 'c:/bufekategoria.txt' INTO TABLE kategoria FIELDS TERMINATED BY ';' ENCLOSED BY '\"' IGNORE 1 ROWS;");


            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}