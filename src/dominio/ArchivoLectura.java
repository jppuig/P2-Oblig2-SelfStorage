// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    public ArchivoLectura(String unNombre) {
        try {
            in = new Scanner(Paths.get(unNombre));
        } catch (IOException ex) {
            System.out.println("Error no se puede leer el archivo");
        }
    }
    
    public boolean hayMasLineas() {
        boolean hay = false;
        linea = null;
        if (in.hasNext()){
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    
    public String linea() {
        return linea;
    }
    
    public void cerrar() {
        in.close();
    }
}
