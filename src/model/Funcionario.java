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
public class Funcionario extends Pessoa implements Comparable<Funcionario>,Serializable,Logar {
    private String cargo;
    private float salario;
    private String login;
    private String senha;
    public Funcionario(String nome, int codigo, String telefone, String cpf,String cargo,float salario,String login,String senha) {
        super(nome,codigo,telefone,cpf);
        this.cargo=cargo;
        this.salario=salario;
        this.login=login;
        this.senha=senha;
    }
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int compareTo(Funcionario f) {
        return this.getCodigo()-f.getCodigo();
    }

    @Override
    public boolean logar(String login, String senha) {
        return (this.getLogin().equals(login))&&(this.getSenha().equals(senha));
    }
    
}
