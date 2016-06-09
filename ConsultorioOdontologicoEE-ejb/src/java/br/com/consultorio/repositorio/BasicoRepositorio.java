/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.repositorio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Leandro
 */
public abstract class BasicoRepositorio {
    
    private final EntityManager entityManager;
    
    public BasicoRepositorio(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    protected EntityManager getEntityManager(){
        return entityManager;
    }
    
    //salva um obejeto
    protected <T> T addEntity(Class<T> classToCast, Object entity){
        getEntityManager().persist(entity);
        return (T) entity;
    }
    
    //Retorna um obejeto
    protected <T> T getEntity(Class<T> classToCast, Serializable pk){
        return getEntityManager().find(classToCast, pk);
    }
    
    //Atualiza um obejeto
    protected <T> T setEntity(Class<T> classToCast, Object entity){
        Object updateObj = getEntityManager().merge(entity);
        return (T) updateObj;
    }
    
    //remove um obejeto
    protected void removeEntity(Object entity) {
        Object upObject = getEntityManager().merge(entity);
        getEntityManager().remove(upObject);
        
    }
    
    //Método que vai retornar uma lista
    protected <T> List<T> getPureList(Class<T> classToCast,String query,Object... values){
        
        Query qr = createQuery(query, values);
        return qr.getResultList();
        
    }
    
    //Método que vai retornar uma query comando hql
    protected <T> T getPuroPojo(Class<T> classToCast,String query,Object... values){
        Query qr = createQuery(query, values);
        return  (T) qr.getSingleResult();
    }
    
    protected int executeCommand(String query, Object... values){
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }
    
    private Query createQuery(String query, Object... values){
        Query qr = getEntityManager().createQuery(query);
        for(int i=0; i<values.length; i++){
            qr.setParameter(i, values[i]);
        }
        return qr;
    }
    
    
    
    
    
    
    
}
