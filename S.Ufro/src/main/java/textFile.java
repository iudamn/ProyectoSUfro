import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class textFile {
    public static HashMap archivo() throws IOException {
        //Colocar dirección en la que se encontrará el archivo con usuarios y contraseñas.
        String filePath = "C:\\Users\\Jota\\IdeaProjects\\S.Ufro\\partidas guardadas\\IDPass.txt";
        //Inicializar HashMap que contendrá la información para despues verificarla
        HashMap<String, String> map = new HashMap();
        //Reader
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        reader.close();
        return map;
    }
}
