package br.digitalhouse.EntregavelJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {

    private String nomeCurso;
    private Integer codCurso;
    private ProfessorTitular professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private Integer quantMax;
    private List<Aluno> alunosMatriculados = new ArrayList<>();


    public Curso(String nomeCurso, Integer codCurso, Integer quantMax) {
        this.nomeCurso = nomeCurso;
        this.codCurso = codCurso;
        this.quantMax = quantMax;
    }

//    public Curso(ProfessorTitular professorTitular, ProfessorAdjunto professorAdjunto){
//        this.professorTitular = professorTitular;
//        this.professorAdjunto = professorAdjunto;
//    }



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

    public ProfessorTitular getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public Integer getQuantMax() {
        return quantMax;
    }

    public void setQuantMax(Integer quantMax) {
        this.quantMax = quantMax;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codCurso.equals(curso.codCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCurso);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nomeCurso='" + nomeCurso + '\'' +
                ", codCurso=" + codCurso +
                ", professorTitular=" + professorTitular +
                ", professorAdjunto=" + professorAdjunto +
                ", quantMax=" + quantMax +
                ", alunosMatriculados=" + alunosMatriculados +
                '}';
    }
}
