
package com.sgec.controller;

import com.sgec.dao.UtilizadorDAO;
import com.sgec.model.Utilizador;
import com.sgec.util.Mensagens;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DHINNO
 */

@ManagedBean
@SessionScoped
public class AutenticarController {
    private Utilizador utilizadorAutenticar;

    public Utilizador getUtilizadorAutenticar() {
        if(utilizadorAutenticar==null){
        
        utilizadorAutenticar=new Utilizador();
        }
        return utilizadorAutenticar;
    }

    public void setUtilizadorAutenticar(Utilizador utilizadorAutenticar) {
        this.utilizadorAutenticar = utilizadorAutenticar;
    }
    
    public String entrar(){
        try{
            UtilizadorDAO utilizadordao = new UtilizadorDAO();
            utilizadorAutenticar = utilizadordao.autenticar(utilizadorAutenticar.getUsername(), utilizadorAutenticar.getSenha());
            if(utilizadorAutenticar==null){
                Mensagens.MsgErro("UTILIZADOR E/OU SENHA ERRADA!");
                return null;
            }else{
            
                Mensagens.MsgSucesso("SEJA BEM-VINDO "+utilizadorAutenticar.getFuncionario().getNome());
                
                return "principal.xhtml?faces-redirect=true";
            }
        
        
        
        }catch(RuntimeException ex){
        
            Mensagens.MsgErro("ERRO AO TENTAR ACEDER AO SISTEMA!");
            return null;
        
        }
    
    }
    
    public String sair(){
    utilizadorAutenticar = null;
    return "autenticar.xhtml?faces-redirect=true";
    }
    
}
