
package com.sgec.converter;

import com.sgec.dao.CargoDAO;
import com.sgec.model.Cargo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author DHINNO
 */

@FacesConverter("cargoConverter")
public class CargoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        try{
            Long idCargo = Long.parseLong(valor);
            CargoDAO cargodao = new CargoDAO();
            Cargo cargo = cargodao.buscarPorCodigo(idCargo);
            return cargo;
        
        }catch(RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        try{
            Cargo cargo = (Cargo) valor;
            Long idCargo = cargo.getIdCargo();
            return idCargo.toString();
        
        }catch(RuntimeException ex){
            return null;
        } 
    }
}
