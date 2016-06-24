/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.repositorio.ClienteRepositorio;
import br.com.consultorioee.entity.Cliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leandro
 */
@Stateless
@LocalBean
public class ClienteServico extends BasicoServico{
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager em;
    private ClienteRepositorio clienteRepositorio;
    
    @PostActivate
    @PostConstruct
    private void postConstruct(){
        
        clienteRepositorio = new ClienteRepositorio(em);
    }
    
    public Cliente addCliente(Cliente cliente){
        return clienteRepositorio.addCliente(cliente);
    }
    
    public Cliente setCliente(Cliente cliente){
        return clienteRepositorio.setCliente(cliente);
    }
    
    public void removeCliente(Cliente cliente){
        clienteRepositorio.removeCliente(cliente);
    }
    
    public Cliente getCliente(int idOfCliente){
        return clienteRepositorio.getCliente(idOfCliente);
    }
    
    public  List<Cliente> getClienteByName(String nameOfCliente){
        return clienteRepositorio.getClienteByName(nameOfCliente);
    }
    
    public List<Cliente> getClienteTotal(int month, int year){
        return clienteRepositorio.getClienteToCall(month, year);
    }
    
    public List<Cliente> getClienteComPagamentoEmAberto(int idOfCliente){
        return clienteRepositorio.getClientesComPagamentoEmAberto(idOfCliente);
    }
    
    
    
    

    
    
}
