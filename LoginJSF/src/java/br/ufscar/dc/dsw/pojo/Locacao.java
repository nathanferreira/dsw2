package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Locacao implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String ID;
    private String clienteEmail;
    private String locadoraEmail;
    private String rentDate;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Locadora locadora;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setlocadoraEmail(String locadoraEmail) {
        this.locadoraEmail = locadoraEmail;
    }

    public void setclienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getlocadoraEmail() {
        return locadoraEmail;
    }

    public String getclienteEmail() {
        return clienteEmail;
    }

    public String getRentDate() {
        return rentDate;
    }

}
