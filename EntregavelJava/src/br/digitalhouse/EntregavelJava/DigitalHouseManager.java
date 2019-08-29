package br.digitalhouse.EntregavelJava;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    //Parte G
    private List<Aluno> aluno = new ArrayList<>();
    private List<Professor> professor = new ArrayList<>();
    private List<Curso> curso = new ArrayList<>();
    private List<Matricula> matricula = new ArrayList<>();


//    public void cadastrarAluno(Aluno aluno) {
//        this.aluno.add(aluno);
//    }

    //Fim Parte G
    //Parte I - Registrar um curso


    public void registrarCurso(String nomeDoCurso, Integer codDoCurso, Integer quantMax) {
        Curso nC = new Curso(nomeDoCurso, codDoCurso, quantMax);
        curso.add(nC);
    }

    public void imprimeCursos() {
        System.out.println(curso.toString());
    }
    //Excluir um curso

    public void excluirCurso(Integer excluiCurso) {
        String msg = "Erro: código não existe - nenhum curso foi excluido.";
        for (int i = 0; i < curso.size(); i++) {
            if (curso.get(i).getCodCurso() == excluiCurso) {
                curso.remove(curso.get(i));
                msg = "Curso exclido com sucesso";
            }
        }
        System.out.println(msg);
    }
//    public void excluirCurso(Curso excliCurso) {
//        for (int i = 0; i < curso.size(); i++) {
//            if (curso.get(i).getCodCurso() == excliCurso.getCodCurso()) {
//                curso.remove(excliCurso);
//            }
//        }
//    }

    //Registrar um Professor adjunto
    public void registrarProfessorAdjunto(String nome, String sobrenome, Integer codProfessor, Integer quantHorasMonitoria) {
        ProfessorAdjunto profAdj = new ProfessorAdjunto(nome, sobrenome, codProfessor, 0, quantHorasMonitoria);
        professor.add(profAdj);
    }

    //Registrar Professor títular
    public void registrarProfessorTitular(String nome, String sobrenome, Integer codProfessor, String especialidade) {
        ProfessorTitular profTit = new ProfessorTitular(nome, sobrenome, 0, codProfessor, especialidade);
        professor.add(profTit);
    }

    //Excluir Professor
    public void excluirProfessor(Integer exclueProf) {
        String msg = "Excluir falhou: Professor não encontrado.";
        for (int i = 0; i < professor.size(); i++) {
            if (professor.get(i).getCodProfessor() == exclueProf) {
                professor.remove(professor.get(i));
                msg = "Professor excluido com sucesso";
            }
        }
        System.out.println(msg);
    }

    // Registrar Aluno

    public void registrarAluno(String nome, String sonbrenome, Integer codAluno) {
        Aluno novoAluno = new Aluno(nome, sonbrenome, codAluno);
        aluno.add(novoAluno);
    }

    // Matricular Aluno
    public void matricularAluno(Integer codAluno, Integer codCurso) {
        String msg = "Erro: matricula abortada.";
        Integer idA = null;
        Integer idC = null;

        for (int i = 0; i < aluno.size(); i++) {
            if (aluno.get(i).getCodAluno().equals(codAluno))
                idA = i;
        }
        for (int i = 0; i < curso.size(); i++) {
            if (curso.get(i).getCodCurso().equals(codCurso))
                idC = i;
        }

        if (idA != null && idC != null) {
            Matricula novaMatricula = new Matricula(aluno.get(idA), curso.get(idC));
            matricula.add(novaMatricula);
            msg = "Matricula realizada com sucesso!";
            System.out.println(msg);
        }

        if (idA == null || idC == null) {
            System.out.println(msg);
        }

    }

    public void imprimeAlunosMatriculados() {
        System.out.println("**************************************************************************");
        System.out.println(matricula.toString());
    }
//Alocar professores num curso

    public void alocarProfessores(Integer codDoCurso, Integer codProfTitular, Integer codProfAdjunto) {
        ProfessorAdjunto profA = null;
        ProfessorTitular profT = null;
        Integer idC = null;

        for (int i = 0; i < curso.size(); i++) {
            if (curso.get(i).getCodCurso().equals(codDoCurso)) {
                idC = i;
            }
        }
        for (int i = 0; i < professor.size(); i++) {
            if (professor.get(i).getCodProfessor() == codProfTitular) {
                profT = (ProfessorTitular) professor.get(i);
            }
            if (professor.get(i).getCodProfessor() == codProfAdjunto) {
                profA = (ProfessorAdjunto) professor.get(i);
            }

        }
        if (profA != null && idC != null && profT != null) {
            curso.get(idC).setProfessorAdjunto(profA);
            curso.get(idC).setProfessorTitular(profT);
        }

        //Consulta de aluno Matriculado
    }

    public void aondeVoceEstaCadastrado(Integer codDoAluno) {
        for (int i = 0; i < matricula.size(); i++) {
            if (matricula.get(i).getAluno().getCodAluno().equals(codDoAluno)) {
                System.out.println("******************************Consulta Cadastro***********************");
                System.out.println(matricula.get(i).getAluno().getNomeAluno() + " " +
                        matricula.get(i).getAluno().getSobrenomeAluno() + " - " +
                        matricula.get(i).getCurso().getNomeCurso());
            }
        }
    }
}
