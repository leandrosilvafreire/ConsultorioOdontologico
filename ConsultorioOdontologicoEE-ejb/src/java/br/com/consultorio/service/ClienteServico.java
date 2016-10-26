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

import br.com.consultorio.entity.Cliente;
import br.com.consultorio.repositorio.ClienteRepositorio;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class ClienteServico extends BasicoServico {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private ClienteRepositorio clienteRepository;

    @PostActivate
    @PostConstruct
    private void postConstruct() {
        clienteRepository = new ClienteRepositorio(em);
    }

    public Cliente addCliente(Cliente cus) {
        //cus.setCusAge(getIdade(cus.getCusBorndate()));
        return clienteRepository.addCliente(cus);
    }

    public Cliente setCliente(Cliente cus) {
        //cus.setCusAge(getIdade(cus.getCusBorndate()));
        return clienteRepository.setCliente(cus);
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

    public void removeCliente(Cliente cus) {
        clienteRepository.removeCliente(cus);
    }

    public Cliente getCliente(int idOfCliente) {
        return clienteRepository.getCliente(idOfCliente);
    }

    public List<Cliente> getClienteByName(String nameOfCliente) {
        return clienteRepository.getClienteByName(nameOfCliente);
    }

    public List<Cliente> getClientesToCall(int month, int year) {
        return clienteRepository.getClientesToCall(month, year);
    }

    public Cliente refreshCustomer(Cliente cliente) {
        clienteRepository.refreshEntity(Cliente.class, cliente);
        return cliente;
    }

    public List<Cliente> getClientesComPagamentoEmAberto(int ifOfCliente) {
        return clienteRepository.getClientesComPagamentoEmAberto(ifOfCliente);
    }

    public Date getUltimoAtendimento(int idOfCliente) {
        return clienteRepository.getUltimoAtendimento(idOfCliente);
    }

    public int getClientesCount() {
        return clienteRepository.getClientesCount();
    }
}
