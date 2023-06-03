package sqlite;

import com.example.bringjustice.Terrorist;

import java.sql.*;
public class SQLite {
    private Connection connection;

    public SQLite (){
        connect("Lizzie");


    }
    // funkar
    public void connect(String databasePath) {
        try {
            // Anslut till databasen
            connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath + ".db");
            System.out.println("Databasanslutning etablerad.");
        } catch (SQLException e) {
            System.err.println("Anslutningsfel: " + e.getMessage());
        }
    }

    // funkar
    public void disconnect() {
        try {
            // Stänger anslutningen till databasen
            if (connection != null) {
                connection.close();
                System.out.println("Databasanslutning stängd.");
            }
        } catch (SQLException e) {
            System.err.println("Stängningsfel: " + e.getMessage());
        }
    }
    public void createTablePlayer(){

        String SQL = "CREATE TABLE IF NOT EXISTS Player("
                + "Player_id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                +"Player_name VARCHAR(30) NOT NULL, \n"
                +"Amount_killed INTEGER, \n"
                +"Amount_captured INTEGER);";

        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.execute();
            System.out.println("Tabell 'player' skapad.");
        } catch (SQLException e) {
            System.err.println("Fel med att skapa tabell 'player': " + e.getMessage());
        }

    }
    public void createTerroristTable(){
        String SQL = "CREATE TABLE IF NOT EXISTS Terrorist("
                + "Terrorist_id INTEGER PRIMARY KEYAUTOINCREMENT,\n"
                + "Terrorist_name VARCHAR(100)NOT NULL,\n"
                + "Terrorist_pic_url VARCHAR (200),\n"
                +"Terrorist_description TEXT,\n"
                +"Alive VARCHAR(1),"
                +"";
    }
    public Integer security(Terrorist terrorist) {
        String sql = "SELECT terrorist_id FROM Terrorist "
                + "WHERE Terrorist_name=? AND pic=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, terrorist.getName);
            p.setString(2, terrorist.getPic());
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt("Terrorist_id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " fel med att hämta användare");
        } return null;

    }
    public void updateStatus(Terrorist terrorist, String action) {
        String a = "";
        if (action.equals("kill")) {
            a = "K";
        } else {
            a = "C";
        }

        String sql = "UPDATE Terrorist SET Alive = ? WHERE Terrorist_id = ?";

        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, a);
            p.setInt(2, security(terrorist));
            p.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " fel med att uppdatera status");
        }
    }


}
