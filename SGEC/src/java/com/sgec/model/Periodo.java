
package com.sgec.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DHINNO
 */
@Entity
@Table(name = "Periodo")
@NamedQueries({@NamedQuery(name = "Periodo.listar", query = "SELECT periodo FROM Periodo periodo"),
@NamedQuery(name = "Periodo.buscarPorCodigo", query = "SELECT periodo FROM Periodo periodo WHERE periodo.idPeriodo=:codigo")})
public class Periodo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPeriodo")
    private Long idPeriodo;
    
    @Column(name = "descricao")
    private String descricao;

    public Periodo() {
    }

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Periodo{" + "idPeriodo=" + idPeriodo + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idPeriodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.idPeriodo, other.idPeriodo)) {
            return false;
        }
        return true;
    }
    
    
}
