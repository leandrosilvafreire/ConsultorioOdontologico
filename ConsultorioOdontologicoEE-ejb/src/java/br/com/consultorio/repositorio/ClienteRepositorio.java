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
package br.com.consultorio.repositorio;

import br.com.consultorio.entity.Cliente;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author dyego.carmo
 */
public class ClienteRepositorio extends BasicoRepositorio {

    private static final long serialVersionUID = 1L;

    public ClienteRepositorio(EntityManager entityManager) {
        super(entityManager);
    }

    public Cliente addCliente(Cliente cliente) {
        return addEntity(Cliente.class, cliente);
    }

    public Cliente setCliente(Cliente cliente) {
        return setEntity(Cliente.class, cliente);
    }
    

    public void removeCliente(Cliente cliente) {
        removeEntity(cliente);
    }

    public Cliente getCliente(int idOfCliente) {
        return getEntity(Cliente.class, idOfCliente);
    }

    public List<Cliente> getClienteByName(String name) {
        return getPureList(Cliente.class, "select cus from Cliente cus where cus.clinome like ?1", name + "%");
    }

    public List<Cliente> getClientesToCall(int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, (month - 1));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dataInicial = cal.getTime();

        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        Date dataFinal = cal.getTime();

        return getPureList(Cliente.class, "select orc.orccliente from Orcamento orc where orc.orcdata >= ?1 and orc.orcdata <= ?2", dataInicial, dataFinal);
    }

    public List<Cliente> getClientesComPagamentoEmAberto(int idOfCliente) {
        return getPureList(Cliente.class, "select par.parOrcamento.orcCliente from Parcela par where par.parPago = ?1", idOfCliente, Boolean.FALSE);
    }

    public Date getUltimoAtendimento(int idOfCliente) {
        try {
            Date toReturn = getPurePojo(Date.class, "select max(orc.orcdata) from Orcamento orc where orc.orccliente.cliid = ?1", idOfCliente);
            return toReturn;
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getClientesCount() {
        Long toReturn = getPurePojo(Long.class,"select count(cus) from Cliente cus");
        if (toReturn != null) return toReturn.intValue();
        return 0;
    }
}
