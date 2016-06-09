/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import br.com.consultorioee.entity.Usuario;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class UsuarioRepositorio extends BasicoRepositorio{
    
     private static final long serialVersionUID = 1L;
    
    public UsuarioRepositorio(EntityManager entityManager){
        super(entityManager);
    }
    
    public Usuario getUsuario(int id){
        return getEntity(Usuario.class, id);
    }
    
    public Usuario setUsuario(Usuario usu){
        return setEntity(Usuario.class, usu);
    }
    
    public void removeUsuario(Usuario usu){
        removeEntity(usu);
    }
    
    public Usuario addUsuario(Usuario usu){
        usu.setUspassword(getMd5(usu.getUspassword()));
        addEntity(Usuario.class, usu);
        return usu;
    }
            
    
    public Usuario getUsuarioByLoginPassword(String login, String password){
        return getPuroPojo(Usuario.class, "select uso from Usuario uso where uso.uspassword = ?2", login, getMd5(password));
}
    
    public List<Usuario> getUsuario(){
        return getPureList(Usuario.class, "select usu from Usuario usuario");
    }
    
    //lista todos os usuarios pelo nome
    public List<Usuario> getUsuarioByName(String nome){
        return getPureList(Usuario.class, "select usu from Usuario usu where usu.usunome like?1",nome+"%");
    }
    
    //Nova senha
    public void setPassword(String newPassword, int idOfUser){
        String np = getMd5(newPassword);
        Usuario usu = getUsuario(idOfUser);
        usu.setUspassword(np);
        setUsuario(usu);
    }
    
    //função para criptografia da senha no login
    private String getMd5(String message){
        String digest = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2*hash.length);
            for(byte b : hash){
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return digest;
    }
    
    

    
    
  
    
    
    
   
    
}
