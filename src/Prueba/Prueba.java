// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package Prueba;

import dominio.Sistema;
import interfaz.VentanaInicio;

public class Prueba {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        VentanaInicio ventana = new VentanaInicio(sistema);
        ventana.setVisible(true);
    }
}
