
package persistence;

import controller.QuartoController;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Quarto;


public class QuartoPersistence {

    private File arquivo;

    public QuartoPersistence() {
        // this.setArquivo("Quarto.bin");
    }

    public void guardaQuarto(Collection<Quarto> quarto) throws IOException {
        FileOutputStream gravarBinario = null;
        ObjectOutputStream gravarObjeto = null;
        try {
            gravarBinario = new FileOutputStream("Quarto.bin");
            gravarObjeto = new ObjectOutputStream(gravarBinario);
            QuartoController q = new QuartoController();
            for (Quarto resul : q.getQuartos()) {
                gravarObjeto.writeObject(resul);
            }
            gravarObjeto.flush();
            gravarObjeto.close();
            gravarBinario.flush();
            gravarBinario.close();

        } catch (FileNotFoundException e) {
            FileWriter f = null;
            try {
                f = new FileWriter("Quarto.bin");
            } catch (IOException ex) {
                Logger.getLogger(QuartoPersistence.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                f.close();
                this.guardaQuarto(quarto);
            }
        } catch (IOException e) {
        }
    }

    public void lerQuartos() throws FileNotFoundException, IOException {

// Lê binários de um fluxo de entrada
        FileInputStream lerFluxo = new FileInputStream("Quarto.bin");
// Desserializa objetos de um fluxo de entrada
        ObjectInputStream lerObjeto = new ObjectInputStream(lerFluxo);
        Quarto quarto;
        try {
            while (true) {
                quarto = (Quarto) lerObjeto.readObject();
                QuartoController qc = new QuartoController();
                qc.insere(quarto);
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
