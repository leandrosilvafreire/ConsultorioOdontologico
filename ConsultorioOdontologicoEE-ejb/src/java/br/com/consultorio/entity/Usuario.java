/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Leandro
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 2L;

    public static void setUsuName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer usid;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, length = 70)
    @Length(min=3, max = 70, message = "Você precisa especificar um nome com no mínimo 3 caracteres")
    private String usunome;
    
    @Basic(optional = false)
    @NotNull
    @Length(min = 5, max = 70, message = "Você precisa de um login com no minímo 5 caracteres")
    @Column(nullable = false, length = 70)
    private String usulogin;
    
    @Basic(optional = false)
    @NotNull
    @Length(min = 5, max=32, message = "Você precisa de uma senha com no minímo 5 caracteres")
    @Column(nullable = false, length = 32)
    private String uspassword;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean usuadministrador = false;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean usudentista = true;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcdentista")
    private List<Orcamento> orcamentoList;

    public Usuario() {
    }

    public Usuario(Integer usid) {
        this.usid = usid;
    }

    public Usuario(Integer usid, String usunome, String usulogin, String uspassword, boolean usuadministrador, boolean usudentista) {
        this.usid = usid;
        this.usunome = usunome;
        this.usulogin = usulogin;
        this.uspassword = uspassword;
        this.usuadministrador = usuadministrador;
        this.usudentista = usudentista;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public String getUsunome() {
        return usunome;
    }

    public void setUsunome(String usunome) {
        this.usunome = usunome;
    }

    public String getUsulogin() {
        return usulogin;
    }

    public void setUsulogin(String usulogin) {
        this.usulogin = usulogin;
    }

    public String getUspassword() {
        return uspassword;
    }

    public void setUspassword(String uspassword) {
        this.uspassword = uspassword;
    }

    public boolean getUsuadministrador() {
        return usuadministrador;
    }

    public void setUsuadministrador(boolean usuadministrador) {
        this.usuadministrador = usuadministrador;
    }

    public boolean getUsudentista() {
        return usudentista;
    }

    public void setUsudentista(boolean usudentista) {
        this.usudentista = usudentista;
    }

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usid != null ? usid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usid == null && other.usid != null) || (this.usid != null && !this.usid.equals(other.usid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorio.entity.Usuario[ usid=" + usid + " ]";
    }
    
}
