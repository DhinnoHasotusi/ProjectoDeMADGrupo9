
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
@Table(name = "Cargo")
@NamedQueries({@NamedQuery(name = "Cargo.listar", query = "SELECT cargo FROM Cargo cargo"),
@NamedQuery(name = "Cargo.buscarPorCodigo", query = "SELECT cargo FROM Cargo cargo WHERE cargo.idCargo=:codigo")})
public class Cargo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCargo")
    private Long idCargo;
    
    @Column(name = "descricao")
    private String descricao;

    public Cargo() {
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idCargo);
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
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.idCargo, other.idCargo)) {
            return false;
        }
        return true;
    }
    
    
}
