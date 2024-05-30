package com.example.util;
import com.example.dao.AlunoDadosDao;
import com.example.dao.AlunoPlanoDao;
import com.example.dao.AlunoTreinoDao;
import com.example.dao.ExerciciosUtils;
import com.example.dao.PlanosUtils;
import com.example.dto.AlunoPlanoDto;
import com.example.dto.AlunoTreinoDto;
import com.example.dto.AlunoTreinoExercicioDto;
import com.example.tabelas.AlunoDados;
import com.example.tabelas.AlunoPlano;
import com.example.tabelas.AlunoTreino;
import com.example.tabelas.Exercicios;
import com.example.tabelas.Planos;

public class Menu {
    
    public void exibirMenuPrincipal(){
        System.out.println("------ Menu Principal ------");
        System.out.println("1. Alunos");
        System.out.println("2. Planos");
        System.out.println("3. Exercícios");
        System.out.println("4. Instrutor -> Alunos Cadastrados");
        System.out.println("5. Relatórios");
        System.out.println("6. Sair");
        System.out.print("Escolha um tópico: ");
    }

    public void menuAlunos() {
        boolean sair = false;
        AlunoDados alunoDados = new AlunoDados();
        AlunoDadosDao alunoDadosDao = new AlunoDadosDao();
        while (!sair) {
            System.out.println("------ Menu Alunos ------");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Alterar Dados do Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar Aluno por CPF");
            System.out.println("6. Buscar Aluno por Nome");
            System.out.println("7. Voltar ao Menu Principal");
            int opcao = Util.solicitarAlternativas(1, 7, "DIGITE O NUMERO QUE DESEJA REALIZAR:");
            
            switch (opcao) {
                case 1:
                    alunoDados.incluirAluno();
                    break;
                case 2:
                    // Ação: Alterar Dados do Aluno
                    // Adicione a funcionalidade de alterar dados do aluno aqui
                    break;
                case 3:
                    alunoDados.removerAluno();
                    break;
                case 4:
                    alunoDados.listarAlunos();
                    break;
                case 5:
                    alunoDados.buscarAlunoCpf();
                    break;
                case 6:
                    alunoDados.buscarAlunoNome();
                    break;
                case 7:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void menuPlanos() {
        boolean sair = false;
        while (!sair) {
            System.out.println("------ Menu Planos ------");
            System.out.println("1. Criar Plano");
            System.out.println("2. Listar Planos");
            System.out.println("3. Voltar ao Menu Principal");
            int opcao = Util.solicitarAlternativas(1, 3, "DIGITE O NUMERO QUE DESEJA REALIZAR:");

            switch (opcao) {
                case 1:
                    Planos.cadastrarPlano();
                    break;
                case 2:
                    Planos.exibirPlanos();
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void menuExercicios() {
        boolean sair = false;
        while (!sair) {
            System.out.println("------ Menu Exercícios ------");
            System.out.println("1. Cadastrar Exercício");
            System.out.println("2. Listar Exercícios");
            System.out.println("3. Voltar ao Menu Principal");
            int opcao = Util.solicitarAlternativas(1, 3, "DIGITE O NUMERO QUE DESEJA REALIZAR:");

            switch (opcao) {
                case 1:
                    Exercicios.cadastrarExercicio();
                    break;
                case 2:
                    Exercicios.exibirExercicios();
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void menuInstrutorAlunosCadastrados() {
        boolean sair = false;
        AlunoPlano alunoPlano = new AlunoPlano();
        AlunoTreino alunoTreino = new AlunoTreino();
    
        while (!sair) {
            System.out.println("------ Menu Instrutor -> Alunos Cadastrados ------");
            System.out.println("1. Cadastrar Plano para Aluno");
            System.out.println("2. Cadastrar Treino para Aluno");
            System.out.println("3. Alterar ou Excluir Treino do Aluno");
            System.out.println("4. Voltar ao Menu Principal");
            int opcao = Util.solicitarAlternativas(1, 4, "DIGITE O NUMERO QUE DESEJA REALIZAR:");
    
            switch (opcao) {
                case 1:
                    // Ação: Cadastrar Plano para Aluno
                    alunoPlano.cadastrarPlano();
                    break;
                case 2:
                    // Ação: Cadastrar Treino para Aluno
                    alunoTreino.cadastrarTreino();
                    break;
                case 3:
                    // Ação: Alterar ou Excluir Treino do Aluno
                    alunoTreino.alterarTreino();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public void menuRelatorios() {
        boolean sair = false;
        while (!sair) {
            System.out.println("------ Menu Relatórios ------");
            System.out.println("1. Relatório de Alunos");
            System.out.println("2. Relatório de Planos");
            System.out.println("3. Relatório de Exercícios");
            System.out.println("4. Voltar ao Menu Principal");
            int opcao = Util.solicitarAlternativas(1, 4, "DIGITE O NUMERO QUE DESEJA REALIZAR:");

            switch (opcao) {
                case 1:
                    // Ação: Relatório de Alunos
                    break;
                case 2:
                    // Ação: Relatório de Planos
                    break;
                case 3:
                    // Ação: Relatório de Exercícios
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
