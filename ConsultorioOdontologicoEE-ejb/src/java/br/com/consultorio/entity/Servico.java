/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity;

import br.com.consultorio.entity.validator.DescricaoServicoUnico;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro
 */
@Entity
@XmlRootElement
@DescricaoServicoUnico
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s")})
public class Servico implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer serid;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 80, message = "O nome do serviço deve conter pelo menos 3 letras")
    @Column(nullable = false, length = 80)
    private String sernome;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal sercusto;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oritservico")
    private List<Orcamentoitem> orcamentoitemList;

    public Servico() {
    }

    public Servico(Integer serid) {
        this.serid = serid;
    }

    public Servico(Integer serid, String sernome, BigDecimal sercusto) {
        this.serid = serid;
        this.sernome = sernome;
        this.sercusto = sercusto;
    }

    public Integer getSerid() {
        return serid;
    }

    public void setSerid(Integer serid) {
        this.serid = serid;
    }

    public String getSernome() {
        return sernome;
    }

    public void setSernome(String sernome) {
        this.sernome = sernome;
    }

    public BigDecimal getSercusto() {
        return sercusto;
    }

    public void setSercusto(BigDecimal sercusto) {
        this.sercusto = sercusto;
    }

    @XmlTransient
    public List<Orcamentoitem> getOrcamentoitemList() {
        return orcamentoitemList;
    }

    public void setOrcamentoitemList(List<Orcamentoitem> orcamentoitemList) {
        this.orcamentoitemList = orcamentoitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serid != null ? serid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.serid == null && other.serid != null) || (this.serid != null && !this.serid.equals(other.serid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorioee.entity.Servi\u00e7o[ serid=" + serid + " ]";
    }
    
}
