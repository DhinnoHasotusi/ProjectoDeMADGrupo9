
package com.sgec.dao;

import com.sgec.model.Aluno;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class AlunoDAO {
    public Long salvar(Aluno aluno){
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Transaction transacao = null;
        Long codigo = null;
        try{
            transacao = sessao.beginTransaction();
            codigo = (Long) sessao.save(aluno);
            transacao.commit();   
    
        }catch(RuntimeException ex){
            if(transacao!=null){
            transacao.rollback();            
            }
            throw ex;
        }finally{
        sessao.close();        
        }   
        return codigo;
    }
    
    public List<Aluno> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Aluno> alunos = null;
        try{
            Query consulta = sessao.getNamedQuery("Aluno.listar");
            alunos = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }
    
        return alunos; 
    
    }
    
    public Aluno buscarPorCodigo(Long idAluno){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Aluno aluno = null;
        try{
            Query consulta = sessao.getNamedQuery("Aluno.buscarPorCodigo");
            consulta.setLong("codigo", idAluno);
            aluno= (Aluno) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return aluno;
    }
    
    public void excluir(Aluno aluno) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(aluno);
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
    /*public void excluir(Long id_cliente) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
            Cliente cliente = buscarPorCodigo(id_cliente);
        sessao.delete(cliente);
        transacao.commit();
        
        }catch(RuntimeException ex){
            if(transacao!=null){
                transacao.rollback();
            }
            throw ex;
        }finally{
            sessao.close();
        }
    }*/
    public void editar(Aluno aluno) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
            sessao.update(aluno);
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
