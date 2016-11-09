
package com.sgec.dao;

import com.sgec.model.Pagamento;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class PagamentoDAO {
    public void salvar(Pagamento pagamento) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.save(pagamento);
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
    
    public List<Pagamento> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Pagamento> pagamentos = null;
        try{
            Query consulta = sessao.getNamedQuery("Pagamento.listar");
            pagamentos = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }
    
        return pagamentos; 
    
    }
    
    public Pagamento buscarPorCodigo(Long idPagamento){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Pagamento pagamento = null;
        try{
            Query consulta = sessao.getNamedQuery("Pagamento.buscarPorCodigo");
            consulta.setLong("codigo", idPagamento);
            pagamento = (Pagamento) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return pagamento;
    }
    
    public void excluir(Pagamento pagamento) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(pagamento);
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
    
    public void editar(Pagamento pagamento) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
            sessao.update(pagamento);
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
