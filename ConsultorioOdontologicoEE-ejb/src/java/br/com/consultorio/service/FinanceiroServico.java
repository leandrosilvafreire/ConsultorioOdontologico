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

import br.com.consultorio.repositorio.FinanceiroRepositorio;
import br.com.consultorio.entity.Parcela;
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
 * @author Leandro
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FinanceiroServico extends BasicoServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private FinanceiroRepositorio financeiroRepositorio;
    
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        financeiroRepositorio = new FinanceiroRepositorio(em);
    }
    
    public Parcela addParcela(Parcela par) {
        return financeiroRepositorio.addParcela(par);
    }
    
    public Parcela getParcela(Integer idOfParcela) {
        return financeiroRepositorio.getParcela(idOfParcela);
    }
    
    public Parcela setParcela(Parcela par) {
        return financeiroRepositorio.setParcela(par);
    }
    
    public void removeParcela(Parcela par) {
        financeiroRepositorio.removeParcela(par);
    }
    
    public List<Parcela> getParcelasByOrcamento(int orcamentoId) {
        return financeiroRepositorio.getParcelasOfOrcamento(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfOrcamentoPagas(int orcamentoId) {
        return financeiroRepositorio.getParcelasOfOrcamentoPagas(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfOrcamentoEmAberto(int orcamentoId) {
        return financeiroRepositorio.getParcelasOfOrcamentoEmAberto(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfCustomer(int clienteId) {
        return financeiroRepositorio.getParcelasOfCliente(clienteId);
    }
    
    public List<Parcela> getParcelasOfCustomerPagas(int orcamentoId) {
        return financeiroRepositorio.getParcelasOfClientePagas(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfCustomerEmAberto(int orcamentoId) {
        return financeiroRepositorio.getParcelasOfClienteEmAberto(orcamentoId);
    }
    
    public Parcela setPagamentoParcela(int idOfParcela) {
        return financeiroRepositorio.setPagamentoParcela(idOfParcela);
    }
    
}
