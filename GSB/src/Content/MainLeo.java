package Content;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainLeo {

    private Connect con;
    private ResultSet rs;
    private String resultReq;
    private CptRendu CptRendu;

    public MainLeo() {

        con = new Connect();
        con.connect();
        rs = con.requete("SELECT LAB_NOM, LAB_CHEFVENTE FROM labo");
        try {
            while (rs.next()) {
                // Retrieve by column name

                System.out.println("Nom du labo : " + rs.getString("LAB_NOM"));
                System.out.println("Chef de vente : " + rs.getString("LAB_CHEFVENTE"));
                System.out.println();
                resultReq = resultReq+("Libellé : " + rs.getString("LAB_NOM")+"\n"+
                        "id : " + rs.getString("LAB_CHEFVENTE")+"\n\n");
            }
        }catch (SQLException e)
            {   e.printStackTrace();    }
    }
}
