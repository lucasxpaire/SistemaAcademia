package com.example.tabelas;

import com.example.util.Util;
import com.example.dao.ExerciciosUtils;
import com.example.dto.AlunoDadosDto;
import com.example.dao.AlunoDadosDao;

public class AlunoTreino {

    AlunoDadosDao banco_dados = new AlunoDadosDao();
    ExerciciosUtils banco_exercicios = new ExerciciosUtils();

    public AlunoTreino() {

    }

    // Cadastrar uma ou mais opções de treino, onde cada opção de treino contém uma
    // lista de exercícios;
    public void montar_treino() {
        int num;
        ExerciciosUtils.listarExercicios();

        System.out.println("---MONTANDO TREINO---");
        System.out.println("Digite -1 para encerrar!");
        do {
            num = Util.solicitarNum("Digite o numero do exercicio que deseja adicionar ao treino:");
            if (banco_exercicios.procurarExercicio(num) != null) {
                

            } else {
                System.out.println("Esse exercicio nao existem, forneca o numero do exercicio corretamente!\n");
            }
        } while (num != -1);
    }

    public void criarTreino() {
        String cpf = Util.solicitarCpf(" do aluno:");
        AlunoDadosDto aluno = banco_dados.buscarCpf(cpf);
        if (aluno != null) {
            String nome = Util.solicitarNome(" do treino");
            montar_treino();
        } else {
            System.out.println("Aluno nao cadastrado!\n");
        }
    }

}