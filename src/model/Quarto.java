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
public class Quarto implements Comparable<Quarto>,Serializable{
    private int numero;
    private float valorDiaria;
    private String descricao;
    private String tipo;
    private boolean status;

    public Quarto(int numero, float valorDiaria, String descricao) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.descricao = descricao;
        this.status=false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public int compareTo(Quarto t) {
        return this.numero-t.numero;
    }
    
    
    
}
