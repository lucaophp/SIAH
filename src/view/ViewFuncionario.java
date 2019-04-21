

package view;

import controller.FuncionarioController;
import controller.OpcaoInvalidaException;
import javax.swing.JOptionPane;

/**
* Classe responsavel pela entrada e saída de dados relacionadas ao funcionario.
*/
public class ViewFuncionario implements View {
    //atributo que armazena um objeto de FuncionarioController
    private FuncionarioController funcionarios;
    //metodo construtor responsavel pela instancia do FuncionarioController
    public ViewFuncionario(){
        this.setFuncionarios(new FuncionarioController());
        
    }
    //getter e setters
    public FuncionarioController getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(FuncionarioController funcionarios) {
        this.funcionarios = funcionarios;
    }
     //Toda entrada de dados relacionadas ao cadastro de funcionarios entram por aqui e são mandadas para a FuncionarioController.
    public void cadastra(){
        boolean continuar = true;
        String codigoFuncionario;
        String nomeFuncionario;
        String cpfFuncionario;
        String telefoneFuncionario;
        String loginFuncionario;
        String senhaFuncionario;

        do {
            codigoFuncionario = JOptionPane.showInputDialog(null, "Digite o codigo:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            if (codigoFuncionario.equals("") || codigoFuncionario == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);
        do {
            loginFuncionario = JOptionPane.showInputDialog(null, "Digite o login:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            if (codigoFuncionario.equals("") || codigoFuncionario == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);
        do {
            senhaFuncionario = JOptionPane.showInputDialog(null, "Digite a senha:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            if (codigoFuncionario.equals("") || codigoFuncionario == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        do {
            nomeFuncionario = JOptionPane.showInputDialog(null, "Digite o nome:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            if (nomeFuncionario.equals("") || nomeFuncionario == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        do {
            cpfFuncionario = JOptionPane.showInputDialog(null, "Digite o CPF:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            if (cpfFuncionario.equals("") || cpfFuncionario == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        do {
            telefoneFuncionario = JOptionPane.showInputDialog(null, "Digite o Telefone:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            if (telefoneFuncionario.equals("") || telefoneFuncionario == null) {
                JOptionPane.showMessageDialog(null, "Este campo năo pode permanecer vazio", "Cadastro de Funcionario", JOptionPane.ERROR_MESSAGE);
                continuar = true;
            } else {
                continuar = false;
            }
        } while (continuar);

        Object[] cargo = {"Proprietario", "Gerente", "Funcionario", "Estagiario"};
        Object escolhaCargo = JOptionPane.showInputDialog(null, "Escolha um Cargo", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE, null, cargo, cargo[0]);
        String cargoFuncionario = String.format("%s", escolhaCargo);

        String entrada;
        
        do {
            entrada = JOptionPane.showInputDialog(null, "Digite o salario:", "Cadastro de Funconarios", JOptionPane.QUESTION_MESSAGE);
            continuar = false;
            try {
                float salarioFuncionario = Float.parseFloat(entrada);
                this.getFuncionarios().insere(nomeFuncionario, Integer.parseInt(codigoFuncionario), telefoneFuncionario, cpfFuncionario, cargoFuncionario, salarioFuncionario,loginFuncionario,senhaFuncionario);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite Apenas Numeros");
                continuar = true;
            }
        } while (continuar);

    }
    //Metodo responsavel pela listagem dos funcionarios.
    public void listar(){
        JOptionPane.showMessageDialog(null, this.getFuncionarios(), "Listar Funcionario", JOptionPane.DEFAULT_OPTION);
    }
    //Metodo responsavel pela entrada de dados relacionadas a remoção de funcionarios
    public void remove(){
        String codigo=JOptionPane.showInputDialog(null, this.getFuncionarios(), "Listar Funcionario", JOptionPane.DEFAULT_OPTION);
        try{
            this.getFuncionarios().remove(Integer.parseInt(codigo));
        }catch(NumberFormatException e){
            
        }catch(OpcaoInvalidaException e){
        }
    }

    
    //Metodo responsavel pela entrada de dados para alteração de atributos da classe funcionario.
   @Override
    public void alterar() {
        try {
            int codFuncionario=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do funcionario:\n" + this.getFuncionarios()));
            int op=Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o campo deseja alterar?\n"
                    + "1-Nome\n"
                    + "2-CPF\n"
                    + "3-Telefone\n"
                    + "4-Salario\n"
                    + "5-Cargo\n"));
            if(op<0||op>5){
                throw new OpcaoInvalidaException("Opção invalida!!!");
            }
            String valor=JOptionPane.showInputDialog(null, "Qual o valor que deseja para esse campo");
            if(this.getFuncionarios().alterar(codFuncionario, op, valor)){
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
