package br.digitalhouse.EntregavelJava;

public class ProfessorAdjunto extends Professor {

    private Integer horasMonitoria;

    public ProfessorAdjunto(String nomeProfessor, String sobrenomeProfessor, Integer codProfessor, Integer tempoProfessor, Integer novaHorasMonitoria) {
        super(nomeProfessor, sobrenomeProfessor, codProfessor, tempoProfessor );
        this.horasMonitoria = novaHorasMonitoria;
    }

    public Integer getHorasMonitoria(){
        return horasMonitoria;
    }

    public void setHorasMonitoria (Integer novaHorasMonitoria){
        this.horasMonitoria = novaHorasMonitoria;
    }


}
