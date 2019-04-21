/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author lucas
 */
public class Produto extends Consumos {
    public Produto(String nome,float valor){
        super.setNome(nome);
        super.setValor(valor);
    }
    
}
