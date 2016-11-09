
package com.sgec.controller;

import com.sgec.dao.FuncionarioDAO;
import com.sgec.dao.MatriculaDAO;
import com.sgec.dao.PagamentoDAO;
import com.sgec.model.Funcionario;
import com.sgec.model.Matricula;
import com.sgec.model.Pagamento;
import com.sgec.util.Mensagens;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author DHINNO
 */
@ManagedBean
@SessionScoped
public class PagamentoController {
    private Pagamento pagamento = new Pagamento();
    private List<Pagamento> listaPagamento;
    private List<Matricula> listaMatricula;
    private Funcionario funcionario = new Funcionario();
    
    
    @ManagedProperty(value = "#{autenticarController}")
    private AutenticarController autenticarController;
    
    private String acao;

    public Pagamento getPagamento() {
        pagamento.setData(new Date());
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<Pagamento> getListaPagamento() {
        return listaPagamento;
    }

    public void setListaPagamento(List<Pagamento> listaPagamento) {
        this.listaPagamento = listaPagamento;
    }

    public List<Matricula> getListaMatricula() {
        return listaMatricula;
    }

    public void setListaMatricula(List<Matricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public AutenticarController getAutenticarController() {
        return autenticarController;
    }

    public void setAutenticarController(AutenticarController autenticarController) {
        this.autenticarController = autenticarController;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    
     public void carregarDados(){
    
        try{
            MatriculaDAO matriculadao = new MatriculaDAO();
            listaMatricula = matriculadao.listar();
                        
            FuncionarioDAO funcionariodao =new FuncionarioDAO();
            funcionario = funcionariodao.buscarPorCodigo(autenticarController.getUtilizadorAutenticar().getFuncionario().getIdFuncionario());
            pagamento.setFuncionario(funcionario);
            
            PagamentoDAO pagamentodao = new PagamentoDAO();
           listaPagamento = pagamentodao.listar();
           
        
        }catch(RuntimeException ex){
            Mensagens.MsgErro("EERO AO TENTAR LISTAR DADOS");
        
        }    
    }
     public void carregar(){
        try{
            acao = Mensagens.PegarParamet("acaoPag");
            
            String valor = Mensagens.PegarParamet("codPag");
            if(valor == null){
                
                pagamento = new Pagamento();
            } else {
                Long idPagamento = Long.parseLong(valor);
                PagamentoDAO pagamentoDao = new PagamentoDAO();
                pagamento = pagamentoDao.buscarPorCodigo(idPagamento);               
                
            }
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR OBTER PAGAMENTOS!");        
        } 
    }
    public void salvar(){
        try{
            PagamentoDAO pagamentodao = new PagamentoDAO();
            pagamentodao.salvar(pagamento);
            Mensagens.MsgSucesso("SALVO COM SUCESSO");
        }catch(RuntimeException ex){
        
        Mensagens.MsgErro("ERRO AO TENTAR SALVAR");
        
        }
    }
    
    public void editar(){
        try{
            PagamentoDAO pagamentodao = new PagamentoDAO();
            pagamentodao.editar(pagamento);
            Mensagens.MsgSucesso("EDITADO COM SUCESSO");
        
        }catch(RuntimeException ex){
        Mensagens.MsgErro("ERRO AO TENTAR SALVO");
        
        }    
    }
    
    public void excluir(){
        try{
            PagamentoDAO pagamentodao = new PagamentoDAO();
            pagamentodao.excluir(pagamento);
            Mensagens.MsgSucesso("Excluido COM SUCESSO");
        }catch(RuntimeException ex){
        Mensagens.MsgSucesso("ERRO AO TENTAR EXCLUIR");
        
        }
    
    }
}
