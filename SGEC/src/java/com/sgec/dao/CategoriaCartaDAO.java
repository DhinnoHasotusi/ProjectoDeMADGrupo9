
package com.sgec.dao;

import com.sgec.model.CategoriaCarta;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */
public class CategoriaCartaDAO {
    public void salvar(CategoriaCarta categoriaCarta){
    Session sessao = HibernateUtil.getSessionFactory().openSession();
    Transaction transacao =null;
    
    try{
        transacao = sessao.beginTransaction();
        sessao.save(categoriaCarta);
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
    
    public List<CategoriaCarta> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<CategoriaCarta> categoriaCartas = null;
        
        try{
            Query consulta = sessao.getNamedQuery("Carta.listar");
            categoriaCartas = consulta.list();    
        
        }catch(RuntimeException ex){
            throw ex;
        
        }finally{
            sessao.close();
        }
            return categoriaCartas;    
    }
    
    public CategoriaCarta buscarPorCodigo(Long idCategoriaCarta){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        CategoriaCarta categoriaCarta = null;
        try{
            Query consulta = sessao.getNamedQuery("Carta.buscarPorCodigo");
            consulta.setLong("codigo", idCategoriaCarta);
            categoriaCarta = (CategoriaCarta) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return categoriaCarta;
    }
    
    public void excluir(CategoriaCarta categoriaCarta) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(categoriaCarta);
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
    
    public void editar(CategoriaCarta categoriaCarta) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
        sessao.update(categoriaCarta);
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
