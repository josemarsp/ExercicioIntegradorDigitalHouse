package br.digitalhouse.EntregavelJava;

public class ProfessorTitular extends Professor {

    private String especialidade;

    public ProfessorTitular(String nomeProfessor, String sobrenomeProfessor, Integer tempoProfessor, Integer codProfessor, String novaEspecialidade) {
        super(nomeProfessor, sobrenomeProfessor, codProfessor, tempoProfessor);
        this.especialidade = novaEspecialidade;

    }

    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade (String novaEspecialidade){
        this.especialidade = novaEspecialidade;
    }
}
