// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {
    //Atributos
    private String direccion;
    private int anoIngreso;
    
    //Constructores
    public Empleado(int unaCi, String unNombre, int unTelefono, String unaDireccion, int unAnoIngreso){
        super(unaCi, unNombre, unTelefono);
        this.setDireccion(unaDireccion);
        this.setAnoIngreso(unAnoIngreso);
    }
    
    public Empleado(){
        this.setDireccion("Mercedes esq. Cuareim");
        this.setAnoIngreso(2022);
    }
    
    //Setters
    public void setDireccion(String unaDireccion){
         direccion = unaDireccion;
    }
    
    public void setAnoIngreso(int unaFecha){
         anoIngreso = unaFecha;
    }
    
    //Getters
    public String getDireccion(){
        return direccion;
    }
    
    
    public int getAnoIngreso(){
        return anoIngreso;
    }
}
