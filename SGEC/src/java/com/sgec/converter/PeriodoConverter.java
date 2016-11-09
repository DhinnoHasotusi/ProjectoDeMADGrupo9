
package com.sgec.converter;

import com.sgec.dao.PeriodoDAO;
import com.sgec.model.Periodo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author DHINNO
 */
@FacesConverter("periodoConverter")
public class PeriodoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        try{
            Long idPeriodo = Long.parseLong(valor);
            PeriodoDAO periododao = new PeriodoDAO();
            Periodo periodo = periododao.buscarPorCodigo(idPeriodo);
            return periodo;
        
        }catch(RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        try{
            Periodo periodo = (Periodo) valor;
            Long idPeriodo = periodo.getIdPeriodo();
            return idPeriodo.toString();
        
        }catch(RuntimeException ex){
            return null;
        } 
    }
}
