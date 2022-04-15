package Content;

public class Main {

    private static MainLeo leo;
    private static MainStef stef;
    private static MainLau lau;
    private static MainXav xav;
    public static Multi test;
    public static Multi test2;
    private static Login login;
    private static Menu menu;

    public static void main(String[] args) {

        xav = new MainXav();
        lau = new MainLau();
        stef = new MainStef();
        leo = new MainLeo();

//        test = new Multi();
//        test2 = new Multi();

        login = new Login();



    }
}
