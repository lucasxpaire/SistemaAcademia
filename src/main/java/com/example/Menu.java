package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.dao.*;
import com.example.dto.*;
import com.example.tabelas.*;
import com.example.util.Util;


//import classes.Exercicios;
//import classes.Planos;

public class Menu {
    // Variáveis para a conexão com o banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/sistemaAcademia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lucas";
    private static Connection connection;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            int opcao = Util.solicitarAlternativas(1,17, "DIGITE O NUMERO QUE DESEJA REALIZAR:");

            switch (opcao) {
                case 1:
                    Alunos funcoes_alunos = new Alunos();
                // Ação: Cadastrar Aluno
                    break;
                case 2:
                    // Ação: Alterar Aluno
                    break;
                case 3:
                    // Ação: Excluir Aluno
                    break;
                case 4:
                    // Ação: Listar Alunos
                    break;
                case 5:
                    // Ação: Buscar Aluno por CPF
                    break;
                case 6:
                    // Ação: Buscar Aluno por Nome
                    break;
                    // 
                case 7:
                    // Ação: Cadastrar Plano
                    planosUtils.cadastrarPlano();
                    break;
                case 8:
                    // Ação: Listar Planos
                    planosUtils.listarPlanos();
                    break;
                case 9:
                    // Ação: Cadastrar Exercício
                    exerciciosUtils.cadastrarExercicio();
                    break;
                case 10:
                    // Ação: Listar Exercícios
                    exerciciosUtils.listarExercicios();
                    break;
                case 11:
                    // Ação: Cadastrar Treino
                    break;
                case 12:
                    // Ação: Alterar Treino
                    break;
                case 13:
                    // Ação: Excluir Treino
                    break;
                case 14:
                    // Ação: Iniciar Treino
                    break;
                case 15:
                    // Ação: Encerrar Treino
                    break;
                case 16:
                    // Ação: Relatórios
                    break;
                case 17:
                    sair = true;
                    break;
                default:
            }

            if (!sair) {
                System.out.println("\nDeseja voltar para o menu? (S/N)");
                String resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("S")) {
                    sair = true;
                }
            }
        }

        System.out.println("Programa encerrado.");
    }

    private static void exibirMenu() {
        // Implementação do método exibirMenu()
        System.out.println("------ Menu ------");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Alterar Aluno");
        System.out.println("3. Excluir Aluno");
        System.out.println("4. Listar Alunos");
        System.out.println("5. Buscar Aluno por CPF");
        System.out.println("6. Buscar Aluno por Nome");
        System.out.println("7. Criar Plano");
        System.out.println("8. Listar Planos");
        System.out.println("9. Cadastrar Exercício");
        System.out.println("10. Listar Exercícios");
        System.out.println("11. Cadastrar Treino");
        System.out.println("12. Alterar Treino");
        System.out.println("13. Excluir Treino");
        System.out.println("14. Iniciar Treino");
        System.out.println("15. Encerrar Treino");
        System.out.println("16. Relatórios");
        System.out.println("17. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // private static void conectarBancoDados() {
    //     try {
    //         connection = DriverManager.getConnection(URL, USER, PASSWORD);
    //         System.out.println("Conexão com o banco de dados estabelecida.");
    //     } catch (SQLException e) {
    //         System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    //     }
    // }

    // private static void desconectarBancoDados() {
    //     if (connection != null) {
    //         try {
    //             connection.close();
    //             System.out.println("Conexão com o banco de dados encerrada.");
    //         } catch (SQLException e) {
    //             System.out.println("Erro ao encerrar a conexão com o banco de dados: " + e.getMessage());
    //         }
    //     }
    // }

}
