
package com.sgec.controller;

import com.sgec.dao.ViaturaDAO;
import com.sgec.model.Viatura;
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
public class ViaturaController {
    private Viatura viatura = new Viatura();
    private List<Viatura> listaviatura;
    
    private String acao;

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public List<Viatura> getListaviatura() {
        return listaviatura;
    }

    public void setListaviatura(List<Viatura> listaviatura) {
        this.listaviatura = listaviatura;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    public void carregarDados(){
    
    try{
        
        ViaturaDAO viaturadao = new ViaturaDAO();
        listaviatura= viaturadao.listar();
       
    
    
    }catch(RuntimeException ex){
    
        Mensagens.MsgErro("ERRO AO TENTAR LISTAR VIATURA");
    
    }   
    
    }
    public void carregar(){
        try{
            acao = Mensagens.PegarParamet("acaoViat");
            
            String valor = Mensagens.PegarParamet("codViat");
            if(valor == null){
                viatura = new Viatura();
            } else {
                Long idViatura = Long.parseLong(valor);
                ViaturaDAO viaturaDao = new ViaturaDAO();
                viatura = viaturaDao.buscarPorCodigo(idViatura);
            }
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR OBTER VIATURA!");        
        } 
    }
    
    public void salvar(){
        try{
        ViaturaDAO viaturadao = new ViaturaDAO();
        viaturadao.salvar(viatura);
        viatura=new Viatura();
        Mensagens.MsgSucesso("salvo com sucesso");
        }catch(RuntimeException ex){
        
        Mensagens.MsgErro("ERRO AO TENTAR LISTAR VIATURA");
        
        } 
    
    }
    
    public void excluir (){
    
        try{
            ViaturaDAO viaturaDao = new ViaturaDAO();
            viaturaDao.excluir(viatura);
            
            viatura = new Viatura();
            Mensagens.MsgSucesso(" EXCLUIDO COM SUCESSO!");
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR EXCLUIR VIATURA!");
        }   
    }
    public void editar (){
    
        try{
            ViaturaDAO viaturaDao = new ViaturaDAO();
            viaturaDao.editar(viatura);
            
            Mensagens.MsgSucesso("EDITADO COM SUCESSO!");
        }catch(RuntimeException ex){
            Mensagens.MsgErro("ERRO AO TENTAR EDITAR VIATURA!");
        }   
    }
    
}
