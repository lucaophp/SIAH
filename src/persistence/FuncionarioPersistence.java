
package persistence;

import controller.FuncionarioController;
import controller.QuartoController;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;

/**
 *
 * @author lucaophp
 */
public class FuncionarioPersistence {

    public void guardaFuncionario(Collection<Funcionario> funcionario)  {
        FileOutputStream gravarBinario = null;
        ObjectOutputStream gravarObjeto = null;
        try {
            gravarBinario = new FileOutputStream("Funcionario.bin");
            gravarObjeto = new ObjectOutputStream(gravarBinario);
            FuncionarioController q = new FuncionarioController();
            for (Funcionario resul : q.getFuncionario()) {
                gravarObjeto.writeObject(resul);
            }
            gravarObjeto.flush();
            gravarObjeto.close();
            gravarBinario.flush();
            gravarBinario.close();

        } catch (FileNotFoundException e) {
            FileWriter f = null;
            try {
                f = new FileWriter("Funcionario.bin");
                
                f.close();
                this.guardaFuncionario(funcionario);
            } catch (IOException ex) {
                System.out.println("Erro na gravação do arquivo");
                try {
                    f.close();
                } catch (IOException ex1) {
                    Logger.getLogger(FuncionarioPersistence.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } 
        } catch (IOException e) {
        }
    }

    public void lerFuncionario() throws FileNotFoundException, IOException {

// Lê binários de um fluxo de entrada
        FileInputStream lerFluxo = new FileInputStream("Funcionario.bin");
// Desserializa objetos de um fluxo de entrada
        ObjectInputStream lerObjeto = new ObjectInputStream(lerFluxo);
        Funcionario funcionario;
        try {
            while (true) {
                funcionario = (Funcionario) lerObjeto.readObject();
                FuncionarioController fc = new FuncionarioController();
                fc.insere(funcionario);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("erro");
        } catch (EOFException e) {
            return;
        } finally {
            lerObjeto.close();
            lerFluxo.close();
        }

    }
}
