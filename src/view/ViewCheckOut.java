
package view;
//importação das classes necessarias para o funcionamento da classe.
import controller.HospedagemController;
import controller.ClienteController;
import controller.QuartoController;
import javax.swing.JOptionPane;
/**
* Classe responsavel pela entrada de dados relacionadas ao check-out de um cliente com um quarto.
* @package view
*/

public class ViewCheckOut {
    //Atributos responsaveis pelo armazenamento das controllers necessarias.
    //----------------------------------------------------------
    private ClienteController cliente;
    private QuartoController quarto;
    private HospedagemController check;
    //----------------------------------------------------------
    //Construtor responsavel pelas instancias dos atributos.
    public ViewCheckOut(){
        this.setCheck(new HospedagemController());
        this.setCliente(new ClienteController());
        this.setQuarto(new QuartoController());
        
    }
    //Metodos Getters e Setters.
    //--------------------------------------------
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

    public HospedagemController getCheck() {
        return check;
    }

    public void setCheck(HospedagemController check) {
        this.check = check;
    }
    //-------------------------------------------------
    /*
      Metodo responsavel pelas entradas de dados relacionadas ao check-out.
      Esse metodo tambem é responsavel pelo envio desses dados para a HospedagemController().
    */
    public void start(){
       int codigo= Integer.parseInt(JOptionPane.showInputDialog(null, this.getCheck(),"Digite o codigo do quarto:"));
       int dias=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quantidade de dias em que o hospede ficou hospedado:"));
       float consumo=Float.parseFloat(JOptionPane.showInputDialog(null,"Digite o valor consumido:(use notação americana de decimal)"));
       if(this.getCheck().checkOut(codigo, dias, consumo)){
           JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso","Sucesso!!!",JOptionPane.DEFAULT_OPTION);
       }else{
           JOptionPane.showMessageDialog(null, "Pagamento efetuado com falha","Erro!!!",JOptionPane.ERROR_MESSAGE);
       }
       
    }

    

    
    
}
