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

package br.com.consultorio.repositorio;

import br.com.consultorio.entity.Usuario;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class UsuarioRepositorio extends BasicoRepositorio {

    private static final long serialVersionUID = 1L;

    public UsuarioRepositorio(EntityManager entityManager) {
        super(entityManager);
    }

    public Usuario getUsuario(int id) {
        return getEntity(Usuario.class,id);
    }
    
    public Usuario setUsuario(Usuario usuario) {
        return setEntity(Usuario.class, usuario);
    }
    
    public void removeUsuario(Usuario usuario) {
        removeEntity(usuario);
    }
    
    public Usuario addUsuario(Usuario usuario) {
        usuario.setUspassword(getMd5(usuario.getUspassword()));
        addEntity(Usuario.class, usuario);
        return usuario;
    }

    public Usuario getUserByLoginPassword(String login, String password) {
        return getPurePojo(Usuario.class, "select usr from Usuario usr where usr.usulogin = ?1 and usr.uspassword = ?2", login, getMd5(password));
    }

    public List<Usuario> getUsuarios() {
        return getPureList(Usuario.class, "select usr from Usuario usr");
    }
    
    public List<Usuario> getUsuariosByName(String name) {
        return getPureList(Usuario.class,"select usr from Usuario usr where usr.usunome like ?1",name+"%");
    }
    
    public void setPassword(String newPassword,int idOfUser) {
        String np = getMd5(newPassword);
        Usuario usr = getUsuario(idOfUser);
        usr.setUspassword(np);
        setUsuario(usr);
    }
    
    private String getMd5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return digest;
    }

}
