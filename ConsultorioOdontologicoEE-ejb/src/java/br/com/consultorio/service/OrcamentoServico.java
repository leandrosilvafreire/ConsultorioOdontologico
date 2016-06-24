/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.repositorio.OrcamentoRepositorio;
import br.com.consultorioee.entity.Orcamento;
import br.com.consultorioee.entity.Orcamentoitem;
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
public class OrcamentoServico extends BasicoServico{
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager em;
    private OrcamentoRepositorio orcamentoRepositorio;
    
    @PostActivate
    @PostConstruct
    private void postConstruct(){
        orcamentoRepositorio = new OrcamentoRepositorio(em);
        
    }
    public Orcamento addOrcamento(Orcamento orcamento){
        return orcamentoRepositorio.addOrcamento(orcamento);
    }
    
    public Orcamento setOrcamento(Orcamento orcamento){
        return orcamentoRepositorio.setOrcamento(orcamento);
    }
    
    public Orcamento getOrcamento(int idOfOrcamento){
        return orcamentoRepositorio.getOrcamento(idOfOrcamento);
    }
    
    public void removeOrcamento(Orcamento orcamento) {
            orcamentoRepositorio.removeOrcamento(orcamento);
    }
    
    public Orcamentoitem addItem(Orcamentoitem item){
        return orcamentoRepositorio.addItem(item);
    }
    
    public Orcamentoitem setItem(Orcamentoitem item){
        return orcamentoRepositorio.setItem(item);
    }
    
    public Orcamentoitem getItem(int ifOfItem){
        return orcamentoRepositorio.getItem(ifOfItem);
    }
    
    
    
    public List<Orcamento> getOrcamentos(int idOfCliente){
        return orcamentoRepositorio.getOrcamentos(idOfCliente);
    }
    
    public List<Orcamentoitem> getItens(int idOfOrcamento){
        return orcamentoRepositorio.getItens(idOfOrcamento);
    }
    
}
