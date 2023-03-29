// Juan Pedro Puig - 281088
// Nicolás Valsecchi - 192765

package dominio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema extends Observable  implements Serializable {
    //Atributos
    private ArrayList<Deposito> listaDepositos;    
    private ArrayList<Empleado> listaEmpleados;    
    private ArrayList<Cliente> listaClientes;    
    private ArrayList<Contrato> listaContratos;    
    private ArrayList<Visita> listaVisitas;
    boolean cargo;
    
    //Constructor
    public Sistema() {
        listaDepositos = new ArrayList<Deposito>();
        listaEmpleados = new ArrayList<Empleado>();
        listaClientes = new ArrayList<Cliente>();
        listaContratos = new ArrayList<Contrato>();
        listaVisitas = new ArrayList<Visita>();
    }
    
    // Setter
    public void setCargo(boolean seCargo) {
        cargo = seCargo;
    }

    // Getters
    public ArrayList<Deposito> getListaDepositos() {
        return listaDepositos;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Contrato> getListaContratos() {
        return listaContratos;
    }

    public ArrayList<Visita> getListaVisitas() {
        return listaVisitas;
    }
    
    public boolean getCargo() {
        return cargo;
    }    

    // Agregar
    public void agregarDeposito(Deposito unDeposito) {
        this.getListaDepositos().add(unDeposito);
        
        
        
        setChanged();
        notifyObservers();
    }
    
    public void agregarEmpleado(Empleado unEmpleado) {
        this.getListaEmpleados().add(unEmpleado);
        setChanged();
        notifyObservers();
    }
    
    public void agregarCliente(Cliente unCliente) {
        this.getListaClientes().add(unCliente);
        setChanged();
        notifyObservers();
    }
    
    public void agregarContrato(Contrato unContrato) {
        this.getListaContratos().add(unContrato);
        setChanged();
        notifyObservers();
    }
    
    public void agregarVisita(Visita unaVisita) {
        this.getListaVisitas().add(unaVisita);
        setChanged();
        notifyObservers();
    }
    
    // Eliminar
    public void eliminarDeposito(Deposito unDeposito) {
        this.getListaDepositos().remove(unDeposito);
        setChanged();
        notifyObservers();
    }
    
    public void eliminarEmpleado(Empleado unEmpleado) {
        this.getListaEmpleados().remove(unEmpleado);
        setChanged();
        notifyObservers();
    }
    
    public void eliminarCliente(Cliente unCliente) {
        this.getListaClientes().remove(unCliente);
        setChanged();
        notifyObservers();
    }
    
    public void eliminarContrato(Contrato unContrato) {
        this.getListaContratos().remove(unContrato);
        setChanged();
        notifyObservers();
    }
    
    public void eliminarVisita(Visita unaVisita) {
        this.getListaVisitas().remove(unaVisita);
        setChanged();
        notifyObservers();
    }
    
    //Filtra los contratos según características del depósito para agregar en la piechart
    public ArrayList<Contrato> filtrarContratosPorDepositos(boolean est, boolean ref){
        ArrayList<Contrato> retorno = new ArrayList<Contrato>();
   
        for (Contrato c: this.getListaContratos()){
            if((c.getDeposito().getConEstantes() == est) && (c.getDeposito().getRefrigerado() == ref))
                retorno.add(c);
        }
        return retorno;
    }
    
    //Devuelve lista con los contratos de un cliente
    public ArrayList<Contrato> obtenerContratosDelCliente(Cliente unCliente) {
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        
        if (unCliente != null) {
            for (Contrato c : this.getListaContratos()) {
                if (c.getCliente().equals(unCliente)) {
                    contratos.add(c);
                }
            }
        }
        
        return contratos;
    }
    
    //Método que retorna lista con los depositos que cumplen ciertas caracteristicas
    public ArrayList<Deposito> obtenerDepositosDisponibles(int est, int ref, int min, int max) {
        ArrayList<Deposito> depositos = new ArrayList<Deposito>();
        
        for (Deposito d : this.getListaDepositos()) {
            if (d.getTamano() <= max && d.getTamano() >= min && !d.getContratado()) {
                boolean ok = true;
                if (est != 0) {
                    if ((est < 0 && d.getConEstantes()) || (est > 0 && !d.getConEstantes())) {
                        ok = false;
                    }
                }
                if (ok && ref != 0) {
                    if ((ref < 0 && d.getRefrigerado()) || (ref > 0 && !d.getRefrigerado())) {
                        ok = false;
                    }
                }
                
                if (ok) {
                    depositos.add(d);
                }
            }
        }
        
        Collections.sort(depositos, new Comparator<Deposito>() {
            public int compare(Deposito d1, Deposito d2) {
                return d1.getIdDeposito() - d2.getIdDeposito();
            }
        });
        
        return depositos;
    }
    
    //Método para obtener deposito x su id
    public Deposito obtenerDepositoPorId(int unId){
        Deposito retorno = new Deposito();
        for (Deposito d : this.getListaDepositos()){
            if (d.getIdDeposito() == unId){
                retorno = d;
            }
        }
        return retorno;
    }
    
    //Método para obtener el contrato de un deposito
    public Contrato obtenerContratoPorDeposito(Deposito unDeposito){
        Contrato retorno = new Contrato();
        for (Contrato c : this.getListaContratos()){
            if (c.getDeposito().equals(unDeposito)){
                retorno = c;
            }
        }
        return retorno;
    }
    
    //Método devuelve true si existe el objeto pasado como argumento
    public boolean existe(ArrayList arr, Object obj) {
        boolean ex = false;

        for (Object o : arr) {
            if (obj.equals(o)) {
                ex = true;
            }
        }

        return ex;
    }
    
    //Devuelve una lista ordenada de las visitas de cierto contrato
    public ArrayList<Visita> ordenarVisitasPorFecha(Contrato unContrato) {
        ArrayList<Visita> visitas = new ArrayList<Visita>();
        
        for (Visita v : this.getListaVisitas()) {
            if (v.getContrato().equals(unContrato)) {
                visitas.add(v);
            }
        }
        
        Collections.sort(visitas, new Comparator<Visita>() {
            public int compare(Visita v1, Visita v2) {
                int dif = v1.getMes() - v2.getMes();
                if (dif == 0) {
                    dif = v1.getDia() - v2.getDia();
                }
                return dif;
            }
        });
        
        return visitas;
    } 
        
    //Método para cargar sistema anterior
    public Sistema cargarSistema(){
        Sistema sistema = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("datos.ser")));
            sistema = (Sistema)in.readObject();
            in.close();
            sistema.setCargo(true);
        }catch(Exception e){
            sistema = new Sistema();
            sistema.setCargo(false);
        }
        return sistema;
    }
    
    //Método para guardar el sistema
    public void guardarSistema(Sistema sistema){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("datos.ser")));
            out.writeObject(sistema);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
