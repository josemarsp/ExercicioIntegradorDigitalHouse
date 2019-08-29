package br.digitalhouse.EntregavelJava;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DigitalHouseManager sistema = new DigitalHouseManager();

        //Regitrar Professores


        sistema.registrarProfessorTitular("Astolfo", "Barroso Pinto", 77, "AndroidMinds");
        sistema.registrarProfessorAdjunto("Orlando", "Drummond Cardoso", 33, 50);
        sistema.registrarProfessorTitular("Cerqueira", "Cesar", 88, "FullStackOverFlow");
        sistema.registrarProfessorAdjunto("Afonso", "Lopes", 55, 100);

        //Registro de Cursos

        sistema.registrarCurso("FullStack", 20001, 3);
        sistema.registrarCurso("Android", 20002, 2);
       //sistema.imprimeCursos();

        //Alocar um professor titular e um adjunto para cada curso.

        sistema.alocarProfessores(20001,88,55);
        sistema.alocarProfessores(20002, 77, 33);

        sistema.imprimeCursos();

        //Matricular dois alunos no curso de Full Stack

        sistema.registrarAluno("Ademir", "Mascarenhas", 171);
        sistema.registrarAluno("Urbano", "dos Santos", 717);

        sistema.matricularAluno(171, 20001);
        sistema.matricularAluno(717, 20001);
        sistema.imprimeAlunosMatriculados();

        //Matricular três alunos no curso de Android

        sistema.registrarAluno("Ricardo", "Jordão", 123);
        sistema.registrarAluno("Fernando", "Spadaro", 321);
        sistema.registrarAluno("Requião", "Atlantis", 333);

        sistema.matricularAluno(123, 20002);
        sistema.matricularAluno(321, 20002);
        sistema.matricularAluno(333, 20002);
        sistema.imprimeAlunosMatriculados();

        //Aluno consulta em qual curso ele está matriculado
        sistema.aondeVoceEstaCadastrado(333);
    }
}
