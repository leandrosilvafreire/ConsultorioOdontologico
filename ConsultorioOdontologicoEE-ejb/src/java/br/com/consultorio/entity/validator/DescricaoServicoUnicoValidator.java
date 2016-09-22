/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity.validator;

import br.com.consultorio.entity.Servico;
import br.com.consultorio.service.ServicoServico;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Leandro
 */
public class DescricaoServicoUnicoValidator implements ConstraintValidator<DescricaoServicoUnico, Servico>{
   private final ServicoServico servicoServico = lookupServicoServicoBean();

    @Override
    public void initialize(DescricaoServicoUnico constraintAnnotation) {
    }

    @Override
    public boolean isValid(Servico value, ConstraintValidatorContext context) {
    }

    private ServicoServico lookupServicoServicoBean() {
        try {
            Context c = new InitialContext();
            return (ServicoServico) c.lookup("java:global/ConsultorioOdontologicoEE/ConsultorioOdontologicoEE-ejb/ServicoServico!br.com.consultorio.service.ServicoServico");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    
    
}
