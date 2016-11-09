
package com.sgec.converter;


import com.sgec.dao.FuncionarioDAO;
import com.sgec.model.Funcionario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author DHINNO
 */
@FacesConverter("utilizadorConverter")
public class UtilizadorConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        try{
            Long idFuncionario = Long.parseLong(valor);
            FuncionarioDAO funcionariodao = new FuncionarioDAO();
            Funcionario funcionario = funcionariodao.buscarPorCodigo(idFuncionario);
            return funcionario;
        
        }catch(RuntimeException ex){
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object valor) {
        try{
            Funcionario funcionario = (Funcionario) valor;
            Long idFuncionario = funcionario.getIdFuncionario();
            return idFuncionario.toString();
        
        }catch(RuntimeException ex){
            return null;
        } 
    }
}
