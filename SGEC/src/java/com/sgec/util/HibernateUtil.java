
package com.sgec.util;

import com.sgec.model.Aluno;
import com.sgec.model.Cargo;
import com.sgec.model.CategoriaCarta;
import com.sgec.model.Funcionario;
import com.sgec.model.Matricula;
import com.sgec.model.Pagamento;
import com.sgec.model.Periodo;
import com.sgec.model.Utilizador;
import com.sgec.model.Viatura;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author DHINNO
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;

    public HibernateUtil(){
    }
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{
                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Aluno.class);  
                ac.addAnnotatedClass(Cargo.class);       
               
                ac.addAnnotatedClass(CategoriaCarta.class);
                ac.addAnnotatedClass(Funcionario.class);
                ac.addAnnotatedClass(Matricula.class);
                ac.addAnnotatedClass(Pagamento.class);
                ac.addAnnotatedClass(Periodo.class);
                ac.addAnnotatedClass(Utilizador.class);
                 ac.addAnnotatedClass(Viatura.class);
                
                
                sessionFactory = ac.configure().buildSessionFactory();            
            }catch(Throwable ex){
                System.err.println("ERRO AO CRIAR O SESSION FACTORY. "+ex);
                throw new ExceptionInInitializerError();            
            }
            return sessionFactory;
        
        }else{
        
         return sessionFactory;
        }
    
    }
}
