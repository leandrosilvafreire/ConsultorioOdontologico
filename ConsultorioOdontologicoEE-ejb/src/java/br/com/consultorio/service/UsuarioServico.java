/*
 * Copyright (C) 2014 Leandro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.com.consultorio.service;


import br.com.consultorio.entity.Usuario;
import br.com.consultorio.repositorio.UsuarioRepositorio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leandro
 * @version 1.0
 * @since 05/2014
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioServico extends BasicoServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private UsuarioRepositorio usuarioRepositorio;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        usuarioRepositorio = new UsuarioRepositorio(em);
    }

    public UsuarioServico() {
    
    }
    
    public Usuario getUsuario(int id) {
        return usuarioRepositorio.getUsuario(id);
    }
    
    //Altera um usuario e verifica se não fro dentista nem usuario não altera
     public Usuario setUsuario(Usuario usuario) throws AcessoInvalidoException {
        if (!usuario.getUsuadministrador() && !usuario.getUsudentista()) {
            throw new AcessoInvalidoException("O usuário atual não possui um acesso válido.");
        }
        return usuarioRepositorio.setUsuario(usuario);
    }

    
    public void removeUsuario(Usuario usuario) {
        usuarioRepositorio.removeUsuario(usuario);
    }
    
    public void setPassword(int ifOfUser,String password) {
        usuarioRepositorio.setPassword(password, ifOfUser);
    }
    
    
    //Adiciona um novo usuario e faz uma vrerificação se não for dentista nem administrador chama o cros campo
    public Usuario addUsuario(Usuario usuario) throws AcessoInvalidoException {
        if (!usuario.getUsuadministrador() && !usuario.getUsudentista()) {
            throw new AcessoInvalidoException("O usuário atual não possui um acesso válido.");
        }
        return usuarioRepositorio.addUsuario(usuario);
    }
    
    
    public List<Usuario> getUserByName(String nome){
        return usuarioRepositorio.getUsuariosByName(nome);
    }
    
    public Usuario getUserByLoginPassword(String login,String password) {
        try {
            return usuarioRepositorio.getUserByLoginPassword(login, password);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Usuario> getUsers() {
        return usuarioRepositorio.getUsuarios();
    }
    
}
