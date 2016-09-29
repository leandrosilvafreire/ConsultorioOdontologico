/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.controle;

import java.io.Serializable;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Leandro
 * @version 1.0
 * @since 06/2014
 */
public abstract class BasicoControle implements java.io.Serializable {
    
    
    private static final long serialVersionUID = 1L;

    protected void createFacesErrorMessage(String msg) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    
    //Retorna todas as validações
    protected Set<ConstraintViolation<Serializable>> getViolations(Serializable entidade){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Serializable>> toReturn = validator.validate(entidade);
        return toReturn;
    }
    
    //Pega todas as mensagens e joga para a tela
    protected boolean existsViolationsForJSF(Serializable entidade){
        Set<ConstraintViolation<Serializable>> toReturn = getViolations(entidade);
        if(toReturn.isEmpty()) return false;
        for(ConstraintViolation<Serializable> constraintViolation : toReturn){
            createFacesErrorMessage(constraintViolation.getMessage());
        }
        return true;
    }
}

