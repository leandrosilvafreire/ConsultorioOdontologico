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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcelas.findAll", query = "SELECT p FROM Parcelas p")})
public class Parcelas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer parid;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int parnumero;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 16, scale = 2)
    private BigDecimal parvalor;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean parpago;
    
    @JoinColumn(name = "parorcamento", referencedColumnName = "orcid", nullable = false)
    @ManyToOne(optional = false)
    private Orcamento parorcamento;

    public Parcelas() {
    }

    public Parcelas(Integer parid) {
        this.parid = parid;
    }

    public Parcelas(Integer parid, int parnumero, BigDecimal parvalor, boolean parpago) {
        this.parid = parid;
        this.parnumero = parnumero;
        this.parvalor = parvalor;
        this.parpago = parpago;
    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }

    public int getParnumero() {
        return parnumero;
    }

    public void setParnumero(int parnumero) {
        this.parnumero = parnumero;
    }

    public BigDecimal getParvalor() {
        return parvalor;
    }

    public void setParvalor(BigDecimal parvalor) {
        this.parvalor = parvalor;
    }

    public boolean getParpago() {
        return parpago;
    }

    public void setParpago(boolean parpago) {
        this.parpago = parpago;
    }

    public Orcamento getParorcamento() {
        return parorcamento;
    }

    public void setParorcamento(Orcamento parorcamento) {
        this.parorcamento = parorcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parid != null ? parid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcelas)) {
            return false;
        }
        Parcelas other = (Parcelas) object;
        if ((this.parid == null && other.parid != null) || (this.parid != null && !this.parid.equals(other.parid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorioee.entity.Parcelas[ parid=" + parid + " ]";
    }
    
}
