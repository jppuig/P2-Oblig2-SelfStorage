// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    //Atributos
    private String email;
    
    //Constructores
    public Cliente(int unaCi, String unNombre, int unTelefono, String unEmail) {
        super(unaCi, unNombre, unTelefono);
        this.setEmail(unEmail);
    }
    
    public Cliente() {
        this.setEmail("juanperez@gmail.com");
    }
    
    //Setters
    public void setEmail(String unMail){
         email = unMail;
    }
    
    //Getters
    public String getEmail(){
        return email;
    }
}
