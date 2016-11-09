
package com.sgec.converter;

import com.sgec.dao.MatriculaDAO;
import com.sgec.model.Matricula;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author DHINNO
 */
@FacesConverter("matriculaConverter")
public class MatriculaConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        try{
            Long idMatricula = Long.parseLong(valor);
            MatriculaDAO matriculadao = new MatriculaDAO();
            Matricula matricula = matriculadao.buscarPorCodigo(idMatricula);
            return matricula;
        
        }catch(RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        try{
            Matricula matricula = (Matricula) valor;
            Long idMatricula = matricula.getIdMatricula();
            return idMatricula.toString();
        
        }catch(RuntimeException ex){
            return null;
        } 
    }
}
