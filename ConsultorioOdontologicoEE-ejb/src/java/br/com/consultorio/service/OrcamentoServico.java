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

import br.com.consultorio.repositorio.OrcamentoRepositorio;
import br.com.consultorio.entity.Orcamento;
import br.com.consultorio.entity.Orcamentoitem;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
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
public class OrcamentoServico extends BasicoServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private OrcamentoRepositorio orcamentoRepositorio;
    
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        orcamentoRepositorio =  new OrcamentoRepositorio(em);
    }
    
    public Orcamento addOrcamento(Orcamento orcamento) {
        return orcamentoRepositorio.addOrcamento(orcamento);
    }
    
    public Orcamento setOrcamento(Orcamento orcamento) {
        return orcamentoRepositorio.setOrcamento(orcamento);
    }
    
    public Orcamento getOrcamento(Integer idOfOrcamento) {
        return orcamentoRepositorio.getOrcamento(idOfOrcamento);
    }
    
    public void removeOrcamento(Orcamento orcamento) {
        orcamentoRepositorio.removeOrcamento(orcamento);
    }
    
    public Orcamentoitem addItem(Orcamentoitem item) {
        return orcamentoRepositorio.addItem(item);
    }
    
    public Orcamentoitem setItem(Orcamentoitem item) {
        return orcamentoRepositorio.setItem(item);
    }
    
    public Orcamentoitem getItem(Integer idOfItem) {
        return orcamentoRepositorio.getItem(idOfItem);
    }
    
    public List<Orcamento> getOrcamentos(Integer idofCliente) {
        return orcamentoRepositorio.getOrcamentos(idofCliente);
    }
    
    public List<Orcamentoitem> getItens(Integer idOfOrcamento) {
        return orcamentoRepositorio.getItens(idOfOrcamento);
    }
    
}
