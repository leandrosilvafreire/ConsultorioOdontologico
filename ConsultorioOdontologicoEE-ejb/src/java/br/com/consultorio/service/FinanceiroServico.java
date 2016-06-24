/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.repositorio.FinanceiroRepositorio;
import br.com.consultorioee.entity.Parcela;
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
public class FinanceiroServico extends BasicoServico{
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager em;
    private FinanceiroRepositorio financeiroRepositorio;
    
    @PostActivate
    @PostConstruct
    private void postConstruct(){
        financeiroRepositorio = new FinanceiroRepositorio(em);
    }
    
    public Parcela getParcela(int idOfParcela){
        return financeiroRepositorio.getParcela(idOfParcela);
    }
    
    public Parcela setParcela(Parcela parcela){
        return financeiroRepositorio.setParcela(parcela);
    }
    
    public Parcela addParcela(Parcela parcela){
        return financeiroRepositorio.addParcela(parcela);
    }
    
    public void removeParcela(Parcela parcela){
        financeiroRepositorio.removeParcela(parcela);
    }
    
    public List<Parcela> getParcelaOrcamento(int idOfOrcamento){
        return financeiroRepositorio.getParcelasOfOrcamento(idOfOrcamento);
        
    }
    
    public List<Parcela> getParcelaOrcamentoAberto(int idOfParcelaOrcamentoAberto){
        return financeiroRepositorio.getParcelasOfOrcamentoEmAberto(idOfParcelaOrcamentoAberto);
    }
    
    public List<Parcela> getParcelaOrcamentoPago(int idOfParcelaOrcamentoPago){
        return financeiroRepositorio.getParcelasOfClientePagas(idOfParcelaOrcamentoPago);
    }
    
    public List<Parcela> getParcelaCliente(int idOfParcelaCliente){
        return financeiroRepositorio.getParcelasOfCliente(idOfParcelaCliente);
    }
    
    public List<Parcela> getParcelaClienteAberta(int idOfParcelaClienteAberta){
        return financeiroRepositorio.getParcelasOfClienteEmAberto(idOfParcelaClienteAberta);
    }
    
    public List<Parcela> getParcelaClientePago(int idOfParcelaClientePago){
        return financeiroRepositorio.getParcelasOfOrcamentoPagas(idOfParcelaClientePago);
    }
    
    public Parcela  setPagamentoParcela(int idOfPagamentoParcela){
        return financeiroRepositorio.setPagamentoParcela(idOfPagamentoParcela);
    }
    
    
    
}
