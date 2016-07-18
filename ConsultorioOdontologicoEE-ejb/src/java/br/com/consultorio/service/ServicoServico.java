/*
 * Copyright (C) Leandro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.com.consultorio.service;

import br.com.consultorio.repositorio.ServicoRepositorio;
import br.com.consultorio.entity.Servico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dyego.carmo
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ServicoServico extends BasicoServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private ServicoRepositorio servicoRepositorio;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        servicoRepositorio = new ServicoRepositorio(em);
    }
    
    public Servico addServico(Servico service) {
        return servicoRepositorio.addServico(service);
    }
    
    public Servico setServico(Servico service) {
        return servicoRepositorio.setServico(service);
    }
    
    public void removeServico(Servico service) {
        servicoRepositorio.removeServico(service);
    }
    
    public Servico getServico(int idOfServico) {
        return servicoRepositorio.getServico(idOfServico);
    }
    
    public List<Servico> getServicos() {
        return servicoRepositorio.getServicos();
    }
    
    public List<Servico> getServicosByName(String name) {
        return servicoRepositorio.getServicoByName(name);
    }
    
}
