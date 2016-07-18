/*
 * Copyright (C) 2014 Leandro
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

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author dyego.carmo
 */
abstract class BasicoRepositorio {

    private static final long serialVersionUID = 1L;
    
    private final EntityManager entityManager;

    public BasicoRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    protected <T> T addEntity(Class<T> classToCast,Object entity) {
        getEntityManager().persist(entity);
        return (T) entity; 
    }
    
    protected <T> T getEntity(Class<T> classToCast,Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }
    
    protected <T> T setEntity(Class<T> classToCast,Object entity) {
        Object updatedObj = getEntityManager().merge(entity);
        return (T) updatedObj;
    }
    
    protected void removeEntity(Object entity) {
        Object updateObj = getEntityManager().merge(entity);
        getEntityManager().remove(updateObj);
    }
    
    protected <T> List<T> getPureList(Class<T> classToCast,String query,Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    
    protected <T> T getPurePojo(Class<T> classToCast,String query,Object... values) {
        Query qr = createQuery(query, values);
        return (T) qr.getSingleResult();
    }
    
    protected int executeCommand(String query,Object... values) {
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }
    
    private Query createQuery(String query,Object... values) {
        Query qr = getEntityManager().createQuery(query);
        for (int i = 0; i < values.length; i++) {
            qr.setParameter((i+1), values[i]);
        }
        return qr;
    }
    
    
    
    
}
