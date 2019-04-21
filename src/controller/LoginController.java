/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Funcionario;

/**
 *
 * @author lucaophp
 */
public class LoginController {
    private FuncionarioController funcionario;
    public LoginController(){
        this.funcionario=new FuncionarioController();
        
    }

   
    public boolean verifica(String login,String senha){
        for(Funcionario val:this.getFuncionario().getFuncionario()){
            if(val.logar(login, senha)){
                return true;
            }
        }
        if(login.equals("adm")&&senha.equals("adm")){
            return true;
        }
        return false;
    }

    public FuncionarioController getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioController funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
}
