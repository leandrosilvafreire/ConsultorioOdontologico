/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import br.com.consultorioee.entity.Cliente;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class ClienteRepositorio extends BasicoRepositorio{

    private static final long serialVersionUID = 1L;
    
    public ClienteRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Cliente getCliente(int idOfCliente){
        return getEntity(Cliente.class, idOfCliente);
    }
    
    public Cliente setCliente(Cliente cliente){
        return setEntity(Cliente.class, cliente);
    }
    
    public Cliente addCliente(Cliente cliente){
        return addEntity(Cliente.class, cliente);
    }
    
    public void removeCliente(Cliente cliente){
        removeEntity(cliente);
    }
    
    public List<Cliente> getClienteByName(String name){
        
        return getPureList(Cliente.class, "select cli from Cliente cli where cli.clinome like ?1", name+"%");
        
    }
    
    public List<Cliente> getClienteToCall(int month, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, (month-1));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dataInicial = cal.getTime();
        
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        Date dataFinal = cal.getTime();
        return getPureList(Cliente.class, "select orc.orccliente from Orcamento orc where orc.orcdata >= ?1 and orc.orcdata <=2", dataInicial, dataFinal);
    }
    
    public List<Cliente> getClientesComPagamentoEmAberto(int idOfCliente){
        return getPureList(Cliente.class, "select par.parorcamento.orccliente from Parcela par where par.parpago = ?1", idOfCliente,Boolean.FALSE);
    }
}
