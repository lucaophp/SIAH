

package view;

import controller.OpcaoInvalidaException;
import controller.QuartoController;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
* Classe responsavel pela entrada e saída de dados relacionadas ao quarto.
*/
public class ViewQuarto  implements View {
    //Atributo responsavel pelo armazenamento de uma controller de quarto.
    private QuartoController quarto;
    //Metodo contrutor responsavel pela instancia de um controller de quarto.
    public ViewQuarto(){
        this.setQuarto(new QuartoController());
        
    }
    //Metodos getter e setters.
    //---------------------------------------------
    public QuartoController getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoController quarto) {
        this.quarto = quarto;
    }
    //------------------------------------------------
    //Metodo responsavel pela entrada de dados referentes ao cadastro.E envio desses dados para a controller.
    public void cadastra(){
        String entrada;
        boolean continua;
        int numeroQuarto=0;
        do {
            entrada = JOptionPane.showInputDialog(null, "Digite o numero do quarto:", "Cadastro de Quarto", JOptionPane.QUESTION_MESSAGE);
            continua = false;
            try {
                numeroQuarto = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite Apenas Numeros");
                continua = true;
            }
        } while (continua);
        float valorDiaria=Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o valor da diaria:", "Cadastro de Quarto", JOptionPane.QUESTION_MESSAGE));

        Object[] tipoQuarto = {"Ouro", "Prata", "Bronze"};
        Object escolhaQuarto = JOptionPane.showInputDialog(null, "Escolha um tipo de quarto", "Cadastro de Quarto", JOptionPane.QUESTION_MESSAGE, null, tipoQuarto, tipoQuarto[0]);
        String quarto = String.format("%s", escolhaQuarto);

        String descricao=JOptionPane.showInputDialog(null, "Digite a descrição:", "Cadastro de Quarto", JOptionPane.QUESTION_MESSAGE);
        this.getQuarto().insere(numeroQuarto, valorDiaria, descricao);
    }
    //Metodo responsavel pela listagem dos quartos.
    public void listar(){
        JTextArea textArea = new JTextArea(this.getQuarto().toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Quartos cadastrados",JOptionPane.PLAIN_MESSAGE);
    }
    //Metodo responsavel pela listagem dos quartos onde não estão ocupados ou o status for false.
    public void listarQuartosLivres(){
        JTextArea textArea = new JTextArea(this.getQuarto().listaQuartosLivres());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Quartos livres cadastrados",JOptionPane.PLAIN_MESSAGE);
    }
    //Metodo responsavel pela listagem de quartos ocupados.Ou seja cujo status esteja true.
    public void listarQuartosOcupados(){
        JTextArea textArea = new JTextArea(this.getQuarto().listaQuartosOcupados());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Quartos ocupados cadastrados",JOptionPane.PLAIN_MESSAGE);
    }
    
    //Metodo responsavel pela entrada de dados relacionadas a remoção de quartos.
    @Override
    public void remove() {
        try {
            String entrada = JOptionPane.showInputDialog(null, "Digite o numero do quarto a ser removido");
            this.getQuarto().remove(Integer.parseInt(entrada));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Apenas números!!!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (OpcaoInvalidaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO!!!", JOptionPane.ERROR_MESSAGE);

        }
    }

   
    //Metodo responsavel pela alteração de dados referentes ao quarto. 
    @Override
    public void alterar() {
        try {
            int codQuarto=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do quarto:\n" + this.getQuarto()));
            int op=Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o campo deseja alterar?\n"
                    + "1-Valor da diaria\n"
                    + "2-Descricao\n"));
            if(op<0||op>2){
                throw new OpcaoInvalidaException("Opção invalida!!!");
            }
            String valor=JOptionPane.showInputDialog(null, "Qual o valor que deseja para esse campo");
            if(this.getQuarto().alterar(codQuarto, op, valor)){
                JOptionPane.showMessageDialog(null, "Alteração feita com sucesso!!!","Sucesso!!!",JOptionPane.DEFAULT_OPTION);
            }else{
                JOptionPane.showMessageDialog(null, "Alteração não pode ser feita!!!","Erro!!!",JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Apenas números!!!");
        }catch(OpcaoInvalidaException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
            
        }

    }
    
    
}
