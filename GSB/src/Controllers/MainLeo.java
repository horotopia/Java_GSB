package Controllers;

import Models.Connect;

public class MainLeo {

    private Connect con;

    public MainLeo()
    {
        System.out.println("Leo et les bas");
        con = new Connect();
        con.test();
    }
}
