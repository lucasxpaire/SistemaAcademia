package com.example.dto;

public class AlunoPlanoDto {
    private Integer id_cartao;
    private String data_inicio;
    private Integer id_plano;
    private String aluno_cpf;

    public void setAluno_cpf(String aluno_cpf) {
        this.aluno_cpf = aluno_cpf;
    }

    public String getAluno_cpf() {
        return aluno_cpf;
    }
    
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setId_cartao(Integer id_cartao) {
        this.id_cartao = id_cartao;
    }

    public Integer getId_cartao() {
        return id_cartao;
    }
    
    public void setId_plano(Integer id_plano) {
        this.id_plano = id_plano;
    }

    public Integer getId_plano() {
        return id_plano;
    }

}
