/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import br.com.consultorioee.entity.Orcamento;
import br.com.consultorioee.entity.Orcamentoitem;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class OrcamentoRepositorio extends BasicoRepositorio{

     private static final long serialVersionUID = 1L;
    
    public OrcamentoRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Orcamento getOrcamento(int idOfOrcamento){
        return getEntity(Orcamento.class, idOfOrcamento);
    }
    
    public Orcamento addOrcamento(Orcamento orc){
        return addEntity(Orcamento.class, orc);
    }
    
    public Orcamento setOrcamento(Orcamento orc){
        return setEntity(Orcamento.class, orc);
    }
    
    public void removeOrcamento(Orcamento orc){
        removeEntity(orc);
    }
    
    public List<Orcamentoitem> getItens(int idOrcamento){
        return getPureList(Orcamentoitem.class, "select ori from Orcamento ori where oi.oritorcamento.oritcid = ?1", idOrcamento);
        
    }
    
    public List<Orcamento> getOrcamentos(int idOfCliente){
        return getPureList(Orcamento.class, "select orc from Orcamento orc where orc.orccliente.cliid = ?1", idOfCliente);
        
    }
    
    public void removeItem(Orcamento ori){
        removeEntity(ori);
    }
    
    public Orcamentoitem addItem(Orcamentoitem ori){
        return addEntity(Orcamentoitem.class, ori);
    }
    
    public Orcamentoitem setItem(Orcamentoitem ori){
        return setEntity(Orcamentoitem.class, ori);
    }
    
    public Orcamentoitem getItem(int idofOri){
        return getEntity(Orcamentoitem.class, idofOri);
    }

    
    
    
   
    
}
