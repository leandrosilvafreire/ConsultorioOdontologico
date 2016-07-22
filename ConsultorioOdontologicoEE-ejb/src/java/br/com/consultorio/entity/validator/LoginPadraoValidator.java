/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Leandro
 */
public class LoginPadraoValidator implements ConstraintValidator<LoginPadrao, String>{

    @Override
    public void initialize(LoginPadrao constraintAnnotation) {
        System.out.println("[LoginPadraoValidator] Carregado com a mensagem - "+constraintAnnotation.message());
    }

    
       
    
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
               return (value != null && value.contains(".") && value.charAt(value.length()-1) != '.');

    }
    
    
}
