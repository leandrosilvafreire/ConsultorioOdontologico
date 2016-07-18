/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")})
public class Orcamento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer orcid;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orcdata;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date orchora;
    
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String orcobs;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 16, scale = 2)
    private BigDecimal orctotal;
    
    @Size(max = 9)
    @Column(length = 9)
    @Enumerated(EnumType.STRING)
    private TipoPagamento orcpagamento;
    
    private Integer orctimes;
    
    @JoinColumn(name = "orccliente", referencedColumnName = "cliid", nullable = false)
    @ManyToOne(optional = false)
    private Cliente orccliente;
    
    @JoinColumn(name = "orcdentista", referencedColumnName = "usid", nullable = false)
    @ManyToOne(optional = false)
    private Usuario orcdentista;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parorcamento")
    private List<Parcela> parcelasList = new LinkedList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oritorcamento")
    private List<Orcamentoitem> orcamentoitemList = new LinkedList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anaorcamento")
    private List<Anamnese> anamneseList = new LinkedList<>();

    public Orcamento() {
    }

    public Orcamento(Integer orcid) {
        this.orcid = orcid;
    }

    public Orcamento(Integer orcid, Date orcdata, Date orchora, TipoPagamento orcpagamento) {
        this.orcid = orcid;
        this.orcdata = orcdata;
        this.orchora = orchora;
        this.orcpagamento = orcpagamento;
    }

    public Integer getOrcid() {
        return orcid;
    }
    
    public void addItem(Orcamentoitem ori){
        ori.setOritorcamento(this);
        orcamentoitemList.add(ori);
    }
    
    public void addAnamnese(Anamnese anamnese){
        anamnese.setAnaorcamento(this);
        getAnamneseList().add(anamnese);
    }
    
    public void addParcela(Parcela parcela){
        parcela.setParorcamento(this);
        getParcelasList().add(parcela);
    }
           

    public void setOrcid(Integer orcid) {
        this.orcid = orcid;
    }

    public Date getOrcdata() {
        return orcdata;
    }

    public void setOrcdata(Date orcdata) {
        this.orcdata = orcdata;
    }

    public Date getOrchora() {
        return orchora;
    }

    public void setOrchora(Date orchora) {
        this.orchora = orchora;
    }

    public String getOrcobs() {
        return orcobs;
    }

    public void setOrcobs(String orcobs) {
        this.orcobs = orcobs;
    }

    public BigDecimal getOrctotal() {
        return orctotal;
    }

    public void setOrctotal(BigDecimal orctotal) {
        this.orctotal = orctotal;
    }

    public TipoPagamento getOrcpagamento() {
        return orcpagamento;
    }

    public void setOrcpagamento(TipoPagamento orcpagamento) {
        this.orcpagamento = orcpagamento;
    }

    public Integer getOrctimes() {
        return orctimes;
    }

    public void setOrctimes(Integer orctimes) {
        this.orctimes = orctimes;
    }

    public Cliente getOrccliente() {
        return orccliente;
    }

    public void setOrccliente(Cliente orccliente) {
        this.orccliente = orccliente;
    }

    public Usuario getOrcdentista() {
        return orcdentista;
    }

    public void setOrcdentista(Usuario orcdentista) {
        this.orcdentista = orcdentista;
    }

    @XmlTransient
    public List<Parcela> getParcelasList() {
        return parcelasList;
    }

    public void setParcelasList(List<Parcela> parcelasList) {
        this.parcelasList = parcelasList;
    }

    @XmlTransient
    public List<Orcamentoitem> getOrcamentoitemList() {
        return orcamentoitemList;
    }

    public void setOrcamentoitemList(List<Orcamentoitem> orcamentoitemList) {
        this.orcamentoitemList = orcamentoitemList;
    }

    @XmlTransient
    public List<Anamnese> getAnamneseList() {
        return anamneseList;
    }

    public void setAnamneseList(List<Anamnese> anamneseList) {
        this.anamneseList = anamneseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orcid != null ? orcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.orcid == null && other.orcid != null) || (this.orcid != null && !this.orcid.equals(other.orcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorioee.entity.Orcamento[ orcid=" + orcid + " ]";
    }
    
}
