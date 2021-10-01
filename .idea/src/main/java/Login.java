import java.io.IOException;

public class Login {
    public static void LoginCoso() throws IOException {
        textFile IDPass = new textFile();
        loginPage lp = new loginPage(IDPass.archivo());
    }
}
