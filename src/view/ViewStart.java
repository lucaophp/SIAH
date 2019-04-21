package view;

import controller.LoginController;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistence.FuncionarioPersistence;
import persistence.Persistence;
import persistence.QuartoPersistence;
//Classe responsavel pelo login, e pela chamada classe "Principal" responsavel pela interface grafica do sistema.
public final class ViewStart {

    
    //Metodo construtor que chama o metodo instruções
    public ViewStart() {
        

        this.instrucoes();

    }

   
    //Metodo instruções chama principal()
    public void instrucoes() {
        this.principal();
    }
    //Metodo login responsavel pela entrada de dados do login.E pela validação do mesmo.
    public void login() {
        LoginController loginC = new LoginController();
        String login;
        String senha;
        do {
            login = JOptionPane.showInputDialog(null, "Digite seu login:\n Dica:o login do funcionario ou (adm)");
            senha = JOptionPane.showInputDialog(null, "Digite sua senha:\n Dica:a senha do funcionario ou (adm)");
            if(!loginC.verifica(login, senha)){
                JOptionPane.showMessageDialog(null,"Login Invalido!!!\n Tente novamente!!!","Erro",JOptionPane.ERROR_MESSAGE);
            }
        } while (!loginC.verifica(login, senha));

    }

    public void principal() {
        
        Persistence persistencia = new Persistence();

        persistencia.importa();

        this.login();
        Principal p = new Principal();
        p.setVisible(true);
        
    }

}
