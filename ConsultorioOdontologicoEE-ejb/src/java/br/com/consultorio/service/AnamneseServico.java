/*
 * Copyright (C) 2014 dyego.carmo
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

import br.com.consultorio.repositorio.AnamneseRepositorio;
import br.com.consultorio.entity.Anamnese;
import br.com.consultorio.entity.Cliente;
import br.com.consultorio.entity.Orcamento;
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
public class AnamneseServico extends BasicoServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private AnamneseRepositorio anamneseRepositorio;
    

    @PostActivate
    @PostConstruct
    private void postConstruct() {
        anamneseRepositorio = new AnamneseRepositorio(em);
    }
    
    public Anamnese getAnamnese(Integer idOfAnamnese) {
        return anamneseRepositorio.getAnamnese(idOfAnamnese);
    }
    
    public Anamnese addAnamnese(Anamnese anamnese) {
        return anamneseRepositorio.addAnamnese(anamnese);
    }
    
    public Anamnese setAnamnese(Anamnese anamnese) {
        return anamneseRepositorio.setAnamnese(anamnese);
    }
    
    public void removeAnamnese(Anamnese anamnese) {
        anamneseRepositorio.removeAnamnese(anamnese);
    }
    
    public List<Anamnese> getAnamnesesByCliente(Cliente cliente) {
        return anamneseRepositorio.getAnamnesesByCliente(cliente);
    }
    
    public List<Anamnese> getAnamnesesByOrcamento(Orcamento orcamento) {
        return anamneseRepositorio.getAnamnesesByOrcamento(orcamento);
    }
    
}
