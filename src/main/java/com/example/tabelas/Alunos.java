package com.example.tabelas;

import java.util.List;


import com.example.util.Util;
import com.example.dao.AlunosDao;
import com.example.dto.AlunosDto;

public class Alunos {
    AlunosDao banco = new AlunosDao();

    public Alunos() {
        menu();
        opcoesAluno(Util.solicitarAlternativas(1, 6, "Número da operação:"));
    }

    private void menu() {
        System.out.println("Qual operação com alunos deseja realizar:");
        System.out.println("1 - Incluir aluno!");
        System.out.println("2 - Excluir aluno!");
        System.out.println("3 - Listar alunos!");
        System.out.println("4 - Buscar aluno por CPF!");
        System.out.println("5 - Buscar aluno por nome!");
        System.out.println("6 - Voltar");

    }

    private void opcoesAluno(int opcao) {
        switch (opcao) {
            case 1:
                incluirAluno();
                break;
            case 2:
                removerAluno();
                break;
            case 3:
                listarAlunos();
                break;
            case 4:
                buscarAlunoCpf();
                break;
            case 5:
                buscarAlunoNome();
                break;
            default:
                break;
        }
    }

    private void incluirAluno() {
        AlunosDto aluno = new AlunosDto();
        boolean bool;

        aluno.setNome(Util.solicitarNome(" do aluno"));
        aluno.setDataNascimento(Util.solicitarData("Data de Nascimento"));
        aluno.setCpf(Util.solicitarCpf(" do aluno"));

        bool = banco.incluir(aluno);
        if (bool) {
            System.out.println("Inserção realizada com sucesso!");
        } else {
            System.out.println("Já existe um aluno com esse CPF!");
        }
    }

    private void removerAluno() {
        String cpf = Util.solicitarCpf(" do aluno a ser removido");

        if (banco.buscarCpf(cpf) != null) {
            if (Util.solicitarSimNao("Deseja realmente remover o aluno:") == 1) {
                boolean bool = banco.remover(cpf);
                if (bool) {
                    System.out.println("Remoção realizada com sucesso!");
                } else {
                    System.out.println("Erro ao remover o aluno!");
                }
            } else {
                System.out.println("Ação cancelada!");
            }
        } else {
            System.out.println("Cpf não encontrado!");
        }
    }

    private void listarAlunos() {
        List<AlunosDto> lista_alunos = banco.listarAlunos();
        if (lista_alunos.size() > 0) {
            System.out.println("Alunos");
            for (AlunosDto aluno : lista_alunos) {
                System.out.printf("Nome:%s |", aluno.getNome());
                System.out.printf("%s |", aluno.getCpf());
                System.out.printf("%s\n", aluno.getDataNascimento());
            }
        } else {
            System.out.println("Não existe nenhum aluno cadastrado!");
        }

    }

    private void buscarAlunoNome() {
        List<AlunosDto> lista_alunos = banco.listarAlunos();
        if (lista_alunos.size() > 0) {
            String nome = Util.solicitarNome(" do aluno");
            
            lista_alunos = banco.buscarNome(nome);
            if (lista_alunos.size() > 0) {
                System.out.println("Alunos");
                for (AlunosDto aluno : lista_alunos) {
                    System.out.printf("Nome:%s |", aluno.getNome());
                    System.out.printf("%s |", aluno.getCpf());
                    System.out.printf("%s\n", aluno.getDataNascimento());
                }
            } else {
                System.out.printf("Não foi encontrado nenhum aluno com nome: %s!\n", nome);
            }
        } else {
            System.out.println("Não existe nenhum aluno cadastrado!");
        }
    }

    private void buscarAlunoCpf() {
        List<AlunosDto> lista_alunos = banco.listarAlunos();
        if (lista_alunos.size() > 0) {
            String cpf = Util.solicitarCpf(" do aluno");

            AlunosDto aluno = banco.buscarCpf(cpf);
            if (aluno != null) {
                System.out.printf("Nome:%s |", aluno.getNome());
                System.out.printf("%s |", aluno.getCpf());
                System.out.printf("%s\n", aluno.getDataNascimento());
            } else {
                System.out.printf("Não foi encontrado nenhum aluno com cpf: %s!\n", cpf);
            }
        } else {
            System.out.println("Não existe nenhum aluno cadastrado!");
        }
    }

}
