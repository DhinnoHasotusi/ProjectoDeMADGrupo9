
package com.sgec.dao;

import com.sgec.model.Cargo;
import com.sgec.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DHINNO
 */


public class CargoDAO {
     public void salvar(Cargo cargo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.save(cargo);
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
    
    public List<Cargo> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cargo> cargos = null;
        try{
            Query consulta = sessao.getNamedQuery("Cargo.listar");
            cargos = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }
    
        return cargos;
    }
    public Cargo buscarPorCodigo(Long idCargo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cargo cargo = null;
        try{
            Query consulta = sessao.getNamedQuery("Cargo.buscarPorCodigo");
            consulta.setLong("codigo", idCargo);
            cargo = (Cargo) consulta.uniqueResult();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            sessao.close();
        }    
        return cargo;
    }
    
    public void excluir(Cargo cargo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();            
        sessao.delete(cargo);
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
    
    public void editar(Cargo cargo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao=null;
        
        try{
            transacao= sessao.beginTransaction();
                       
        sessao.update(cargo);
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
