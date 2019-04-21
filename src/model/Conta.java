/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Conta implements Serializable,CalculaDiaria,Pagar {
    private int codigo;
    private float valorTotal;
    private boolean pago;
    private static ArrayList<Consumos> consumo;

    public Conta(){
        if(Conta.consumo==null){
            Conta.consumo=new ArrayList();
        }
        this.calculaConsumos();
        
    }
    public void insereConsumo(Consumos consumo){
        if(Conta.consumo==null){
            this.setConsumo(new ArrayList());
        }
        this.getConsumo().add(consumo);
        this.calculaConsumos();
            
        
        
    }
    public void calculaConsumos(){
       /* float valor=0;
        for(Consumos c:this.getConsumo()){
            valor=valor+c.getValor();
        }
        this.setValorTotal(valor);*/
        
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public ArrayList<Consumos> getConsumo() {
        return consumo;
    }

    public void setConsumo(ArrayList<Consumos> consumo) {
        Conta.consumo = consumo;
    }

    @Override
    public float calculaDiaria(float valorDiaria,int numAcompanhantes,int dias) {
        return (valorDiaria*numAcompanhantes)*dias;
    }

    @Override
    public void pagar() {
        this.setPago(true);
    }
    
    
    
    
}
