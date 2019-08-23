package br.digitalhouse.EntregavelJava;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Aluno> aluno = new ArrayList<>();
    private List<Professor> professor = new ArrayList<>();
    private List<Curso> curso = new ArrayList<>();
    private List<Matricula> matricula = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        this.aluno.add(aluno);
    }

    public void cadastrarProfessor(Professor professor) {
        this.professor.add(professor);
    }

}
