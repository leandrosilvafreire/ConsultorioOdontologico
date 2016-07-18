/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity;

import java.io.Serializable;
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
    @NamedQuery(name = "Anamnese.findAll", query = "SELECT a FROM Anamnese a")})
public class Anamnese implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer anaid;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean anafuma;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean anaexercicio;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean anadoenca;
    
    @Size(max = 255)
    @Column(length = 255)
    private String anadescricaodoenca;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean anaoperacaorecente;
    
    private Integer anadescricaooperacao;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean anamedicacao;
    
    @Size(max = 255)
    @Column(length = 255)
    private String anadescricaomedicacao;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean anaalergia;
    
    @Size(max = 255)
    @Column(length = 255)
    private String anadescricaoalergia;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false) 
    private boolean anasdst;
    
    @Size(max = 255)
    @Column(length = 255)
    private String anadescricaodst;
    
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String anaobs;
    
    @JoinColumn(name = "anacliente", referencedColumnName = "cliid", nullable = false)
    @ManyToOne(optional = false)
    private Cliente anacliente;
    
    @JoinColumn(name = "anaorcamento", referencedColumnName = "orcid", nullable = false)
    @ManyToOne(optional = false)
    private Orcamento anaorcamento;

    public Anamnese() {
    }

    public Anamnese(Integer anaid) {
        this.anaid = anaid;
    }

    public Anamnese(Integer anaid, boolean anafuma, boolean anaexercicio, boolean anadoenca, boolean anaoperacaorecente, boolean anamedicacao, boolean anaalergia, boolean anasdst) {
        this.anaid = anaid;
        this.anafuma = anafuma;
        this.anaexercicio = anaexercicio;
        this.anadoenca = anadoenca;
        this.anaoperacaorecente = anaoperacaorecente;
        this.anamedicacao = anamedicacao;
        this.anaalergia = anaalergia;
        this.anasdst = anasdst;
    }

    public Integer getAnaid() {
        return anaid;
    }

    public void setAnaid(Integer anaid) {
        this.anaid = anaid;
    }

    public boolean getAnafuma() {
        return anafuma;
    }

    public void setAnafuma(boolean anafuma) {
        this.anafuma = anafuma;
    }

    public boolean getAnaexercicio() {
        return anaexercicio;
    }

    public void setAnaexercicio(boolean anaexercicio) {
        this.anaexercicio = anaexercicio;
    }

    public boolean getAnadoenca() {
        return anadoenca;
    }

    public void setAnadoenca(boolean anadoenca) {
        this.anadoenca = anadoenca;
    }

    public String getAnadescricaodoenca() {
        return anadescricaodoenca;
    }

    public void setAnadescricaodoenca(String anadescricaodoenca) {
        this.anadescricaodoenca = anadescricaodoenca;
    }

    public boolean getAnaoperacaorecente() {
        return anaoperacaorecente;
    }

    public void setAnaoperacaorecente(boolean anaoperacaorecente) {
        this.anaoperacaorecente = anaoperacaorecente;
    }

    public Integer getAnadescricaooperacao() {
        return anadescricaooperacao;
    }

    public void setAnadescricaooperacao(Integer anadescricaooperacao) {
        this.anadescricaooperacao = anadescricaooperacao;
    }

    public boolean getAnamedicacao() {
        return anamedicacao;
    }

    public void setAnamedicacao(boolean anamedicacao) {
        this.anamedicacao = anamedicacao;
    }

    public String getAnadescricaomedicacao() {
        return anadescricaomedicacao;
    }

    public void setAnadescricaomedicacao(String anadescricaomedicacao) {
        this.anadescricaomedicacao = anadescricaomedicacao;
    }

    public boolean getAnaalergia() {
        return anaalergia;
    }

    public void setAnaalergia(boolean anaalergia) {
        this.anaalergia = anaalergia;
    }

    public String getAnadescricaoalergia() {
        return anadescricaoalergia;
    }

    public void setAnadescricaoalergia(String anadescricaoalergia) {
        this.anadescricaoalergia = anadescricaoalergia;
    }

    public boolean getAnasdst() {
        return anasdst;
    }

    public void setAnasdst(boolean anasdst) {
        this.anasdst = anasdst;
    }

    public String getAnadescricaodst() {
        return anadescricaodst;
    }

    public void setAnadescricaodst(String anadescricaodst) {
        this.anadescricaodst = anadescricaodst;
    }

    public String getAnaobs() {
        return anaobs;
    }

    public void setAnaobs(String anaobs) {
        this.anaobs = anaobs;
    }

    public Cliente getAnacliente() {
        return anacliente;
    }

    public void setAnacliente(Cliente anacliente) {
        this.anacliente = anacliente;
    }

    public Orcamento getAnaorcamento() {
        return anaorcamento;
    }

    public void setAnaorcamento(Orcamento anaorcamento) {
        this.anaorcamento = anaorcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anaid != null ? anaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anamnese)) {
            return false;
        }
        Anamnese other = (Anamnese) object;
        if ((this.anaid == null && other.anaid != null) || (this.anaid != null && !this.anaid.equals(other.anaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorioee.entity.Anamnese[ anaid=" + anaid + " ]";
    }
    
}
