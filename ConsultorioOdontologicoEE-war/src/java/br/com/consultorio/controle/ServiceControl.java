/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.consultorio.controle;

import br.com.consultorio.entity.Servico;
import br.com.consultorio.service.ServicoServico;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Leandro
 * @version 1.0
 * @since 06/2014
 */
@Named
@SessionScoped
public class ServiceControl extends BasicoControle implements java.io.Serializable {

    @EJB
    private ServicoServico serviceService;
    
    private String localizar;
    private List<Servico> srvFiltrado;
    private Servico serviceSelected;

    
    public String doLocalizar() {
        srvFiltrado = serviceService.getServicosByName(localizar);
        return "/restrito/services.faces";
    }

    public String doStartAddService() {
        setServiceSelected(new Servico());
        return "/restrito/addService.faces";
    }

    public String doFinishAddService() {
        srvFiltrado = null;
        serviceService.addServico(serviceSelected);
        return "/restrito/services.faces";
    }
    
    public List<Servico> getServices() {
        return serviceService.getServicos();
    }
    
    
    
    public String getLocalizar() {
        return localizar;
    }

    public void setLocalizar(String localizar) {
        this.localizar = localizar;
    }

    public List<Servico> getSrvFiltrado() {
        if (srvFiltrado == null) return getServices();
        return srvFiltrado;
    }

    public void setSrvFiltrado(List<Servico> srvFiltrado) {
        this.srvFiltrado = srvFiltrado;
    }

    public Servico getServiceSelected() {
        return serviceSelected;
    }

    public void setServiceSelected(Servico serviceSelected) {
        this.serviceSelected = serviceSelected;
    }
    
    
    
    
    
}
