
package com.sgec.controller;

import com.sgec.dao.AlunoDAO;
import com.sgec.dao.CategoriaCartaDAO;
import com.sgec.dao.FuncionarioDAO;
import com.sgec.dao.MatriculaDAO;
import com.sgec.dao.PeriodoDAO;
import com.sgec.model.Aluno;
import com.sgec.model.CategoriaCarta;
import com.sgec.model.Funcionario;
import com.sgec.model.Matricula;
import com.sgec.model.Periodo;
import com.sgec.util.Mensagens;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author DHINNO
 */

@ManagedBean
@ViewScoped
public class MatriculaController {
    private Matricula matricula = new Matricula();
    private Aluno aluno = new Aluno();
    private List<Aluno> listaAlunos;
    private List<Matricula> matriculas;
    
    private List<Periodo> listaPeriodo;
    private List<CategoriaCarta> listaCategoriaCarta;
    
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listafuncionarios;
    
    @ManagedProperty(value = "#{autenticarController}")
    private AutenticarController autenticarController;

    public Matricula getMatricula() {
        matricula.setDataEscricao(new Date());
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Periodo> getListaPeriodo() {
        return listaPeriodo;
    }

    public void setListaPeriodo(List<Periodo> listaPeriodo) {
        this.listaPeriodo = listaPeriodo;
    }

    public List<CategoriaCarta> getListaCategoriaCarta() {
        return listaCategoriaCarta;
    }

    public void setListaCategoriaCarta(List<CategoriaCarta> listaCategoriaCarta) {
        this.listaCategoriaCarta = listaCategoriaCarta;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Funcionario> getListafuncionarios() {
        return listafuncionarios;
    }

    public void setListafuncionarios(List<Funcionario> listafuncionarios) {
        this.listafuncionarios = listafuncionarios;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public AutenticarController getAutenticarController() {
        return autenticarController;
    }

    public void setAutenticarController(AutenticarController autenticarController) {
        this.autenticarController = autenticarController;
    }
    
    
    
    public void carregarDados(){
    
        try{
            PeriodoDAO periododao = new PeriodoDAO();
            listaPeriodo = periododao.listar();
            
            CategoriaCartaDAO categoriadao = new CategoriaCartaDAO();
            listaCategoriaCarta=categoriadao.listar();
            
            FuncionarioDAO funcionariodao =new FuncionarioDAO();
            funcionario = funcionariodao.buscarPorCodigo(autenticarController.getUtilizadorAutenticar().getFuncionario().getIdFuncionario());
            matricula.setFuncionario(funcionario);
            
            MatriculaDAO matriculadao = new MatriculaDAO();
           matriculas = matriculadao.listar();
           
           AlunoDAO alunodao = new AlunoDAO();
           listaAlunos = alunodao.listar();
        
        }catch(RuntimeException ex){
            Mensagens.MsgErro("EERO AO TENTAR LISTAR DADOS");
        
        }
    
    }
    
    public String salvar(){
    
        try{
            AlunoDAO alunodao = new AlunoDAO();
            Long alunoCod = alunodao.salvar(aluno);
            
            Aluno alunoCE = alunodao.buscarPorCodigo(alunoCod);
            
            
                matricula.setAluno(alunoCE);
                
                MatriculaDAO matriculadao = new MatriculaDAO();
                matriculadao.salvar(matricula); 
            aluno = new Aluno();
        Mensagens.MsgSucesso("MATRICULA SALVA COM SUCESSO");
        return "matriculaLista.xhtml?faces-redirect=true";
        }catch(RuntimeException ex){
        
        Mensagens.MsgErro("ERRO AO TENTAR SALVAR MATRICULA!");
        
        return null;
        }
       
    }
}
