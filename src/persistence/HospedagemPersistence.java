
package persistence;

import controller.HospedagemController;
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
import model.Funcionario;
import model.Hospedagem;


public class HospedagemPersistence {
    private File arquivo;

    
    public HospedagemPersistence(){
        try {
            this.setArquivo(new File("Hospedagem.bin"));

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
    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
    public void guardaHospedagem(Collection<Hospedagem> hospedagem) throws IOException {
        FileOutputStream gravarBinario = null;
        ObjectOutputStream gravarObjeto = null;
        try {
            gravarBinario = new FileOutputStream("Hospedagem.bin");
            gravarObjeto = new ObjectOutputStream(gravarBinario);
            FuncionarioController q = new FuncionarioController();
            for (Hospedagem resul : hospedagem) {
                gravarObjeto.writeObject(resul);
            }
            gravarObjeto.flush();
            gravarObjeto.close();
            gravarBinario.flush();
            gravarBinario.close();

        } catch (FileNotFoundException e) {
            FileWriter f = null;
            try {
                f = new FileWriter("Hospedagem.bin");
                f.close();
                this.guardaHospedagem(hospedagem);
            } catch (IOException ex) {
                System.out.println("Erro na gravação do arquivo");
                f.close();
            } 
        } catch (IOException e) {
        }
    }

    public void lerHospedagem() throws FileNotFoundException, IOException {

// Lê binários de um fluxo de entrada
        FileInputStream lerFluxo = new FileInputStream("Hospedagem.bin");
// Desserializa objetos de um fluxo de entrada
        ObjectInputStream lerObjeto = new ObjectInputStream(lerFluxo);
        Hospedagem hospedagem;
        try {
            while (true) {
                hospedagem = (Hospedagem) lerObjeto.readObject();
                System.out.println(hospedagem);
                HospedagemController fc = new HospedagemController();
                fc.insere(hospedagem);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("erro");
        } catch (EOFException e) {
            
        } finally {
            lerObjeto.close();
            lerFluxo.close();
        }

    }
    
    
}
