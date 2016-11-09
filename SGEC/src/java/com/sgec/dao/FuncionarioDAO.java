
package com.sgec.dao;

import com.sgec.model.Funcionario;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class FuncionarioDAO {
    
    public void salvar(Funcionario funcionario){
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Transaction transacao =null;
    
    try{
        transacao = sessao.beginTransaction();
        sessao.save(funcionario);
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
    
    public List<Funcionario> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Funcionario> funcionarios = null;
        
        try{
            Query consulta = sessao.getNamedQuery("Funcionario.listar");
            funcionarios = consulta.list();    
        
        }catch(RuntimeException ex){
            throw ex;
        
        }finally{
            sessao.close();
        }
            return funcionarios;    
    }
    
    public Funcionario buscarPorCodigo(Long idFuncionario){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Funcionario funcionario = null;
        try{
            Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
            consulta.setLong("codigo", idFuncionario);
            funcionario = (Funcionario) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return funcionario;
    }
    
    public void excluir(Funcionario funcionario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(funcionario);
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
    
    public void editar(Funcionario funcionario) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
        sessao.update(funcionario);
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
    
}
