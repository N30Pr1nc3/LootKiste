package de.myralia.setitems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
//check1
public class MySQLConnection{
private static Connection con = null;
private static String dbHost = "127.0.0.1"; // Hostname test
private static String dbPort = "3306";      // Port -- Standard: 3306
private static String dbName = "minecraft_warper";   // Datenbankname
private static String dbUser = "minecraft_warper";     // Datenbankuser
private static String dbPass = "swE5DvYzbdWqmqtA6cXpzATD";      // Datenbankpasswort
 
private MySQLConnection(){
    try {
        Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.
 
        // Verbindung zur JDBC-Datenbank herstellen.
        con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+ dbPort+"/"+dbName+"?"+"user="+dbUser+"&"+"password="+dbPass);
    } catch (ClassNotFoundException e) {
        System.out.println("Treiber nicht gefunden");
    } catch (SQLException e) {
        System.out.println("Verbindung nicht moglich");
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }
  }
 
private static Connection getInstance(){
    if(con == null){
        new MySQLConnection();
    }
    try {
		if(con.isClosed()){
		    new MySQLConnection();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return con;
}
 
public static void getSet(){

    con = getInstance();

    if(con == null){
    	return;
    }
    Statement query;
    try {
    	query = con.createStatement();
        String sql = "SELECT * FROM itemSet where geloescht = ''";
        ResultSet result = query.executeQuery(sql);

  	  	ItemSet.deleteAll();
        while (result.next()) {
        	int id = result.getInt("id");
        	String bez = result.getString("bez");
        	new ItemSet(id,bez);
        }
	}catch (SQLException e) {
		e.printStackTrace();
    }
}

public static void getItem(){

      con = getInstance();

      if(con != null){
      // Abfrage-Statement erzeugen.
      Statement query;
     
      try {
          query = con.createStatement();
 
          // Tabelle anzeigen
          String sql =
                "SELECT * FROM item where geloescht = ''";
          ResultSet result = query.executeQuery(sql);

    	  SetItem.deleteAll();
          while (result.next()) {
        	  int id = result.getInt("id");
        	  int setid = result.getInt("set");
        	  ItemSet set = ItemSet.getSetById(setid);
        	  if(set == null){
        		  System.out.println("Fehler: für das item "+id+" wurde das set "+setid+" nicht gefunden");
        		  continue;
        	  }
        	  Material material = Material.getMaterial(result.getString("material"));
        	  if(material==null){
        		  System.out.println("Fehler: für das item "+id+" konnte das material '"+result.getString("material")+"' nicht gefunden werden");
        		  continue;
        	  }
        	  new SetItem(id,set,result.getString("bez"),material);
          }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}