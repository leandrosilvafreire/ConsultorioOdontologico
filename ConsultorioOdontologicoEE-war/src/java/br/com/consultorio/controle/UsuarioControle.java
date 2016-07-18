/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.consultorio.controle;

import br.com.consultorio.entity.Usuario;
import br.com.consultorio.service.UsuarioServico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.print.attribute.standard.Severity;
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
    private String userName;
    @NotNull
    @NotEmpty(message = "Você precisa especificar uma senha")
    @Length(min = 3,message = "Sua senha deve conter no minimo 3 caracteres.")
    private String password;
    
//    @NotEmpty(message = "Você precisa especificar uma senha válida")
//    @NotNull(message = "Você precisa especificar uma senha válida")
//    @Length(min = 3, message = "Você deve especificar uma senha com mais de 3 caracteres!")
    private String localizar;
    private List<Usuario> usuarioFiltardo;
    private Usuario usuarioSelecionado;
    

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    
    
    
    public String doLocalizar(){
        usuarioFiltardo = userService.getUserByName(getLocalizar());
        return "usuarios.faces";
    }

    @PostConstruct
    public void postContrsuct() {
        System.out.println("UsuarioControle Started ! " + hashCode());
    }
    
    public List<Usuario> getUsuarios(){
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
    
    public String doStartAdicionarUsuario(){
        setUsuarioSelecionado(new Usuario());
        return "/restrito/addUsers.faces";
    }
    
    public String doFinishAdicionarUsuario(){
        setUsuarioFiltardo(null);
        userService.addUsuario(usuarioSelecionado);
        return "/restrito/usuarios.faces";
    }
    
    public String doExcluir(){
        return "/restrito/usuarios.faces";
    }
    
    public String doAlterar(){
        return "/restrito/editUser.faces";
    }
    
    public String doAlterarSenha(){
        return "/restrito/editUserPassword.faces";
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

    public List<Usuario> getUsuarioFiltardo() {
        if(usuarioFiltardo==null){
            return getUsuarios();
        }
        return usuarioFiltardo;
    }

    public void setUsuarioFiltardo(List<Usuario> UsuarioFiltardo) {
        this.usuarioFiltardo = UsuarioFiltardo;
    }
    
    
    
    
    
    
}
