/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.controle;

import br.com.consultorio.entity.Usuario;
import br.com.consultorio.entity.validator.LoginPadrao;
import br.com.consultorio.service.AcessoInvalidoException;
import br.com.consultorio.service.UsuarioServico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Leandro
 * @version 1.0
 * @since 06/2014
 */
@Named
@SessionScoped
public class UsuarioControle extends BasicoControle implements java.io.Serializable {

    @EJB
    private UsuarioServico userService;
    private Usuario loggedUser;

    @NotNull(message = "Você deve especificar o usuário")
    @NotEmpty(message = "Você deve especificar o usuário")
    @LoginPadrao(message = "Este login não está dentro dos padrões estabelecidos")
    private String userName;
    @NotNull
    @NotEmpty(message = "Você precisa especificar uma senha")
    @Length(min = 3, message = "Sua senha deve conter no minimo 3 caracteres.")
    private String password;

    /*    @NotEmpty(message = "Você precisa especificar um nome válido")
     @NotNull(message = "Você precisa especificar um nome válido")
     @Length(min=3,message = "Você deve especificar um nome com mais de 3 letras.")*/
    private String localizar;
    private List<Usuario> usrFiltrado;

    private Usuario usuarioSelected;

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public String doLocalizar() {
        usrFiltrado = userService.getUserByName(getLocalizar());
        return "users.faces";
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }

    @PostConstruct
    public void postContrsuct() {
        System.out.println("[DevMedia] UserControl Started ! " + hashCode());
    }

    /**
     *
     * @return
     */
    public List<Usuario> getUsers() {
        return userService.getUsers();
    }

    public String doLogin() {
        loggedUser = null;
        loggedUser = userService.getUserByLoginPassword(userName, password);
        if (loggedUser == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario / Senha Inválidos", "Usuario / Senha Inválidos");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/login.faces";
        } else {
            return "/restrito/index.faces?faces-redirect=true";
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalizar() {
        return localizar;
    }

    public void setLocalizar(String localizar) {
        this.localizar = localizar;
    }

    public List<Usuario> getUsrFiltrado() {
        if (usrFiltrado == null) {
            return getUsers();
        }
        return usrFiltrado;
    }

    public void setUsrFiltrado(List<Usuario> usrFiltrado) {
        this.usrFiltrado = usrFiltrado;
    }

    public String doStartAddUsuario() {
        setUsuarioSelected(new Usuario());
        return "/restrito/addUsers.faces";
    }

    
    //Adiciona usuario e da excessaõ se os campos bolean for os os dois vazios dentista e administrador
    public String doFinishAddUsuario() {
        setUsrFiltrado(null);
        try {
            userService.addUsuario(usuarioSelected);
        } catch (AcessoInvalidoException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O acesso deste usuário é invalido, favor selecionar o acesso de administrador e/ou dentista.", "O acesso deste usuário é invalido, favor selecionar o acesso de administrador e/ou dentista.");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/restrito/addUsers.faces";
        }
        return "/restrito/usuarios.faces";
    }

    public String doFinishExcluir() {
        setUsrFiltrado(null);
        if (usuarioSelected.equals(loggedUser)) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Você não pode apagar a si mesmo.", "Você não pode apagar a si mesmo.");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/restrito/usuarios.faces";
        }
        userService.removeUsuario(usuarioSelected);
        return "/restrito/usuarios.faces";
    }

    public String doStartAlterar() {
        return "/restrito/editUsers.faces";
    }

    //Adiciona usuario e da excessaõ se os campos bolean for os os dois vazios dentista e administrador
    public String doFinishAlterar() {
        setUsrFiltrado(null);
        try {
            userService.setUsuario(usuarioSelected);
        } catch (AcessoInvalidoException ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O acesso deste usuário é invalido, favor selecionar o acesso de administrador e/ou dentista.", "O acesso deste usuário é invalido, favor selecionar o acesso de administrador e/ou dentista.");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "/restrito/editUsers.faces";
        }
        return "/restrito/usuarios.faces";
    }

    public String doStartAlterarSenha() {
        getUsuarioSelected().setUspassword("");
        return "/restrito/editUserPassword.faces";
    }

    public String doFinishAlterarSenha() {
        setUsrFiltrado(null);
        userService.setPassword(getUsuarioSelected().getUsid(), getUsuarioSelected().getUspassword());
        return "/restrito/usuarios.faces";
    }

}
