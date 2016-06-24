/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.repositorio.AnamneseRepositorio;
import br.com.consultorioee.entity.Anamnese;
import br.com.consultorioee.entity.Cliente;
import br.com.consultorioee.entity.Orcamento;
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
public class AnamneseServico extends BasicoServico{
    
     private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private AnamneseRepositorio anamneseRepositorio;
    
    @PostActivate
    @PostConstruct
    private void postConstruct(){
            anamneseRepositorio = new AnamneseRepositorio(em);
        
    }
    
    public Anamnese getAnamnese(Integer idOfAnamnese){
        return anamneseRepositorio.getAnamnese(idOfAnamnese);
    }
    
    public Anamnese addAnamnese(Anamnese anamnese){
        return anamneseRepositorio.addAnamnese(anamnese);
    }
    
    public Anamnese setAnamnese(Anamnese anamnese){
        return anamneseRepositorio.setAnamnese(anamnese);
    }
    
    public void removeAnamnese(Anamnese anamnese){
        anamneseRepositorio.removeAnamnese(anamnese);
    }
    
    public List<Anamnese> getAnamneseByCliente(Cliente cliente){
        return anamneseRepositorio.getAnamnesesByCliente(cliente);
        
    }
    
    public List<Anamnese> getAnamneseByOrcamento(Orcamento orcamento){
        return anamneseRepositorio.getAnamnesesByOrcamento(orcamento);
    }
        
       
}
