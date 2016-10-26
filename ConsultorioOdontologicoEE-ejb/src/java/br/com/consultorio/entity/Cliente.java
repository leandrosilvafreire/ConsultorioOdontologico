/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer cliid;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70, message = "O nome do cliente é obrigatório!")
    @Column(nullable = false, length = 70)
    private String clinome;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cliidade;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(nullable = false, length = 90)
    private String cliendereco;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 2, max = 2, message = "O estado deve conter a sigla!")
    @Column(nullable = false, length = 2)
    private String cliestado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String clicidade;
    
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String clicomple;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(nullable = false, length = 70)
    private String clipai;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(nullable = false, length = 70)
    private String climae;
    
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String cliobs;
    
    @Size(max = 45)
    @Column(length = 45)
    private String cliocupacao;
    
    @Size(max = 45)
    @Column(length = 45)
    private String clitrabalho;
    
    @Size(max = 20)
    @Column(length = 20)
    private String clicelular;
    
    @Size(max = 45)
    @Column(length = 45)
    private String clitrabalhonome;
    
    @Size(max = 255)
    @Column(length = 255)
    private String clitrabalhoendereco;
    
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String clitrabalhoobs;
    
    @Size(max = 20)
    @Column(length = 20)
    private String clitelefone;
    
    @Temporal(TemporalType.DATE)
    private Date clidatanascimento;
    
    @Size(max = 45)
    @Column(length = 45)
    private String clientecol;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orccliente")
    private List<Orcamento> orcamentoList = new LinkedList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anacliente")
    private List<Anamnese> anamneseList = new LinkedList<>();
    
    
    
    @PrePersist
    @PreUpdate
    public void updateAge() {
        System.out.println("[Cliente Entity] Calling getIdade()..");
        setCliidade(getIdade(getClidatanascimento()));
    }
    
    private int getIdade(Date nascimento) {
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(nascimento);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, age);
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }

    public Cliente() {
    }

    public Cliente(Integer cliid) {
        this.cliid = cliid;
    }
    
    public void addOrcamento(Orcamento orcamento){
        orcamento.setOrccliente(this);
        getOrcamentoList().add(orcamento);
    }
    
    public void addAnamnese(Anamnese anamnese){
        anamnese.setAnacliente(this);
        getAnamneseList().add(anamnese);
    }

    public Cliente(Integer cliid, String clinome, int cliidade, String cliendereco, String cliestado, String clicidade, String clipai, String climae, Date clidatanascimento) {
        this.cliid = cliid;
        this.clinome = clinome;
        this.cliidade = cliidade;
        this.cliendereco = cliendereco;
        this.cliestado = cliestado;
        this.clicidade = clicidade;
        this.clipai = clipai;
        this.climae = climae;
        this.clidatanascimento = clidatanascimento;
    }

    public Integer getCliid() {
        return cliid;
    }

    public void setCliid(Integer cliid) {
        this.cliid = cliid;
    }

    public String getClinome() {
        return clinome;
    }

    public void setClinome(String clinome) {
        this.clinome = clinome;
    }

    public int getCliidade() {
        return cliidade;
    }

    public void setCliidade(int cliidade) {
        this.cliidade = cliidade;
    }

    public String getCliendereco() {
        return cliendereco;
    }

    public void setCliendereco(String cliendereco) {
        this.cliendereco = cliendereco;
    }

    public String getCliestado() {
        return cliestado;
    }

    public void setCliestado(String cliestado) {
        this.cliestado = cliestado;
    }

    public String getClicidade() {
        return clicidade;
    }

    public void setClicidade(String clicidade) {
        this.clicidade = clicidade;
    }

    public String getClicomple() {
        return clicomple;
    }

    public void setClicomple(String clicomple) {
        this.clicomple = clicomple;
    }

    public String getClipai() {
        return clipai;
    }

    public void setClipai(String clipai) {
        this.clipai = clipai;
    }

    public String getClimae() {
        return climae;
    }

    public void setClimae(String climae) {
        this.climae = climae;
    }

    public String getCliobs() {
        return cliobs;
    }

    public void setCliobs(String cliobs) {
        this.cliobs = cliobs;
    }

    public String getCliocupacao() {
        return cliocupacao;
    }

    public void setCliocupacao(String cliocupacao) {
        this.cliocupacao = cliocupacao;
    }

    public String getClitrabalho() {
        return clitrabalho;
    }

    public void setClitrabalho(String clitrabalho) {
        this.clitrabalho = clitrabalho;
    }

    public String getClicelular() {
        return clicelular;
    }

    public void setClicelular(String clicelular) {
        this.clicelular = clicelular;
    }

    public String getClitrabalhonome() {
        return clitrabalhonome;
    }

    public void setClitrabalhonome(String clitrabalhonome) {
        this.clitrabalhonome = clitrabalhonome;
    }

    public String getClitrabalhoendereco() {
        return clitrabalhoendereco;
    }

    public void setClitrabalhoendereco(String clitrabalhoendereco) {
        this.clitrabalhoendereco = clitrabalhoendereco;
    }

    public String getClitrabalhoobs() {
        return clitrabalhoobs;
    }

    public void setClitrabalhoobs(String clitrabalhoobs) {
        this.clitrabalhoobs = clitrabalhoobs;
    }

    public String getClitelefone() {
        return clitelefone;
    }

    public void setClitelefone(String clitelefone) {
        this.clitelefone = clitelefone;
    }

    public Date getClidatanascimento() {
        return clidatanascimento;
    }

    public void setClidatanascimento(Date clidatanascimento) {
        this.clidatanascimento = clidatanascimento;
    }

    public String getClientecol() {
        return clientecol;
    }

    public void setClientecol(String clientecol) {
        this.clientecol = clientecol;
    }

    @XmlTransient
    public List<Orcamento> getOrcamentoList() {
        return orcamentoList;
    }

    public void setOrcamentoList(List<Orcamento> orcamentoList) {
        this.orcamentoList = orcamentoList;
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
        hash += (cliid != null ? cliid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliid == null && other.cliid != null) || (this.cliid != null && !this.cliid.equals(other.cliid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.consultorioee.entity.Cliente[ cliid=" + cliid + " ]";
    }
    
}
