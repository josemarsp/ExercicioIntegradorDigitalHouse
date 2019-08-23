package br.digitalhouse.EntregavelJava;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nomeCurso;
    private Integer codCurso;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private Integer quantMax = 35;
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    public void matricularAlunos(Aluno novoAluno){
        alunosMatriculados.add(novoAluno);
    }
    //Processar as novos atributos

    public Curso(String nomeCurso, Integer codCurso) {
        this.nomeCurso = nomeCurso;
        this.codCurso = codCurso;
    }

    //Adicionando aluno
    public Boolean adicionarUmAluno(Aluno umAluno) {
        if (alunosMatriculados.size() == quantMax) {
            return false;
        } else {
            alunosMatriculados.add(umAluno);
            return true;
        }
    }
    //Excluindo um aluno
    public void excluirAluno (Aluno umAluno){
        alunosMatriculados.remove(umAluno);
    }



    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }
}
