/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Collection;
import java.util.TreeSet;
import model.Cliente;
import model.Consumos;
import model.Conta;
import model.Hospedagem;
import model.Pagar;
import model.Produto;
import model.Quarto;

/**
 *
 * @author lucaophp
 */
public class HospedagemController {
    private static Collection<Hospedagem> hospedagem;
    public HospedagemController(){
        if(this.getHospedagem()==null){
         this.setHospedagem(new TreeSet());
        }
        
    }
    public Cliente procCliente(int index){
        ClienteController cliente=new ClienteController();
        return cliente.procObj(index);
    }
    public Quarto procQuarto(int index){
        QuartoController quarto= new QuartoController();
        return quarto.procObj(index);
        
    }
    public void hospeda(int codigo,int codigoCliente,int numeroQuarto){
        Quarto quarto=this.procQuarto(numeroQuarto);
        Cliente cliente=this.procCliente(codigoCliente);
        Hospedagem hospedagem=new Hospedagem(codigo,cliente,quarto);
        hospedagem.getQuarto().setStatus(true);
        this.getHospedagem().add(hospedagem);
        
        
    }
    public void insere(Hospedagem hospedagem){
        this.getHospedagem().add(hospedagem);
    }
    public boolean checkOut(int codigoQuarto,int dias,float consumo){
        
        Hospedagem hospedagem=this.procObj(codigoQuarto);
        
        if(hospedagem!=null){
            try {
                hospedagem.setDias(dias);
               // hospedagem.getConta().insereConsumo(new Produto("Total de consumos do cliente " + hospedagem.getHospede().getNome(), consumo));
                Pagar p = new Conta();
                p.pagar();
                hospedagem.getQuarto().setStatus(false);
                this.getHospedagem().remove(hospedagem);
                return true;
            } catch (Exception e) {
                return false;
            }
            
            
        }else{
            return false;
        }
    }
    public Hospedagem procObj(int codQuarto){
        for(Hospedagem resul:this.getHospedagem()){
            if(resul.getQuarto().getNumero()==codQuarto){
                
                    return resul;
                
            }
        }
        return null;
    }
    @Override
    public String toString(){
        String retorno="";
        for(Hospedagem resul:this.getHospedagem()){
            retorno=(retorno+"Nome do hospede:"+resul.getHospede().getNome()+"\n Número do quarto:"+resul.getQuarto().getNumero()+"\n------------------------------------------------------------\n");
        }
        return retorno;
    }

    public Collection<Hospedagem> getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Collection<Hospedagem> hospedagem) {
        HospedagemController.hospedagem = hospedagem;
    }

  
    
}
