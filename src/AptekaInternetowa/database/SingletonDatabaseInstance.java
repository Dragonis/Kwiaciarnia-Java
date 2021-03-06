/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AptekaInternetowa.database;

import AptekaInternetowa.models.Lek;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public final class SingletonDatabaseInstance {

    Connection conn = null;
    Statement stat = null;
    String databaseName = "test.db";
    File file = null;
    
    public SingletonDatabaseInstance() throws ClassNotFoundException, SQLException {
        
        Initialization(); 
        // * sprawdzecznie czy baza danych istnieje, jak nie to tworzy ja
        pokazLekizDB();
        pokazPromocyjneLekizDB();
        // closeConnection();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
    
    public void Initialization() throws ClassNotFoundException, SQLException
    {
        
        Class.forName("org.sqlite.JDBC");
        conn  = DriverManager.getConnection("jdbc:sqlite:"+ databaseName);
        stat  = conn.createStatement();
    
        createTable();
        
    }
    public void wprowadzLekiDoBazyDanych(String nazwa, String producent, Float cena, Integer sztuk) throws ClassNotFoundException, SQLException
    {
        PreparedStatement prep = conn.prepareStatement(
            "insert into leki values (?, ?, ?, ?);");

        prep.setString(1, nazwa);
        prep.setString(2, producent);
        prep.setFloat(3, cena);
        prep.setInt(4, sztuk);
        prep.addBatch();
        
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
       }

       public void wprowadzPromocyjneLekiDoBazyDanych(String nazwa, String producent, Float cena, Integer sztuk) throws ClassNotFoundException, SQLException
    {
        PreparedStatement prep = conn.prepareStatement(
            "insert into promocja values (?, ?, ?, ?);");

        prep.setString(1, nazwa);
        prep.setString(2, producent);
        prep.setFloat(3, cena);
        prep.setInt(4, sztuk);
        prep.addBatch();
        
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
       }
    
    public ArrayList<Lek> pokazLekizDB() throws SQLException {
        ArrayList<Lek> leki = new ArrayList<Lek>();
        int i=0;
        ResultSet rs = stat.executeQuery("select * from leki;");
        while (rs.next()) {
            
            String nazwa = rs.getString("nazwa");
            System.out.println("nazwa = " + nazwa);
            String producent = rs.getString("producent");
            System.out.println("producent= " + producent);
            float cena = rs.getFloat("cena");
            System.out.println("cena= " + cena);
            int sztuk = rs.getInt("sztuk");
            System.out.println("sztuk= " + sztuk);
            leki.add(new Lek(i,nazwa,producent,cena,sztuk));
                    i++;
        }
        rs.close();
        return leki;
    }
    
     public ArrayList<Lek> pokazPromocyjneLekizDB() throws SQLException {
        ArrayList<Lek> leki = new ArrayList<Lek>();
        int i=0;
        ResultSet rs = stat.executeQuery("select * from promocja;");
        while (rs.next()) {
            
            String nazwa = rs.getString("nazwa");
            String producent = rs.getString("producent");
            float cena = rs.getFloat("cena");
            int sztuk = rs.getInt("sztuk");
            leki.add(new Lek(i,nazwa,producent,cena,sztuk));
                    i++;
        }
        rs.close();
        return leki;
    }

    public void createTable() throws SQLException {
         stat.executeUpdate("create table if not exists leki (nazwa,producent,cena,sztuk);");
         stat.executeUpdate("create table if not exists promocja (nazwa,producent,cena,sztuk);");
    }

    public void usunDB() throws SQLException
    {
        stat.executeUpdate("drop table leki;");       
        stat.executeUpdate("drop table promocja;");       
    }
  



   
    }
