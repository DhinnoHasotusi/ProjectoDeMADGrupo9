
package com.sgec.controller;

import com.sgec.dao.FuncionarioDAO;
import com.sgec.dao.UtilizadorDAO;
import com.sgec.model.Funcionario;
import com.sgec.model.Utilizador;
import com.sgec.util.Criptografia;
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
public class UtilizadorController {
    private Utilizador utilizador = new Utilizador();
    private List<Utilizador> listaUtilizador;
    private List<Funcionario> listaFuncionario;
    private Criptografia criptografia = new Criptografia();
    
    private String acao;
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public List<Utilizador> getListaUtilizador() {
        return listaUtilizador;
    }

    public void setListaUtilizador(List<Utilizador> listaUtilizador) {
        this.listaUtilizador = listaUtilizador;
    }

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public Criptografia getCriptografia() {
        return criptografia;
    }

    public void setCriptografia(Criptografia criptografia) {
        this.criptografia = criptografia;
    }
    

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    
    public void carregarDados(){
        try{
            UtilizadorDAO utilizadordao = new UtilizadorDAO();
            listaUtilizador=utilizadordao.listar();
            
            FuncionarioDAO funcionariodao = new FuncionarioDAO();
            listaFuncionario = funcionariodao.listar();
        
        
        }catch(RuntimeException ex){
        
        Mensagens.MsgErro("EERO AO TENTAR CARREGAR UTILIZADORES!");
        
        }
    
    }
    public void carregar(){
        try{
            acao = Mensagens.PegarParamet("acaoUtil");
            
            String valor = Mensagens.PegarParamet("codUtil");
            if(valor == null){
                utilizador = new Utilizador();
            } else {
                Long id_utilizador = Long.parseLong(valor);
                UtilizadorDAO utilizadorDao = new UtilizadorDAO();
                utilizador = utilizadorDao.buscarPorCodigo(id_utilizador);
            }
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR OBTER UTILIZADORES!");        
        } 
    }
    
    public void salvar(){
        try{ 
            UtilizadorDAO utilizadordao = new UtilizadorDAO();
            utilizadordao.salvar(utilizador);
            
            utilizador = new Utilizador();
            Mensagens.MsgSucesso("UTILIZADOR SALVO COM SUCESSO");
        
        }catch(RuntimeException ex){
        
        Mensagens.MsgErro("ERRO AO TENTAR SALVAR UTILIZADOR");
        
        }
    
    }
    
    public void excluir (){
    
        try{
            UtilizadorDAO utilizadorDao = new UtilizadorDAO();
            utilizadorDao.excluir(utilizador);
            
            utilizador = new Utilizador();
            Mensagens.MsgSucesso("UTILIZADOR EXCLUIDO COM SUCESSO!");
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR EXCLUIR UTILIZADOR!");
        }   
    }
    public void editar (){
    
        try{
            UtilizadorDAO utilizadorDao = new UtilizadorDAO();
            utilizadorDao.editar(utilizador);
            
            Mensagens.MsgSucesso("UTILIZADOR EDITADO COM SUCESSO!");
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR EDITAR UTILIZADOR!");
        }   
    }
}
