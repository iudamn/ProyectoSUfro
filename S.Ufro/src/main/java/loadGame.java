import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadGame {
    String userID;
    loadGame(String userID) throws IOException {
        this.userID=userID;
        String[] array = StringtoArray(obtenerString(readStats(),userID));
        int posicion = obtenerPosicion(readStats(),userID);
        executeGame execute = new executeGame(array,posicion,readStats());
    }
    public static String obtenerString(ArrayList<String> progreso, String user) {
        String user1 ="";
        for ( int i=0; i <progreso.size()-1; i++) {
            if (progreso.get(i).contains(user)) {
                user1 = progreso.get(i);
            }
        }
        return user1;
    }
    public static int obtenerPosicion(ArrayList<String> progreso, String user) {
        String user1 ="";
        int posicion = 0;
        for ( int i=0; i <progreso.size()-1; i++) {
            if (progreso.get(i).contains(user)) {
                user1 = progreso.get(i);
                posicion = i;
            }
        }
        return posicion;
    }
    public static String[] StringtoArray(String a){
        return a.split(",");
    }
    public static ArrayList<String> readStats() {
        String line=null;
        ArrayList<String> lines = new ArrayList<>();
        try {
            File archivo = new File("C:\\Users\\Jota\\IdeaProjects\\S.Ufro\\partidas guardadas\\progreso.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, por favor contactar con administrador.");
        }
        return lines;
    }
}