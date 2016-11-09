
package com.sgec.dao;

import com.sgec.model.Funcionario;
import com.sgec.model.Utilizador;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class UtilizadorDAO {
    public void salvar(Utilizador utilizador){
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Transaction transacao =null;
    
    try{
        transacao = sessao.beginTransaction();
        sessao.save(utilizador);
        transacao.commit();
    
    }catch(RuntimeException ex){
        if(transacao!=null){
                transacao.rollback();
            }
            throw ex;
        
    }finally{
            sessao.close();
        }    
    }
    
    public List<Utilizador> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Utilizador> utilizadores = null;
        
        try{
            Query consulta = sessao.getNamedQuery("Utilizador.listar");
            utilizadores = consulta.list();    
        
        }catch(RuntimeException ex){
            throw ex;
        
        }finally{
            sessao.close();
        }
            return utilizadores;    
    }
    
    public Utilizador buscarPorCodigo(Long idUtilizador){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Utilizador utilizador = null;
        try{
            Query consulta = sessao.getNamedQuery("Utilizador.buscarPorCodigo");
            consulta.setLong("codigo", idUtilizador);
            utilizador = (Utilizador) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return utilizador;
    }
    
    public void excluir(Utilizador utilizador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(utilizador);
        transacao.commit();
        
        }catch(RuntimeException ex){
            if(transacao!=null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    }
    
    public void editar(Utilizador utilizador) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
        sessao.update(utilizador);
        transacao.commit();
        
        }catch(RuntimeException ex){
            if(transacao!=null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    }
    public Utilizador autenticar(String username, String senha){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Utilizador utilizador = null;
        try{
            Query consulta = sessao.getNamedQuery("Utilizador.autenticar");
            consulta.setString("usuario", username);
            consulta.setString("senha", senha);
            utilizador = (Utilizador) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return utilizador;
    }
}
