
package com.sgec.converter;

import com.sgec.dao.CategoriaCartaDAO;
import com.sgec.model.CategoriaCarta;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author DHINNO
 */
@FacesConverter("cartaConverter")
public class CategoriaCartaConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        try{
            Long idCategoriaCarta = Long.parseLong(valor);
            CategoriaCartaDAO categoriaCartadao = new CategoriaCartaDAO();
            CategoriaCarta categoriaCarta = categoriaCartadao.buscarPorCodigo(idCategoriaCarta);
            return categoriaCarta;
        
        }catch(RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        try{
            CategoriaCarta categoriaCarta = (CategoriaCarta) valor;
            Long idCategoriaCarta = categoriaCarta.getIdCategoriaCarta();
            return idCategoriaCarta.toString();
        
        }catch(RuntimeException ex){
            return null;
        } 
    }
}
