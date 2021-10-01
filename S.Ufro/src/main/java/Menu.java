import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        startProgram();
    }
    public static void startProgram() throws IOException {
        int option = 0;
        do{
            System.out.println("Bienvenido.");
            showMenu();
            option = getMenuOption();
            validateMenu(option);
        }while(option == 1 || option == 0);
    }
    public static void showMenu() {
        System.out.println("-------------");
        System.out.println("[1] Nueva Partida.");
        System.out.println("[2] Cargar Partida.");
        System.out.println("[0] Salir (S/N)");
    }
    public static String getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }
    public static int getMenuOption() {
        while (true) {
            String validacion = "012";
            String input = getInput("Seleccione una opción:");
            if (validacion.indexOf(input) >= 0) {
                int option = Integer.parseInt(input);
                if (-1 < option && option < 5) {
                    return option;
                }
            }
            else {
                System.out.println("Opción inválida");
            }
        }
    }
    public static void validateMenu(int option) throws IOException {
        switch (option) {
            case 1:
                System.out.println("En desarrollo, favor testear usuarios ya creados");
                System.out.println("Para hacerlo ejecutar main nuevamente");
                System.out.println("A continuacion se encuentra una lista de usuarios");
                System.out.println("user1,pass1");
                System.out.println("user2,pass2");
                System.out.println("user3,pass3");
                System.out.println("user4,pass4");
                System.out.println("user5,pass5");
                System.out.println("user6,pass6");
                System.out.println("user7,pass7");
                break;
            case 2:
                Login.LoginCoso();
                break;
            case 0:
                salir();
                break;
        }
    }
    public static void salir(){
        String respuesta = getInput("Desea salir del programa? S/N");
        respuesta = respuesta.toLowerCase();
        if(respuesta.contains("s")){
            System.exit(0);
        }
        else if (respuesta.contains("n")){
            System.out.println("");
        }
    }

}
