// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.Serializable;

public abstract class Persona implements Serializable{
    //Atributos
    private int ci;
    private String nombre;
    private int telefono;
    
    //Constructores
    public Persona(int unaCi, String unNombre, int unTelefono) {
        this.setCi(unaCi);
        this.setNombre(unNombre);
        this.setTelefono(unTelefono);
    }
    
    public Persona() {
        this.setCi(1234567);
        this.setNombre("Juan Pérez");
        this.setTelefono(12345678);
    }

    //Setters
    public void setCi(int unaCI) {
        ci = unaCI;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public void setTelefono(int unTelefono) {
        telefono = unTelefono;
    }

    //Getters
    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }
    
    //Metodo toString()
    @Override
    public String toString() {
        return this.getNombre();
    }
    
    //Metodo equals()
    @Override
    public boolean equals(Object obj) {
        return this.getCi() == ((Persona)obj).getCi();
    }
}
