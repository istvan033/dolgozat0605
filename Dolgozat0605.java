import java.sql.*;


public class Dolgozat0605 {

    
    public static void main(String[] args)  {
        
        
        System.out.println("Pásztor István Oscar");
        System.out.println("");

        String url="jdbc:mysql://localhost:3306/";
        String username="root";
        String password="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            System.out.println("1 feladat:");
            String insertQuery = "INSERT INTO kategoria (kategoriaNev) VALUES ('Ajandektárgyak');";
            statement.executeUpdate(insertQuery);


            System.out.println("Az új rekord sikeresen hozzá lett adva a kategoria táblához.");
           
            
            System.out.println("2 feladat:");
            String updateQuery = "UPDATE forgalom SET termek = REPLACE(termek, 'gyorstál', 'gyors tál')";
            statement.executeUpdate(updateQuery);
            
            System.out.println("A 'gyorstál' értéke sikeresen javítva lett 'gyors tál'-ra a forgalom táblában.");
            
            
            System.out.println("3 feladat:");
            String query = "SELECT vevo FROM rendelesek WHERE kiadva = 0 ORDER BY vevo ASC";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String vevo = resultSet.getString("vevo");
                System.out.println(vevo);
            }
            
            
           
            //ez rész nem működik de a próbálkozásom itt van//
            
            //System.out.println("4 feladat:");
            //String query = "SELECT k.kategoriaNev, SUM(f.nettoar * f.mennyiseg) AS nettoBevetel, SUM(f.nettoar * f.mennyiseg * 0.27) AS forgalmiAdo " +
            //              "FROM forgalom f " +
            //               "INNER JOIN kategoria k ON f.kategoria_id = k.id " +
            //              "GROUP BY k.kategoriaNev";
            //ResultSet resultSet = statement.executeQuery(query);


            //System.out.printf(kategoriaNev, nettoBevetel, forgalmiAdo);
            //}
                        

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
