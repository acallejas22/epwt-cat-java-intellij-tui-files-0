import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws Exception {

        // Crear un fitxer amb la classe File
        // el nom del fitxer serà testfile.html
        File file = new File("testfile.html");

        String str = urlReader("http://inslaguineueta.cat");

        // Cridar la funció perquè guardi str al fitxer
        saveToFile(str, file, false);

        // Llegir el contingut del fitxer i imprimir-lo per pantalla.
        String fileContent = readFromFile(file);
        System.out.println(fileContent);
    }

    static String readFromFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        return sb.toString();
    }

    static void saveToFile(String str, File file, boolean append)
            throws IOException {
        FileWriter fileWriter = new FileWriter(file, append);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(str);
        bufferedWriter.close();
    }

    public static String urlReader(String url) throws Exception {
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            sb.append(inputLine);
        in.close();
        return sb.toString();
    }
}
