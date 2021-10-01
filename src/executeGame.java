import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class executeGame {
    executeGame(String[] array, int posicion,ArrayList<String> arraylist) throws IOException {
        displayText(readHistoria(),array,Integer.parseInt(array[1]),posicion,arraylist);
    }
    public static void displayText(ArrayList<String> list, String[] array, int linea, int posicion,
                                       ArrayList<String> arraylist) throws IOException {
        ArrayList<String> historiaList = new ArrayList<>(list);
        for (int i = linea; i < historiaList.size() - 15; i++) {
            System.out.println(historiaList.get(i));
        }
        linea = 4;
        userInput();
        saveData(progresoUpdate(statUpdate(array,linea)),posicion,arraylist); //

        for (int i = linea; i < historiaList.size() - 8; i++) {
            System.out.println(historiaList.get(i));
        }
        linea = 11;
        userInput();
        saveData(progresoUpdate(statUpdate(array,linea)),posicion,arraylist);

        for (int i = linea; i < historiaList.size() - 3; i++) {
            System.out.println(historiaList.get(i));
        }
        linea = 16;
        userInput();
        saveData(progresoUpdate(statUpdate(array,linea)),posicion,arraylist);

        for (int i = linea; i < historiaList.size(); i++) {
            System.out.println(historiaList.get(i));
        }
        userInput();
        saveData(progresoUpdate(statUpdateFinal(array)),posicion,arraylist);
        System.out.println("Final del test recorrido");
    }
    //Tema presentacion, no estamos conformes con esto y queremos implementar una mejor solucion
    public static int userInput() {
        while (true) {
            String validacion = "123";
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
    public static String getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }
    public static ArrayList<String> readHistoria() {
        String line=null;
        ArrayList<String> lines = new ArrayList<>();
        try {
            File archivo = new File("C:\\Users\\Jota\\IdeaProjects\\S.Ufro\\partidas guardadas\\testHistoria.txt");
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
    public static String[] statUpdate(String[] asd,int linea){
        var v0 = asd[0];
        var v1 = Integer.parseInt(asd[1])+linea;
        var v2 = Integer.parseInt(asd[2])+20;
        var v3 = Integer.parseInt(asd[3])+10;
        var v4 = Integer.parseInt(asd[4])+5;
        String [] statUpdated = {v0, String.valueOf(v1), String.valueOf(v2), String.valueOf(v3), String.valueOf(v4)};
        return statUpdated;
    }
    //cuando desarrollemos los contenidos del juego se le entregara por parámetro el Integer destinado
    //a actualizar cada estadística de la siguiente manera
    //public static String[] statUpdate(String[] asd,int a, int b,int c){...}
    public static String[] statUpdateFinal(String[] asd){
        var v0 = asd[0];
        var v1 = 0;
        var v2 = Integer.parseInt(asd[2])+20;
        var v3 = Integer.parseInt(asd[3])+10;
        var v4 = Integer.parseInt(asd[4])+5;
        String [] statUpdated = {v0, String.valueOf(v1), String.valueOf(v2), String.valueOf(v3), String.valueOf(v4)};
        return statUpdated;
    }
    public static String progresoUpdate(String[] array) {
        StringBuffer sb = new StringBuffer();
        String str="";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(array[i]);
            } else {
                sb.append(array[i] + ",");
            }
            str = sb.toString();
        }
        return str;
    }
    public static void saveData(String nuevaLinea, int posicion,ArrayList<String> stats){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero = new FileWriter("C:\\Users\\Jota\\IdeaProjects\\S.Ufro\\partidas guardadas\\progreso.txt");
            escritor = new PrintWriter(fichero);
            escritor.flush();
            String[] split = stats.toArray(new String[0]);
            split[posicion] = nuevaLinea;
            for(int x = 0; x < split.length; x++){
                escritor.write(split[x]);
                escritor.println();
            }
            escritor.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de texto: "+e.getMessage());
        } finally {
            if(fichero != null){
                try {
                    fichero.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar archivo de texto: "+e.getMessage());
                }
            }
        }
    }
}
