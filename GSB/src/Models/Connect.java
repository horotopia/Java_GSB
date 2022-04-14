package Models;

import java.sql.*;
import java.util.*;

public class Connect
{

    private String driver, db_url, user, pwd, query;
    private String resultReq;
    private Connection conn;

    public Connect()
    {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.db_url = "jdbc:mysql://localhost/GSB";
        this.user = "root";
        this.pwd = "root";
        this.query = "SELECT VIS_NOM, VIS_PRENOM FROM visiteur";
    }

    public void setConnect(String driver,String db_url,String user,String pwd)
    {
        this.driver = driver;
        this.db_url = db_url;
        this.user = user;
        this.pwd = pwd;
        System.out.println(this.driver);
        System.out.println(this.db_url);
        System.out.println(this.user);
        System.out.println(this.pwd);
    }

    public void setQuery(String query) {
        this.query = query;
        System.out.println(this.query);
    }

    public Connection connect() {
        // Open a connection
        if (conn == null) {
            try {
                Class.forName(this.driver);
                this.conn = DriverManager.getConnection(this.db_url, this.user, this.pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Connexion DB ok");
        return conn;
    }

    public ResultSet requete(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                                            ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        resultReq = render(rs);
        return rs;
    }

//    public String[] render(ResultSet rs) {
//        try {
//            while (rs.next()) {
//                // Retrieve by column name
//                System.out.println("Nom du visiteur : " + rs.getString("vis_nom"));
//                System.out.println("prenom du visiteur : " + rs.getString("vis_prenom"));
//                System.out.println();
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//            return resultReq;
//        }
//    }
    public void test()
    {
        // sert à tester
    }

}
