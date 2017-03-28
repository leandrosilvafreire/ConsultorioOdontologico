/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.controle;

import br.com.consultorio.entity.Cliente;
import br.com.consultorio.service.ClienteServico;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Dyego Souza do Carmo
 * @version 1.0
 * @since 08/2014
 */
@Named
@SessionScoped
public class ClienteControle extends BasicoControle implements java.io.Serializable {

    @EJB
    private ClienteServico clienteService;

    private List<Cliente> clientes;
    private Cliente selectedCliente;
    private String localizar;

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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public String doLocalizar() {
        cleanCache();
        clientes = clienteService.getClienteByName(localizar);
        return "/restrito/clientes.faces";
    }

    private void cleanCache() {
        clientes = new LinkedList<>();
        setSelectedCliente(new Cliente());
    }

    public int getClientesCount() {
        return clienteService.getClientesCount();
    }

    public String getUltimoAtendimento(Integer idOfCustomer) {
        Date toReturn = clienteService.getUltimoAtendimento(idOfCustomer);
        if (toReturn == null) {
            return "Nunca";
        }
        return getSdf().format(toReturn);
    }

    public String doStartAddCliente() {
        cleanCache();
        return "/restrito/addCliente.faces";
    }

    public String doStartAlterar() {
        return "/restrito/editCliente.faces";
    }

    public String doFinishAlterar() {
        if (existsViolationsForJSF(getSelectedCliente())) {
            return "/restrito/editCliente.faces";
        }
        clienteService.setCliente(getSelectedCliente());
        clienteService.refreshCustomer(getSelectedCliente());
        setSelectedCliente(null);
        cleanCache();
        doLocalizar();
        return "/restrito/clientes.faces";
    }

    public String doFinishAddCliente() {
        if (existsViolationsForJSF(getSelectedCliente())) {
            return "/restrito/addCliente.faces";
        }
        Cliente cus = clienteService.addCliente(selectedCliente);
        cleanCache();
        getClientes().add(cus);
        setLocalizar(cus.getClinome());
        return "/restrito/clientes.faces";
    }
    
    public String doFinishExcluir(){
        clienteService.removeCliente(selectedCliente);
        getClientes().remove(getSelectedCliente());
        return "/restrito/clientes.faces";
    }
    
    
    
}
