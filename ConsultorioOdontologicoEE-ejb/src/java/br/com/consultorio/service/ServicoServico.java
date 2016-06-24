/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.repositorio.ServicoRepositorio;
import br.com.consultorio.repositorio.UsuarioRepositorio;
import br.com.consultorioee.entity.Servico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
@Stateless
@LocalBean
public class ServicoServico extends BasicoServico{
    
    private static final long serialVersionUID = 1L;
    
    private EntityManager em;
    private ServicoRepositorio servicoRepositorio;
    
    @PostConstruct
    @PostActivate
    private void postConstruct(){
       servicoRepositorio = new ServicoRepositorio(em);
    }
    
    public Servico addService(Servico servico){
        return servicoRepositorio.addServico(servico);
    }
    
    public Servico setService(Servico servico){
        return servicoRepositorio.setServico(servico);
    }
    
    public void removeService(Servico servico){
        servicoRepositorio.removeServico(servico);
    }
    
    public Servico getService(int idOfService){
        return servicoRepositorio.getServico(idOfService);
    }
    
    public List<Servico> getServices(){
        return servicoRepositorio.getServicos();
    }
    
    public List<Servico> getServiceByName(String name){
        return servicoRepositorio.getServicoByName(name);
    }
        
        
    
}
    
    
    

