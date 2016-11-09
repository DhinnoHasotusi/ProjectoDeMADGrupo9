
package com.sgec.dao;

import com.sgec.model.Matricula;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class MatriculaDAO {
    public void salvar(Matricula matricula) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.save(matricula);
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
    
    public List<Matricula> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Matricula> matriculas = null;
        try{
            Query consulta = sessao.getNamedQuery("Matricula.listar");
            matriculas = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }
    
        return matriculas; 
    
    }
    
    public Matricula buscarPorCodigo(Long idMatricula){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Matricula matricula = null;
        try{
            Query consulta = sessao.getNamedQuery("Matricula.buscarPorCodigo");
            consulta.setLong("codigo", idMatricula);
            matricula = (Matricula) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return matricula;
    }
    
    public void excluir(Matricula matricula) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(matricula);
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
    
    public void editar(Matricula matricula) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
            sessao.update(matricula);
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
