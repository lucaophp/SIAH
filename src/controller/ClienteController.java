/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.util.Collection;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import model.Cliente;
/**
 *
 * @author lucas
 */
public class ClienteController implements Controller {
    private static Collection<Cliente> clientes;
    public ClienteController(){
        if(this.getClientes()==null){
            ClienteController.clientes=new TreeSet();
        }
    }
    /**
     * @return the clientes
     */
    public Collection<Cliente> getClientes() {
        return ClienteController.clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Collection<Cliente> clientes) {
        ClienteController.clientes = clientes;
    }
    public boolean verificaCodigo(int codigo){
        for(Cliente resul:ClienteController.clientes){
            if(resul.getCodigo()==codigo)
                return true;
        }
        return false;
    }
    public void insere(String nome, int codigo, String telefone, String cpf,int numeroAcompanhantes){
        if(this.verificaCodigo(codigo)){
            JOptionPane.showMessageDialog(null, "Codigo já existente!!!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Cliente cliente;
        cliente = new Cliente(nome,codigo,telefone,cpf,numeroAcompanhantes);
        this.getClientes().add(cliente);
        
        
    }
    public void insere(Cliente cliente){
        this.getClientes().add(cliente);
    }
    public void remove(int codigo) throws OpcaoInvalidaException{
        if(!this.verificaCodigo(codigo)){
            throw new OpcaoInvalidaException("Opção invalida");
        }else{
            this.getClientes().remove(procObj(codigo));
        }
    }
    public boolean alterar(int codigo,int op,String val){
        Cliente cliente=null;
        if(this.verificaCodigo(codigo)){
            cliente=this.procObj(codigo);
            if(cliente==null){
                return false;
            }else{
                switch (op) {
                    case 1:
                        cliente.setNome(val);
                        break;
                    case 2:
                        cliente.setCpf(val);
                        break;
                    case 3:
                        cliente.setTelefone(val);
                        break;
                    case 4:

                        cliente.setAcompanhantes(Integer.parseInt(val));
                        break;
                    
                    default:
                        return false;
                        
                }
                return true;
            }
              
        }
        return false;
        
    }
    public Cliente procObj(int index){
        Cliente obj=null;
        for(Cliente val:this.getClientes()){
            if(val.getCodigo()==index){
                obj=val;
            }
        }
        return obj;
        
    }
    @Override
    public String toString(){
        String saida="";
        
        for(Cliente resul:this.getClientes()){
            saida=saida+" Codigo:"+resul.getCodigo()+"\n Nome:"+resul.getNome()+"\n CPF:"+resul.getCpf()+"\n Telefone:"+resul.getTelefone()+"\n Número de acompanhantes:"+resul.getAcompanhantes()+"\n--------------------------------------------------------\n";

        }
        return saida;
    }
    
    /*public void remove(int codigo){
        int codigo=this.pesquisa(codigo);
        
        
    }
    
    public int pesquisa(int codigo){
        int i=0;
        for(Cliente resul:this.clientes){
            if(codigo==resul.getCodigo()){
                codigo=resul.getCodigo();
                i++;
            }
        }
       return codigo; 
    }*/

    
    
}
