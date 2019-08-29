package br.digitalhouse.EntregavelJava;

public abstract class Professor {

    private String nomeProfessor;
    private String sobrenomeProfessor;
    private Integer tempoProfessor;
    private Integer codProfessor;

    public Professor(String nomeProfessor, String sobrenomeProfessor, Integer codProfessor, Integer tempoProfessor) {
        this.nomeProfessor = nomeProfessor;
        this.sobrenomeProfessor = sobrenomeProfessor;
        this.codProfessor = codProfessor;
        this.tempoProfessor = tempoProfessor;

    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getSobrenomeProfessor() {
        return sobrenomeProfessor;
    }

    public void setSobrenomeProfessor(String sobrenomeProfessor) {
        this.sobrenomeProfessor = sobrenomeProfessor;
    }

    public Integer getTempoProfessor() {
        return tempoProfessor;
    }

    public void setTempoProfessor(Integer tempoProfessor) {
        this.tempoProfessor = tempoProfessor;
    }

    public Integer getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(Integer codProfessor) {
        this.codProfessor = codProfessor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nomeProfessor='" + nomeProfessor + '\'' +
                ", sobrenomeProfessor='" + sobrenomeProfessor + '\'' +
                ", tempoProfessor=" + tempoProfessor +
                ", codProfessor=" + codProfessor +
                '}';
    }
}
