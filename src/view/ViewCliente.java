
package view;
//importação de Classes e interfaces necessarias.
import controller.ClienteController;
import controller.OpcaoInvalidaException;
import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
* Classe responsavel pela entrada e saída de dados relacionadas ao cliente.
*/
public class ViewCliente implements View {
    //Atributo responsavel pelo armazenamento da controller de cliente.
    private ClienteController cliente;
    //Metodo construtor responsavel por instanciar a controller de cliente.
    public ViewCliente() {
        this.setCliente(new ClienteController());

    }
    //Metodos Getters e Setters.
    //----------------------------------------------------
    public ClienteController getCliente() {
        return cliente;
    }

    public void setCliente(ClienteController cliente) {
        this.cliente = cliente;
    }
    //----------------------------------------------------
    /*
        Metodo responsavel pelo cadastro do cliente.
        Metodo de entrada de dados do cliente,e envio para a controller.
    */
    public void cadastra() {
        //int numeroAcompanhantes=0;

        boolean continuar = true;
        String codigoCliente;
        String nomeCliente;
        String cpfCliente;
        String telefoneCliente;
        int numeroAcompanhantes;
        //Esses Do while são responsaveis pelo "tratamento" dos dados não deixando ter dados nulos.
        do {
            codigoCliente = JOptionPane.showInputDialog(null, "Digite o codigo:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE);
            if (codigoCliente.equals("") || codigoCliente == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        do {

            nomeCliente = JOptionPane.showInputDialog(null, "Digite o nome:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE);
            if (nomeCliente.equals("") || nomeCliente == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        do {

            cpfCliente = JOptionPane.showInputDialog(null, "Digite o CPF:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE);
            if (cpfCliente.equals("") || cpfCliente == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        do {

            telefoneCliente = JOptionPane.showInputDialog(null, "Digite o Telefone:", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE);
            if (telefoneCliente.equals("") || telefoneCliente == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        
        do {
            Object[] escolha = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            Object escolhaAcompanhantes = JOptionPane.showInputDialog(null, "Escolha um numero de Acompanhantes", "Cadastro de Clientes", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

            continuar = false;

            try {
                numeroAcompanhantes = Integer.parseInt(String.format("%s", escolhaAcompanhantes));
                this.getCliente().insere(nomeCliente, Integer.parseInt(codigoCliente), telefoneCliente, cpfCliente, numeroAcompanhantes);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite Apenas Numeros");
                continuar = true;
            }
        } while (continuar);
    }
    //Metodo responsavel pela listagem dos clientes.
    @Override
    public void listar() {
        JTextArea textArea = new JTextArea(this.getCliente().toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        JOptionPane.showMessageDialog(null, scrollPane, "Clientes cadastrados", JOptionPane.PLAIN_MESSAGE);
    }
    //Metodo responsavel pela alteração de dados de um cliente.
    @Override
    public void alterar() {
        try {
            int codCliente=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do cliente:\n" + this.getCliente()));
            int op=Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o campo deseja alterar?\n"
                    + "1-Nome\n"
                    + "2-CPF\n"
                    + "3-Telefone\n"
                    + "4-Número de acompanhantes\n"));
            if(op<0||op>4){
                //Gera uma nova Exceção.Caso a Opção estiver errada.
                throw new OpcaoInvalidaException("Opção invalida!!!");
            }
            //Entrada do valor em que o usuario deseje alterar.
            String valor=JOptionPane.showInputDialog(null, "Qual o valor que deseja para esse campo");
            //verifica  se a alteração foi feita com sucesso ou não.
            if(this.getCliente().alterar(codCliente, op, valor)){
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
    //Metodo responsavel pela entrada de dados para a remoção de um cliente.E o envio para controller.
    @Override
    public void remove() {
        try {
            JTextArea textArea = new JTextArea(this.getCliente().toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            //textArea.setLineWrap(true);
            textArea.setOpaque(false);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(300, 300));
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, "Digite o codigo a ser removido:", JOptionPane.PLAIN_MESSAGE));
            this.getCliente().remove(codigo);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Apenas número!!!");
            this.remove();
        } catch (OpcaoInvalidaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
