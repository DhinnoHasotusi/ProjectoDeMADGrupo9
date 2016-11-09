
package com.sgec.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DHINNO
 */

@Entity
@Table(name = "Matricula")
@NamedQueries({@NamedQuery(name = "Matricula.listar", query = "SELECT matricula FROM Matricula matricula"),
@NamedQuery(name = "Matricula.buscarPorCodigo", query = "SELECT matricula FROM Matricula matricula WHERE matricula.idMatricula=:codigo")})
public class Matricula implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMatricula")
    private Long idMatricula;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataEscricao")
    private Date dataEscricao;
    
    @JoinColumn(name = "Aluno_idAluno", referencedColumnName = "idAluno")
    @ManyToOne(fetch = FetchType.EAGER)
    private Aluno aluno;
    
    @JoinColumn(name = "Periodo_idPeriodo", referencedColumnName = "idPeriodo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Periodo periodo;
    
    @JoinColumn(name = "CategoriaCarta_idCategoriaCarta", referencedColumnName = "idCategoriaCarta")
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoriaCarta categoriaCarta;
    
    @JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Matricula() {
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getDataEscricao() {
        return dataEscricao;
    }

    public void setDataEscricao(Date dataEscricao) {
        this.dataEscricao = dataEscricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public CategoriaCarta getCategoriaCarta() {
        return categoriaCarta;
    }

    public void setCategoriaCarta(CategoriaCarta categoriaCarta) {
        this.categoriaCarta = categoriaCarta;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Matricula{" + "idMatricula=" + idMatricula + ", dataEscricao=" + dataEscricao + ", aluno=" + aluno + ", periodo=" + periodo + ", categoriaCarta=" + categoriaCarta + ", funcionario=" + funcionario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idMatricula);
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.idMatricula, other.idMatricula)) {
            return false;
        }
        return true;
    }
    
    
}
