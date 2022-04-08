package Models;

import java.sql.*;

public class Connect
{

    private String driver;
    private String db_url;
    private String user;
    private String pwd;
    private String query;
    private String resultReq ="";

    public Connect()
    {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.db_url = "jdbc:mysql://localhost/gsb";
        this.user = "root";
        this.pwd = "root";
        this.query = "SELECT pra_nom, pra_prenom FROM visiteur";
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

    public void test()
    {
        this.setQuery("SELECT pra_nom, pra_prenom FROM visiteur");
        resultReq = this.requete(query);
        System.out.println(resultReq);
    }

    public String requete(String query)
    {
        // Open a connection
        try
        {
            Class.forName(this.driver);
            Connection conn = DriverManager.getConnection(this.db_url, this.user, this.pwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Extract data from result set
            while (rs.next())
            {
                // Retrieve by column name
                System.out.println("Libellé : " + rs.getString("libelle"));
                System.out.println("id : " + rs.getString("id"));
                System.out.println();
                resultReq = resultReq+("Libellé : " + rs.getString("libelle")+"\n"+
                        "id : " + rs.getString("id")+"\n\n");
            }
            return resultReq;
        }
        catch (SQLException e)
        {   return String.valueOf(e);  }
        catch (ClassNotFoundException e)
        {   return String.valueOf(e);  }
    }
}
