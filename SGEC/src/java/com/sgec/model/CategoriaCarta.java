
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
@Table(name = "CategoriaCarta")
@NamedQueries({@NamedQuery(name = "Carta.listar", query = "SELECT categoriacarta FROM CategoriaCarta categoriacarta"),
@NamedQuery(name = "Carta.buscarPorCodigo", query = "SELECT categoriacarta FROM CategoriaCarta categoriacarta WHERE categoriacarta.idCategoriaCarta=:codigo")})
public class CategoriaCarta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategoriaCarta")
    private Long idCategoriaCarta;
    
    @Column(name = "descricao")
    private String descricao;

    public CategoriaCarta() {
    }

    public Long getIdCategoriaCarta() {
        return idCategoriaCarta;
    }

    public void setIdCategoriaCarta(Long idCategoriaCarta) {
        this.idCategoriaCarta = idCategoriaCarta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CategoriaCarta{" + "idCategoriaCarta=" + idCategoriaCarta + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.idCategoriaCarta);
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
        final CategoriaCarta other = (CategoriaCarta) obj;
        if (!Objects.equals(this.idCategoriaCarta, other.idCategoriaCarta)) {
            return false;
        }
        return true;
    }
    
    
}
