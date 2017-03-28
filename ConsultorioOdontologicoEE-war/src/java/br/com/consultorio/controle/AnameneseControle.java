/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.controle;

import br.com.consultorio.entity.Anamnese;
import br.com.consultorio.entity.Cliente;
import br.com.consultorio.service.AnamneseServico;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Leandro
 */
@Named
@SessionScoped
public class AnameneseControle extends BasicoControle implements java.io.Serializable{
    
    @EJB
    private AnamneseServico anamneseServico;
    
    private Anamnese selectedAnamnese;
    private Cliente selectedCliente;
    private List<Anamnese> anamnesese;
    
    @Inject
    private OrcamentoControle orcamentoControle;
            
            

    public Anamnese getSelectedAnamnese() {
        return selectedAnamnese;
    }

    public void setSelectedAnamnese(Anamnese selectedAnamnese) {
        this.selectedAnamnese = selectedAnamnese;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public List<Anamnese> getAnamnesese() {
        return anamnesese;
    }

    public void setAnamnesese(List<Anamnese> anamnesese) {
        this.anamnesese = anamnesese;
    }
    
    public void cleanCache(){
        setSelectedAnamnese(new Anamnese());
        getSelectedAnamnese().setAnacliente(selectedCliente);
        anamnesese = anamneseServico.getAnamnesesByCliente(selectedCliente);
        
    }
    
    public String doStartAddAnamnese(){
        cleanCache();
        return "/restrito/addAnamnese.faces";
    }
    
    public String doFinishAddAnamnese(){
        selectedAnamnese.setAnacliente(selectedCliente);
        anamneseServico.addAnamnese(selectedAnamnese);
        cleanCache();
        return "/restrito/orcamentos.faces";
    }
    
    
    public String doFinishExcluir(){
        anamneseServico.removeAnamnese(selectedAnamnese);
        cleanCache();
        return "/restrito/orcamentos.faces";
    }
    
    public String doStartAlterar(){
        return "/restrito/editAnamnese.faces";
       
    }      
    
    public String doFinishEditAnamnese(){
        anamneseServico.setAnamnese(selectedAnamnese);
        cleanCache();
        return "/restrito/orcamentos.faces";
    }
}
