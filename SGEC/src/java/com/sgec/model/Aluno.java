
package com.sgec.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author DHINNO
 */

@Entity
@Table(name = "Aluno")
@NamedQueries({@NamedQuery(name = "Aluno.listar", query = "SELECT aluno FROM Aluno aluno"),
@NamedQuery(name = "Aluno.buscarPorCodigo", query = "SELECT aluno FROM Aluno aluno WHERE aluno.idAluno=:codigo")})
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAluno")
    private Long idAluno;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "dataNascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "sexo")
    private String sexo;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "bairro")
    private String bairro;

    public Aluno() {
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", telefone=" + telefone + ", cidade=" + cidade + ", bairro=" + bairro + '}';
    }
     
    
    
}
