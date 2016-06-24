/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorioee.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentoitem.findAll", query = "SELECT o FROM Orcamentoitem o")})
public class Orcamentoitem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer oritcid;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal oritccusto;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String oriobs;
    
    @Size(max = 45)
    @Column(length = 45)
    private String orcamentoitemcol;
    
    @JoinColumn(name = "oritorcamento", referencedColumnName = "orcid", nullable = false)
    @ManyToOne(optional = false)
    private Orcamento oritorcamento;
    
    @JoinColumn(name = "oritservico", referencedColumnName = "serid", nullable = false)
    @ManyToOne(optional = false)
    private Servico oritservico;

    public Orcamentoitem() {
    }

    public Orcamentoitem(Integer oritcid) {
        this.oritcid = oritcid;
    }

    public Orcamentoitem(Integer oritcid, BigDecimal oritccusto, String oriobs) {
        this.oritcid = oritcid;
        this.oritccusto = oritccusto;
        this.oriobs = oriobs;
    }

    public Integer getOritcid() {
        return oritcid;
    }

    public void setOritcid(Integer oritcid) {
        this.oritcid = oritcid;
    }

    public BigDecimal getOritccusto() {
        return oritccusto;
    }

    public void setOritccusto(BigDecimal oritccusto) {
        this.oritccusto = oritccusto;
    }

    public String getOriobs() {
        return oriobs;
    }

    public void setOriobs(String oriobs) {
        this.oriobs = oriobs;
    }

    public String getOrcamentoitemcol() {
        return orcamentoitemcol;
    }

    public void setOrcamentoitemcol(String orcamentoitemcol) {
        this.orcamentoitemcol = orcamentoitemcol;
    }

    public Orcamento getOritorcamento() {
        return oritorcamento;
    }

    public void setOritorcamento(Orcamento oritorcamento) {
        this.oritorcamento = oritorcamento;
    }

    public Servico getOritservico() {
        return oritservico;
    }

    public void setOritservico(Servico oritservico) {
        this.oritservico = oritservico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oritcid != null ? oritcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentoitem)) {
            return false;
        }
        Orcamentoitem other = (Orcamentoitem) object;
        if ((this.oritcid == null && other.oritcid != null) || (this.oritcid != null && !this.oritcid.equals(other.oritcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorioee.entity.Orcamentoitem[ oritcid=" + oritcid + " ]";
    }
    
}
