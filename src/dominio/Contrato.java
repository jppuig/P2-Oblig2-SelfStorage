// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.Serializable;

public class Contrato implements Serializable {
    //Atributos
    private static int idContratosTotal = 1;
    private Cliente cliente;
    private Empleado empleado;
    private Deposito deposito;
    private String detalle;
    private int idContrato;
    
    //Constructores
    public Contrato() {
        this.setCliente(new Cliente());
        this.setEmpleado(new Empleado());
        this.setDeposito(new Deposito());
        this.setDetalle("Sin detalle");
        this.setIdContrato(this.getIdContratosTotal());
        this.setIdContratosTotal(this.getIdContratosTotal()+1);
    }
    
    public Contrato(Cliente unCliente, Empleado unEmpleado, Deposito unDeposito, String unDetalle) {
        this.setCliente(unCliente);
        this.setEmpleado(unEmpleado);
        this.setDeposito(unDeposito);
        this.setDetalle(unDetalle);
        this.setIdContrato(this.getIdContratosTotal());
        this.setIdContratosTotal(this.getIdContratosTotal()+1);
    }

    //Setters
    public static void setIdContratosTotal(int unIdContratosTotal) {
        Contrato.idContratosTotal = unIdContratosTotal;
    }

    public void setCliente(Cliente unCliente) {
        cliente = unCliente;
    }

    public void setEmpleado(Empleado unEmpleado) {
        empleado = unEmpleado;
    }

    public void setDeposito(Deposito unDeposito) {
        deposito = unDeposito;
    }

    public void setDetalle(String unDetalle) {
        detalle = unDetalle;
    }
    
    public void setIdContrato(int unIdContrato) {
        idContrato = unIdContrato;
    }

    //Getters
    public static int getIdContratosTotal() {
        return idContratosTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public String getDetalle() {
        return detalle;
    }
    
    public int getIdContrato() {
        return idContrato;
    }
    
    //Metodo toString()
    @Override
    public String toString() {
        return this.getIdContrato() + " - " + this.getCliente();
    }
    
    //Metodo equals()
    @Override
    public boolean equals(Object obj) {
        return this.getIdContrato() == ((Contrato)obj).getIdContrato();
    }
}
