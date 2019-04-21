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
public class Hospedagem implements Comparable<Hospedagem>,Serializable {
    private int codigo;
    private int dias;
    private Cliente hospede;
    private Quarto quarto;
    private Conta conta;

    public Hospedagem(int codigo,  Cliente hospede, Quarto quarto) {
        this.codigo = codigo;
        this.hospede = hospede;
        this.quarto = quarto;
        this.conta = conta;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    

  
    /**
     * @return the hospede
     */
    public Cliente getHospede() {
        return hospede;
    }

    /**
     * @param hospede the hospede to set
     */
    public void setHospede(Cliente hospede) {
        this.hospede = hospede;
    }

    /**
     * @return the quarto
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public int compareTo(Hospedagem o) {
       return this.codigo-o.codigo;
    }
    
}
