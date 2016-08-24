/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import br.com.consultorio.entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class ServicoRepositorio extends BasicoRepositorio{
    
     private static final long serialVersionUID = 1L;

    public ServicoRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    //adicionar
    public Servico addServico(Servico servico){
        return addEntity(Servico.class, servico);
    }
    //atualizar
    public Servico setServico(Servico servico){
        return setEntity(Servico.class, servico);
    }
    
    //remover
    public void removeServico(Servico servico){
        removeEntity(servico);
    }
    
    //Consultar
    public Servico getServico(int idOfServico){
        return getEntity(Servico.class, idOfServico);
    }
    
    //lista os servicos
    public List<Servico> getServicos(){
        return getPureList(Servico.class, "select serv from Servico serv");
    }
    
     public List<Servico> getServicosByName(String name) {
        return getPureList(Servico.class, "select srv from Servico srv where srv.sernome like ?1", name + "%");
    }

    
}
