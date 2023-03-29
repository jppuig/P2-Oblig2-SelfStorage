// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.Serializable;

public class Deposito implements Serializable {
    //Atributos
    private int idDeposito;
    private int tamano;
    private boolean conEstantes;
    private boolean refrigerado;
    private boolean contratado;
    
    //Constructores
    public Deposito(int unIdDeposito,int unTamano, boolean esConEstantes, boolean esRefrigerado){
        this.setIdDeposito(unIdDeposito);
        this.setTamano(unTamano);
        this.setConEstantes(esConEstantes);
        this.setRefrigerado(esRefrigerado);
        this.setContratado(false);
    }
    
    public Deposito(){
        //this.setIdDeposito();
        this.setTamano(1);
        this.setConEstantes(false);
        this.setRefrigerado(false);
        this.setContratado(false);
    }

    //Setters
    public void setIdDeposito(int unIdDeposito) {
        idDeposito = unIdDeposito;
    }

    public void setTamano(int unTamano) {
        tamano = unTamano;
    }

    public void setConEstantes(boolean esConEstantes) {
        conEstantes = esConEstantes;
    }

    public void setRefrigerado(boolean esRefrigerado) {
        refrigerado = esRefrigerado;
    }

    public void setContratado(boolean esContratado) {
        contratado = esContratado;
    }

    //Getters
    public int getIdDeposito() {
        return idDeposito;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean getConEstantes() {
        return conEstantes;
    }

    public boolean getRefrigerado() {
        return refrigerado;
    }

    public boolean getContratado() {
        return contratado;
    }
    
    //Metodo toString()
    @Override
    public String toString() {
        String ref = "Refrigerado ";
        String est = "Estantes";
        if (!this.getRefrigerado()) {
            ref = "No " + ref;
        }
        if (this.getConEstantes()) {
            est = "Con " + est;
        } else {
            est = "Sin " + est;
        }
        
        return "Num: " + this.getIdDeposito() + " (" + this.getTamano() + " m2) " + ref + est;
    }
    
    //Metodo equals()
    @Override
    public boolean equals(Object obj) {
        return this.getIdDeposito() == ((Deposito)obj).getIdDeposito();
    }
}
