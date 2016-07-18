/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import br.com.consultorio.entity.Anamnese;
import br.com.consultorio.entity.Cliente;
import br.com.consultorio.entity.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class AnamneseRepositorio extends BasicoRepositorio{

     private static final long serialVersionUID = 1L;
    
    public AnamneseRepositorio(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Anamnese getAnamnese(int idOfAnamnese){
        return getEntity(Anamnese.class, idOfAnamnese);
    }
    
    public Anamnese setAnamnese(Anamnese anamnese){
        return setEntity(Anamnese.class, anamnese);
        
    }
    
    public Anamnese addAnamnese(Anamnese anamnese){
        return addEntity(Anamnese.class, anamnese);
    }
    
    public void removeAnamnese(Anamnese anamnese){
        removeEntity(anamnese);
    }
    
    public List<Anamnese> getAnamnesesByCliente(Cliente cliente){
        return getPureList(Anamnese.class, "select anam from Anamnese anam where anam.anacliente.cliid = ?1", cliente.getCliid());
    }
    
    public  List<Anamnese> getAnamnesesByOrcamento(Orcamento orcamento){
        return getPureList(Anamnese.class, "select anam from Anamnese anam where anam.anaorcamento.orcid = ?1", orcamento.getOrcid());
    }
}
      
        
    
    
    

