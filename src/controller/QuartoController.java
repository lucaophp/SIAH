/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Collection;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import model.Quarto;

/**
 *
 * @author lucas private int numero; private float valorDiaria; private String
 * descricao;
 */
public class QuartoController implements Controller {

    private static Collection<Quarto> quartos;

    public QuartoController() {
        if (quartos == null) {
            quartos = new TreeSet<>();
        }
    }

    public boolean verificaNumero(int numero) {
        for (Quarto resul : quartos) {
            if (resul.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    public void insere(int numero, float valorDiaria, String descricao) {
        if (this.verificaNumero(numero)) {
            JOptionPane.showMessageDialog(null, "Numero já existente!!!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Quarto quarto = new Quarto(numero, valorDiaria, descricao);

        this.getQuartos().add(quarto);
    }
    public void insere(Quarto quarto){
        this.getQuartos().add(quarto);
    }

    public void remove(int numero) throws OpcaoInvalidaException {

        if (!(this.verificaNumero(numero))) {
            throw new OpcaoInvalidaException("Opção invalida!!!");
        } else {
            Quarto q = this.procObj(numero);
            if (!q.isStatus()) {
                boolean remove = this.getQuartos().remove(q);
            } else {
                JOptionPane.showMessageDialog(null, "Esse quarto está ocupado!!! ");
            }

        }

    }

    public Quarto procObj(int index) {
        Quarto obj = null;
        for (Quarto val : this.getQuartos()) {
            if (val.getNumero() == index) {
                obj = val;
            }
        }
        return obj;

    }
     public String listaQuartosOcupados(){
        String saida = "";

        for (Quarto resul : this.getQuartos()) {
            if(resul.isStatus()){
            saida = saida + " Numero:" + resul.getNumero() 
                    + "\n Valor da diaria:" + resul.getValorDiaria() 
                    + "\n Descricao:" + resul.getDescricao() 
                    +"\n--------------------------------------------------------\n";
            }

        }
        if(saida.equals("")){
            return "Nenhum quarto ocupado";
        }
        return saida;
        
    }
    public String listaQuartosLivres(){
        String saida = "";

        for (Quarto resul : this.getQuartos()) {
            if(!resul.isStatus()){
            saida = saida + " Numero:" + resul.getNumero() 
                    + "\n Valor da diaria:" + resul.getValorDiaria() 
                    + "\n Descricao:" + resul.getDescricao() 
                    +"\n--------------------------------------------------------\n";
            }

        }
        if(saida.equals("")){
            return "Nenhum quarto livre";
        }
        return saida;
        
    }
    public boolean alterar(int codigo,int op,String val){
        Quarto quarto=null;
        if(this.verificaNumero(codigo)){
            quarto=this.procObj(codigo);
            if(quarto==null){
                return false;
            }else{
                switch (op) {
                    case 1:
                        quarto.setValorDiaria(Float.parseFloat(val));
                        break;
                    case 2:
                        quarto.setDescricao(val);
                        break;
                    
                    default:
                        return false;
                        
                }
                return true;
            }
              
        }
        return false;
        
    }
    public String toString() {
        String saida = "";

        for (Quarto resul : this.getQuartos()) {
            saida = saida + " Numero:" + resul.getNumero() 
                    + "\n Valor da diaria:" + resul.getValorDiaria() 
                    + "\n Descricao:" + resul.getDescricao() 
                    + "\n"+(resul.isStatus()?"Ocupado":"Livre")+
                    "\n--------------------------------------------------------\n";

        }
        if(saida.equals("")){
            return "Nenhum quarto cadastrado";
        }
        return saida;
    }

    public Collection<Quarto> getQuartos() {
        return this.quartos;
    }

    public void setQuartos(Collection<Quarto> quartos) {
        this.quartos = quartos;
    }

}
