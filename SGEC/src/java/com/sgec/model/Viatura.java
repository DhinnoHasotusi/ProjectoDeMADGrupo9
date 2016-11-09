
package com.sgec.model;

import java.io.Serializable;
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
@Table(name = "Viatura")
@NamedQueries({@NamedQuery(name = "Viatura.listar", query = "SELECT viatura FROM Viatura viatura"),
@NamedQuery(name = "Viatura.buscarPorCodigo", query = "SELECT viatura FROM Viatura viatura WHERE viatura.idViatura=:codigo")})
public class Viatura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idViatura")
    private Long idViatura;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "cor")
    private String cor;
    
    @Column(name = "matricula")
    private String matricula;

    public Viatura() {
    }

    public Long getIdViatura() {
        return idViatura;
    }

    public void setIdViatura(Long idViatura) {
        this.idViatura = idViatura;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Viatura{" + "idViatura=" + idViatura + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", matricula=" + matricula + '}';
    }
    
    
}
