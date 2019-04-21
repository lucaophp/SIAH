

package view;
//importação das classes e interfaces necessarias.
import controller.HospedagemController;
import controller.ClienteController;
import controller.QuartoController;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
* Classe responsavel pela entrada de dados relacionadas ao check-in de um cliente com um quarto.
* @package View
*/
public class ViewCheckIn {
    /*
    Atributos responsaveis pelo armazenamento de uma instacia das controllers.
    */
    //-------------------------------------------------------------------
    private ClienteController cliente;
    private QuartoController quarto;
    private HospedagemController check;
    //--------------------------------------------------------------------
    //Construtor ViewCheckIn responsavel por instanciar as controllers para que possa ser usada no programa.
    public ViewCheckIn(){
        this.setCheck(new HospedagemController());
        this.setCliente(new ClienteController());
        this.setQuarto(new QuartoController());
        
    }
    //Metodos getters e setters
    //----------------------------------------------------------
    public HospedagemController getCheck() {
        return check;
    }

    public void setCheck(HospedagemController check) {
        this.check = check;
    }

    public ClienteController getCliente() {
        return cliente;
    }

    public void setCliente(ClienteController cliente) {
        this.cliente = cliente;
    }

    public QuartoController getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoController quarto) {
        this.quarto = quarto;
    }
    //----------------------------------------------------------
    /**
    * Metodo cadastra(),responsavel pela entrada dos dados referentes ao cadastro de um check-in.
    * Esses dados são enviados para a controller de hospedagem.
    * 
    */
    public void cadastra(){
        String codigo=JOptionPane.showInputDialog(null,"Digite o codigo de hospedagem:");
        JTextArea textArea = new JTextArea(this.getCliente().toString()+"\n\tDigite o codigo do cliente:");
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        String codigoCliente= JOptionPane.showInputDialog(null, scrollPane, "Digite o codigo do cliente",JOptionPane.PLAIN_MESSAGE);
        textArea.setText(this.getQuarto().listaQuartosLivres()+"\n\tDigite o numero do quarto: ");
        String numeroQuarto=JOptionPane.showInputDialog(null, scrollPane, "Digite o número do quarto",JOptionPane.PLAIN_MESSAGE);
        
        try{
            this.getCheck().hospeda(Integer.parseInt(codigo),  Integer.parseInt(codigoCliente), Integer.parseInt(numeroQuarto));
            System.out.println(this.getCheck());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro!!! Apenas Numero nos campos de codigo.");
            
        }
        
    }
    /**
    * Metodo listar() responsavel pela listagem dos check-ins.
    * 
    */
    public void listar(){
        JOptionPane.showMessageDialog(null, this.getCheck());
    }
    
}
