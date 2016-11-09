
package com.sgec.controller;

import com.sgec.dao.CargoDAO;
import com.sgec.dao.FuncionarioDAO;
import com.sgec.model.Cargo;
import com.sgec.model.Funcionario;
import com.sgec.util.Mensagens;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DHINNO
 */

@ManagedBean
@SessionScoped
public class FuncionarioController {
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaFuncionario;
    private Cargo cargo = new Cargo();
    private List<Cargo> listaCargo;
    
    private String acao;
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public List<Cargo> getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(List<Cargo> listaCargo) {
        this.listaCargo = listaCargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    
    
    public void carregarDados(){
    
    try{
        
        FuncionarioDAO funcionariodao = new FuncionarioDAO();
        listaFuncionario= funcionariodao.listar();
        CargoDAO cargodao = new CargoDAO();
        listaCargo = cargodao.listar();
    
    
    }catch(RuntimeException ex){
    
        Mensagens.MsgErro("ERRO AO TENTAR LISTAR CARGO");
    
    }   
    
    }
    public void carregar(){
        try{
            acao = Mensagens.PegarParamet("acaoFunc");
            
            String valor = Mensagens.PegarParamet("codFunc");
            if(valor == null){
                funcionario = new Funcionario();
            } else {
                Long id_funcionario = Long.parseLong(valor);
                FuncionarioDAO funcionarioDao = new FuncionarioDAO();
                funcionario = funcionarioDao.buscarPorCodigo(id_funcionario);
            }
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR OBTER FUNCIONÁRIO!");        
        } 
    }
    
    public void salvar(){
        try{
        FuncionarioDAO funcionariodao = new FuncionarioDAO();
        funcionariodao.salvar(funcionario);
        funcionario=new Funcionario();
        Mensagens.MsgSucesso("salvo com sucesso");
        }catch(RuntimeException ex){
        
        Mensagens.MsgErro("ERRO AO TENTAR LISTAR CARGO");
        
        } 
    
    }
    
    public void excluir (){
    
        try{
            FuncionarioDAO funcionarioDao = new FuncionarioDAO();
            funcionarioDao.excluir(funcionario);
            
            funcionario = new Funcionario();
            Mensagens.MsgSucesso("FUNCIONÁRIO EXCLUIDO COM SUCESSO!");
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR EXCLUIR FUNCIONÁRIO!");
        }   
    }
    public void editar (){
    
        try{
            FuncionarioDAO funcionarioDao = new FuncionarioDAO();
            funcionarioDao.editar(funcionario);
            
            Mensagens.MsgSucesso("FUNCIONÁRIO EDITADO COM SUCESSO!");
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR EDITAR UM FUNCIONÁRIO!");
        }   
    }
}
