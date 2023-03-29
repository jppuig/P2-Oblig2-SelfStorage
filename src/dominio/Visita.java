// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.Serializable;

public class Visita implements Serializable {
    //Atributos
    private Cliente cliente;
    private Empleado empleado;
    private Contrato contrato;
    private int dia;
    private int mes;
    
    //Constructores
    public Visita (){
        this.setCliente(new Cliente());
        this.setEmpleado(new Empleado());
        this.setContrato(new Contrato());
        this.setDia(01);
        this.setMes(01);
    }
    
    public Visita(Cliente unCliente, Empleado unEmpleado, Contrato unContrato, int unDia, int unMes) {
        this.setCliente(unCliente);
        this.setEmpleado(unEmpleado);
        this.setContrato(unContrato);
        this.setDia(unDia);
        this.setMes(unMes);
    }
    
    //Setters
    public void setCliente(Cliente unCliente) {
        cliente = unCliente;
    }

    public void setEmpleado(Empleado unEmpleado) {
        empleado = unEmpleado;
    }

    public void setContrato(Contrato unContrato) {
        contrato = unContrato;
    }

    public void setDia(int unDia) {
        dia = unDia;
    }
    
    public void setMes(int unMes) {
        mes = unMes;
    }
    
    //Getters
    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    //Metodo toString()
    @Override
    public String toString() {
        return "Fecha de la visita: " + this.getDia() + "/" + this.getMes() +
                ". Cliente: " + this.getCliente() + ". Empleado: " + this.getEmpleado() + ".";
    }
    
}
