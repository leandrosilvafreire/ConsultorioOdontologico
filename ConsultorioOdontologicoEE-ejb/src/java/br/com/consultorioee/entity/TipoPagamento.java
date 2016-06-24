/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consultorioee.entity;

/**
 *
 * @author Leandro
 */
public enum TipoPagamento {
    DINHEIRO("Dinheiro"), CREDITO("Crédito"), DEBITO("Débito");
    
    private final String descricao;
    
    TipoPagamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}

