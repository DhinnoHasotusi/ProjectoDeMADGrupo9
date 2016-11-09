
package com.sgec.dao;


import com.sgec.model.Periodo;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class PeriodoDAO {
    public void salvar(Periodo periodo){
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Transaction transacao =null;
    
    try{
        transacao = sessao.beginTransaction();
        sessao.save(periodo);
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
    
    public List<Periodo> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Periodo> periodos = null;
        
        try{
            Query consulta = sessao.getNamedQuery("Periodo.listar");
            periodos = consulta.list();    
        
        }catch(RuntimeException ex){
            throw ex;
        
        }finally{
            sessao.close();
        }
            return periodos;    
    }
    
    public Periodo buscarPorCodigo(Long idPeriodo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Periodo periodo = null;
        try{
            Query consulta = sessao.getNamedQuery("Periodo.buscarPorCodigo");
            consulta.setLong("codigo", idPeriodo);
            periodo = (Periodo) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return periodo;
    }
    
    public void excluir(Periodo periodo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(periodo);
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
    
    public void editar(Periodo periodo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
        sessao.update(periodo);
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
