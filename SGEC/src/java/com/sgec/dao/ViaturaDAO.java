
package com.sgec.dao;

import com.sgec.model.Viatura;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class ViaturaDAO {
    public void salvar(Viatura viatura){
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Transaction transacao =null;
    
    try{
        transacao = sessao.beginTransaction();
        sessao.save(viatura);
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
    
    public List<Viatura> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Viatura> viaturas = null;
        
        try{
            Query consulta = sessao.getNamedQuery("Viatura.listar");
            viaturas = consulta.list();    
        
        }catch(RuntimeException ex){
            throw ex;
        
        }finally{
            sessao.close();
        }
            return viaturas;    
    }
    
    public Viatura buscarPorCodigo(Long idViatura){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Viatura viatura = null;
        try{
            Query consulta = sessao.getNamedQuery("Viatura.buscarPorCodigo");
            consulta.setLong("codigo", idViatura);
            viatura = (Viatura) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return viatura;
    }
    
    public void excluir(Viatura viatura) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(viatura);
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
    
    public void editar(Viatura viatura) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
        sessao.update(viatura);
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
