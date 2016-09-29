/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorio.entity.validator;

import br.com.consultorio.entity.Servico;
import br.com.consultorio.service.ServicoServico;
import java.util.List;
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
        System.out.println("[DescricaoServicoUnicoValidator] Carregado com a mensagem - " + constraintAnnotation.message());
    }

    @Override
    public boolean isValid(Servico value, ConstraintValidatorContext context) {
        
        if (value == null){
            return true;
        }
        List <Servico> serviceWithSameDescList  = servicoServico.getServicosByName(value.getSernome());
        boolean valid = true;
        for(Servico servico : serviceWithSameDescList){
            if(servico.getSernome().equalsIgnoreCase(value.getSernome()) && !servico.equals(value)){
                valid = false;
                break;
            }
        }
        return valid;
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
