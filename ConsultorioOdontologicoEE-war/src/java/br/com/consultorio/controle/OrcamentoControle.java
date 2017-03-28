/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.controle;

import br.com.consultorio.entity.Cliente;
import br.com.consultorio.entity.Orcamento;
import br.com.consultorio.entity.Orcamentoitem;
import br.com.consultorio.service.OrcamentoServico;
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
public class OrcamentoControle extends BasicoControle implements java.io.Serializable {

    @EJB
    private OrcamentoServico orcamentoServico;
    
    @Inject
    private AnameneseControle anameneseControle;        

    private Orcamento selectedOrcamento;
    private Cliente selectedCliente;
    private List<Orcamento> orcamentos;

    public OrcamentoServico getOrcamentoServico() {
        return orcamentoServico;
    }

    public void setOrcamentoServico(OrcamentoServico orcamentoServico) {
        this.orcamentoServico = orcamentoServico;
    }

    public Orcamento getSelectedOrcamento() {
        return selectedOrcamento;
    }

    public void setSelectedOrcamento(Orcamento selectedOrcamento) {
        this.selectedOrcamento = selectedOrcamento;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public String doStartAtenderOCliente(Cliente cliente) {
        setSelectedCliente(cliente);
        anameneseControle.setSelectedCliente(selectedCliente);
        anameneseControle.cleanCache();
        cleanCache();
        return "/restrito/orcamentos.faces";
    }

    private void cleanCache() {
        setSelectedOrcamento(new Orcamento());
        getSelectedOrcamento().setOrccliente(getSelectedCliente());
        setOrcamentos(orcamentoServico.getOrcamentos(getSelectedCliente().getCliid()));
    }

    public String getItensOfOrcamento(Orcamento orc) {
        StringBuilder sb = new StringBuilder();
        for (Orcamentoitem item : orc.getOrcamentoitemList()) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(item.getOritservico().getSernome());

        }
        return sb.toString();
    }

}
