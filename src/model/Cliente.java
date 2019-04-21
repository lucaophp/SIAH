/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

/**
 *
 * @author lucas
 */
public class Cliente extends Pessoa implements Comparable<Cliente>,Serializable {
    private int acompanhantes;

    public Cliente(String nome, int codigo, String telefone, String cpf,int acompanhantes) {
        super(nome,codigo,telefone,cpf);
        this.setAcompanhantes(acompanhantes);
    }

   
    public int getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(int acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    @Override
    public int compareTo(Cliente t) {
        
        return this.getCodigo()-t.getCodigo();
    }
    
     
}
