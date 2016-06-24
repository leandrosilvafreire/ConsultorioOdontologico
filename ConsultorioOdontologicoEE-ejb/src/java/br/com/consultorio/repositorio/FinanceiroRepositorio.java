/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import br.com.consultorioee.entity.Cliente;
import br.com.consultorioee.entity.Parcela;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class FinanceiroRepositorio extends BasicoRepositorio{

    private static final long serialVersionUID = 1L;
    
    public FinanceiroRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Parcela getParcela(int idParcela){
        return getEntity(Parcela.class, idParcela);
    }
    
    public Parcela setParcela(Parcela par){
        return setEntity(Parcela.class, par);
    }
    
    public Parcela addParcela(Parcela par){
        return addEntity(Parcela.class, par);
    }
    
    public void removeParcela(Parcela par){
        removeEntity(par);
    }
    
    public List<Parcela> getParcelasOfOrcamento(int idOfOrcamento){
        return getPureList(Parcela.class,"select par from Parcela par where par.parorcamento.parid = ?1", idOfOrcamento);
        
    }
    
    public List<Parcela> getParcelasOfOrcamentoEmAberto(int idOfOrcamento){
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.parid = ?1 and par.parpago = ?2", idOfOrcamento, Boolean.FALSE);
        
        
    }
    
    public List<Parcela> getParcelasOfOrcamentoPagas(int idOfOrcamento){
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.parid = ?1 and par.parpago = ?2", idOfOrcamento, Boolean.TRUE);
    }
    
    public List<Parcela> getParcelasOfCliente(int idOfCliente){
        return getPureList(Parcela.class, "select par from Parcela par where par.parorcamento.orccliente.cliid = ?1", idOfCliente);
        
    }
    
    public List<Parcela> getParcelasOfClienteEmAberto(int idOfCliente){
        return getPureList(Parcela.class, "select par from Parcela par where par.parorcamento.orccliente.cliid = ?1 and par.parpago = ?2", idOfCliente, Boolean.FALSE);
    }
    
    public List<Parcela> getParcelasOfClientePagas(int idOfCliente){
        return getPureList(Parcela.class, "select par from Parcela par where par.parorcamento.orccliente.cliid = ?1 and par.parpago = ?2", idOfCliente, Boolean.TRUE);
    }
    
    public Parcela setPagamentoParcela(int idOfParcela){
        Parcela par = getParcela(idOfParcela);
        par.setParpago(true);
        par = setParcela(par);
        return par;
    }
    
    
    
    
}
