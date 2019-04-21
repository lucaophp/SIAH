/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Collection;
import java.util.TreeSet;
import model.Funcionario;

/**
 *
 * @author lucas
 */
public class FuncionarioController implements Controller {
    private static Collection<Funcionario> funcionario;
    public FuncionarioController(){
        if(this.getFuncionario()==null){
            FuncionarioController.funcionario=new TreeSet();
        }
    }
    public boolean verificaCodigo(int codigo){
        for(Funcionario resul:this.getFuncionario()){
            if(resul.getCodigo()==codigo)
                return true;
        }
        return false;
    }
    public void insere(String nome, int codigo, String telefone, String cpf,String cargo, float salario,String login,String senha){
        Funcionario funcionario;
        funcionario = new Funcionario(nome,codigo,telefone,cpf,cargo, salario,login,senha);
        this.getFuncionario().add(funcionario);
        
        
    }
    public void insere(Funcionario funcionario){
        this.getFuncionario().add(funcionario);
    }
    public void remove(int codigo) throws OpcaoInvalidaException{
        if(!this.verificaCodigo(codigo)){
            throw new OpcaoInvalidaException("Opção invalida");
        }else{
            this.getFuncionario().remove(procObj(codigo));
        }
    }
    public boolean alterar(int codigo,int op,String val){
        Funcionario funcionario=null;
        if(this.verificaCodigo(codigo)){
            funcionario=this.procObj(codigo);
            if(funcionario==null){
                return false;
            }else{
                switch (op) {
                    case 1:
                        funcionario.setNome(val);
                        break;
                    case 2:
                        funcionario.setCpf(val);
                        break;
                    case 3:
                        funcionario.setTelefone(val);
                        break;
                    case 4:
                        
                        funcionario.setSalario(Float.parseFloat(val));
                        break;
                    case 5:
                        funcionario.setCargo(val);
                        break;
                    default:
                        return false;
                        
                }
                return true;
            }
              
        }
        return false;
        
    }
    public Funcionario procObj(int index){
        Funcionario obj=null;
        for(Funcionario val:this.getFuncionario()){
            if(val.getCodigo()==index){
                obj=val;
            }
        }
        return obj;
        
    }
    @Override
    public String toString(){
        String saida="";
        
        for(Funcionario resul:this.getFuncionario()){
            saida=saida+" Codigo:"+resul.getCodigo()+"\n Nome:"+resul.getNome()+"\n CPF:"+resul.getCpf()+"\n Telefone:"+resul.getTelefone()+"\n Salario:"+resul.getSalario()+"\n Cargo:"+resul.getCargo()+"\n--------------------------------------------------------\n";

        }
        return saida;
    }

    /*public void remove(int codigo){
    int codigo=this.pesquisa(codigo);
    }
    public int pesquisa(int codigo){
    int i=0;
    for(Cliente resul:this.clientes){
    if(codigo==resul.getCodigo()){
    codigo=resul.getCodigo();
    i++;
    }
    }
    return codigo; 
    }*/
    /**
     * @return the clientes
     */
    public Collection<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Collection<Funcionario> funcionario) {
        FuncionarioController.funcionario = funcionario;
    }

   
}

