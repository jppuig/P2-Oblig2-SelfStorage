// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;


public class ArchivoGrabacion {
    private Formatter out;
    
    public ArchivoGrabacion(String unArchivo) {
        try {
            FileWriter f = new FileWriter(unArchivo);
            out = new Formatter(f);
        } catch (IOException ex) {
            System.out.println("Error en el archivo");
        }
    }
    
    public void grabarLinea(String unaLinea) {
        out.format("%s%n", unaLinea);
    }
    
    public void cerrar() {
        out.close();
    }

}
