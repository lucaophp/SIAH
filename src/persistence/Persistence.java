

package persistence;

import controller.HospedagemController;
import controller.ClienteController;
import controller.FuncionarioController;
import controller.QuartoController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Persistence {
    public Persistence(){
    }
    public void exporta(){
        HospedagemPersistence hospeda=new HospedagemPersistence();
        try {
            hospeda.guardaHospedagem(new HospedagemController().getHospedagem());
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"Problemas para exportar Hospedagem","Erro!!!",JOptionPane.ERROR_MESSAGE);
        }
        ClientePersistence cliente=new ClientePersistence();
        try {
            cliente.guardaCliente(new ClienteController().getClientes());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Problemas para exportar Cliente","Erro!!!",JOptionPane.ERROR_MESSAGE);
        }
        QuartoPersistence quarto=new QuartoPersistence();
        try {
            quarto.guardaQuarto(new QuartoController().getQuartos());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Problemas para exportar Quarto","Erro!!!",JOptionPane.ERROR_MESSAGE);
        }
        FuncionarioPersistence funcionario=new FuncionarioPersistence();
        FuncionarioController fc=new FuncionarioController();
        funcionario.guardaFuncionario(fc.getFuncionario());
    }
    public void importa(){
        try{
            ClientePersistence cliente = new ClientePersistence();
            cliente.lerCliente();
        }catch(IOException e){
            System.err.println("Erro!!! ao importar Cliente");
        }
            FuncionarioPersistence funcionario = new FuncionarioPersistence();
        try {
            funcionario.lerFuncionario();
        } catch (IOException ex) {
            System.err.println("Erro!!! ao importar Funcionario ");
        }
            QuartoPersistence quarto = new QuartoPersistence();
        try {
            quarto.lerQuartos();
        } catch (IOException ex) {
            System.err.println("Erro!!! ao importar Quartos");
        }
            HospedagemPersistence hospedagem = new HospedagemPersistence();
        try {
            hospedagem.lerHospedagem();
        } catch (IOException ex) {
            System.err.println("Erro!!! ao importar Hospedagem");
        }
       
    }
    
}
