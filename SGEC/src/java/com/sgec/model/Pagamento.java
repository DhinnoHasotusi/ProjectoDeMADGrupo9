
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

/**
 *
 * @author DHINNO
 */
@Entity
@Table(name = "Pagamento")
@NamedQueries({@NamedQuery(name = "Pagamento.listar", query = "SELECT pagamento FROM Pagamento pagamento"),
@NamedQuery(name = "Pagamento.buscarPorCodigo", query = "SELECT pagamento FROM Pagamento pagamento WHERE pagamento.idPagamento=:codigo")})
public class Pagamento implements Serializable {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "idPagamento")
   private Long idPagamento;
   
   @Column(name = "valor")
   private Double valor;
   
   @Column(name = "descricao")
   private String descricao;
   
   @Column(name = "data")
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date data;
   
   @JoinColumn(name = "Matricula_idMatricula", referencedColumnName = "idMatricula")
    @ManyToOne(fetch = FetchType.EAGER)
   private Matricula matricula;
   
   @JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Pagamento() {
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "idPagamento=" + idPagamento + ", valor=" + valor + ", descricao=" + descricao + ", data=" + data + ", matricula=" + matricula + ", funcionario=" + funcionario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idPagamento);
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
        final Pagamento other = (Pagamento) obj;
        if (!Objects.equals(this.idPagamento, other.idPagamento)) {
            return false;
        }
        return true;
    }
    
       
   
   
}
