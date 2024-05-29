package com.example.dto;

public class AlunoTreinoExercicioDto {
    Integer id_treino;
    Integer id_exercicio;
    Integer series;
    Integer min_rep;
    Integer max_rep;
    Integer carga;
    Integer tempo_descanso;

    public Integer getId_treino() {
        return id_treino;
    }

    public void setId_treino(Integer id_treino) {
        this.id_treino = id_treino;
    }

    public Integer getId_exercicio() {
        return id_exercicio;
    }

    public void setId_exercicio(Integer id_exercicio) {
        this.id_exercicio = id_exercicio;
    }
    
    public Integer getCarga() {
        return carga;
    }
    
    public void setCarga(Integer carga) {
        this.carga = carga;
    }
    
    public Integer getMax_rep() {
        return max_rep;
    }

    public void setMax_rep(Integer max_rep) {
        this.max_rep = max_rep;
    }
    
    public Integer getMin_rep() {
        return min_rep;
    }
    
    public void setMin_rep(Integer min_rep) {
        this.min_rep = min_rep;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getTempo_descanso() {
        return tempo_descanso;
    }

    public void setTempo_descanso(Integer tempo_descanso) {
        this.tempo_descanso = tempo_descanso;
    }
    
}