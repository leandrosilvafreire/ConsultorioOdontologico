/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.controle;

import br.com.consultorio.entity.Cliente;
import br.com.consultorio.service.ClienteServico;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Leandro
 */
@Named
@SessionScoped
public class ClienteControle extends BasicoControle implements java.io.Serializable{
    
    @EJB
    private ClienteServico clienteServico;
    
    private List<Cliente> clientes;
    private Cliente selectedCliente;
    private String localizar;

    public String doLocalizar(){
        cleanCache();
        clientes = clienteServico.getClienteByName(localizar);
        return "/restrito/clientes.faces";
    }
    
    private void cleanCache(){
        clientes = null;
        setSelectedCliente(new Cliente());
    }
    
    public String getUltimoAtendimento(Integer idOfCustomer){
        Date toReturn = clienteServico.getUltimoAtendimento(idOfCustomer);
        if(toReturn==null){
            return "Nunca.";
        }
        return getSdf().format(toReturn);
    }
    
    public int getClientesCount(){
        return  clienteServico.getClientesCount();
    }
    
    public String doStartAddCliente(){
        cleanCache();
        return "/restrito/addCliente";
    }
    
    
    
    
    
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    
    
    
    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public String getLocalizar() {
        return localizar;
    }

    public void setLocalizar(String localizar) {
        this.localizar = localizar;
    }
    
    
    
}
