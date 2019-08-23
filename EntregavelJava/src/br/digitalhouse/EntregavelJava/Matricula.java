package br.digitalhouse.EntregavelJava;

import java.util.Date;

public class Matricula {

    private Aluno aluno;
    private Curso curso;
    private Date dataMatricula = new Date();

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataMatricula = dataMatricula;
    }




}
