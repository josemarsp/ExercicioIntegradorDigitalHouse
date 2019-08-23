package br.digitalhouse.EntregavelJava;

public class Aluno {

    private String nomeAluno;
    private String sobrenomeAluno;
    private Integer codAluno;

    public Aluno(String nomeAluno, String sobrenomeAluno, Integer codAluno) {
        this.nomeAluno = nomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.codAluno = codAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getSobrenomeAluno() {
        return sobrenomeAluno;
    }

    public void setSobrenomeAluno(String sobrenomeAluno) {
        this.sobrenomeAluno = sobrenomeAluno;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }
}

