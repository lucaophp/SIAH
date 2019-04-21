
package persistence;

import controller.ClienteController;
import controller.FuncionarioController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import model.Cliente;
import model.Funcionario;


public class ClientePersistence {
    private File arquivo;
     public ClientePersistence(){
        try {
            this.setArquivo(new File("Cliente.bin"));

            // Create file if it does not exist  
            boolean success = this.getArquivo().createNewFile();
            if (success) {
                // File did not exist and was created  
            } else {
                // File already exists  
            }
        } catch (IOException e) {
        }
    }
    public void guardaCliente(Collection<Cliente> cliente) throws IOException {
        FileOutputStream gravarBinario = null;
        ObjectOutputStream gravarObjeto = null;
        try {
            gravarBinario = new FileOutputStream("Cliente.bin");
            gravarObjeto = new ObjectOutputStream(gravarBinario);

            for (Cliente resul : cliente) {
                gravarObjeto.writeObject(resul);
            }
            gravarObjeto.flush();
            gravarObjeto.close();
            gravarBinario.flush();
            gravarBinario.close();

        } catch (FileNotFoundException e) {
            FileWriter f = null;
            try {
                f = new FileWriter("Cliente.bin");
            } catch (IOException ex) {
                System.out.println("Erro na gravação do arquivo");
            } finally {
                f.close();
                this.guardaCliente(cliente);
            }
        } catch (IOException e) {
        }
    }

    public void lerCliente() throws  IOException {

// Lê binários de um fluxo de entrada
        FileInputStream lerFluxo = new FileInputStream("Cliente.bin");
// Desserializa objetos de um fluxo de entrada
        ObjectInputStream lerObjeto = new ObjectInputStream(lerFluxo);
        Cliente cliente;
        try {
            while (true) {
                cliente = (Cliente) lerObjeto.readObject();
                ClienteController fc = new ClienteController();
                fc.insere(cliente);
            }

        }catch (FileNotFoundException e) {
            FileWriter f = null;
            try {
                f = new FileWriter("Cliente.bin");
            } catch (IOException ex) {
                System.out.println("Erro na gravação do arquivo");
            } finally {
                f.close();
               // this.guardaCliente(cliente);
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

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
    
}
