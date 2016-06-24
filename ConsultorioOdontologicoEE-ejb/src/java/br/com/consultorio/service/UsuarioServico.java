/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.service;

import br.com.consultorio.repositorio.UsuarioRepositorio;
import br.com.consultorioee.entity.Usuario;
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
//O Serviço são componentes instalados no servidor
@Stateless//uma forma de vc instalar um componente no servidor, ele é um componente de negócio
@LocalBean
public class UsuarioServico extends BasicoServico{
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager em;
    private UsuarioRepositorio usuarioRepositorio;
    
    @PostConstruct
    @PostActivate
    private void postConstruct(){
        
        usuarioRepositorio = new UsuarioRepositorio(em);
        
    }
    
    public UsuarioServico(){
    }
    
    public Usuario getUsuario(int id){
        return usuarioRepositorio.getUsuario(id);
    }
    
    public  Usuario setUsuario(Usuario usuario){
        return usuarioRepositorio.setUsuario(usuario);
    }
    
    public void removeUsuario(Usuario usuario){
        usuarioRepositorio.removeUsuario(usuario);
    }
    
    public void setPassword(int idofUsuario, String password){
        usuarioRepositorio.setPassword(password, idofUsuario);
    }
    
    public Usuario addUsuario(Usuario usuario){
        return usuarioRepositorio.addUsuario(usuario);
    }
    
    public Usuario getUserByLoginPassword(String login, String password){
        return usuarioRepositorio.getUsuarioByLoginPassword(login, password);
    }
    
    public List<Usuario> getUsuarios(){
        return usuarioRepositorio.getUsuario();
    }

    
    
    
  }
