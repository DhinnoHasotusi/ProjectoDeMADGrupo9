
package com.sgec.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DHINNO
 */
@Entity
@Table(name = "Utilizador")
@NamedQueries({@NamedQuery(name = "Utilizador.listar", query = "SELECT utilizador FROM Utilizador utilizador"),
@NamedQuery(name = "Utilizador.buscarPorCodigo", query = "SELECT utilizador FROM Utilizador utilizador WHERE utilizador.idUtilizador=:codigo"),
@NamedQuery(name = "Utilizador.autenticar", query ="SELECT utilizador FROM Utilizador utilizador WHERE utilizador.username=:usuario AND utilizador.senha=:senha")})
public class Utilizador implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUtilizador")
    private Long idUtilizador;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "senha")
    private String senha;
    
    @JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Utilizador() {
    }

    public Long getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Long idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "idUtilizador=" + idUtilizador + ", username=" + username + ", senha=" + senha + ", funcionario=" + funcionario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idUtilizador);
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
        final Utilizador other = (Utilizador) obj;
        if (!Objects.equals(this.idUtilizador, other.idUtilizador)) {
            return false;
        }
        return true;
    }
    
    
}
