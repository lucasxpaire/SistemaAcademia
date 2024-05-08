package com.academia;

import classes.Exercicios;
import classes.Planos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    // Variáveis para a conexão com o banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/sistemaAcademia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lucas";
    private static Connection connection;

    public static void main(String[] args) {
        conectarBancoDados();

        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
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
                case 7:
                    // Ação: Cadastrar Plano
                    break;
                case 8:
                    // Ação: Listar Planos
                    listarPlanos();
                    break;
                case 9:
                    // Ação: Cadastrar Exercício
                    break;
                case 10:
                    // Ação: Listar Exercícios
                    listarExercicios();
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
                    System.out.println("Opção inválida!");
            }

            if (!sair) {
                System.out.println("\nDeseja voltar para o menu? (S/N)");
                String resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("S")) {
                    sair = true;
                }
            }
        }

        desconectarBancoDados();
        scanner.close();
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
        System.out.println("7. Cadastrar Plano");
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

    private static void listarPlanos() {
        List<Planos> listaPlanos = new ArrayList<>();
        // Obter os planos do banco de dados
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT codigo, nome, mensalidade FROM planos")) {
            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                float mensalidade = resultSet.getFloat("mensalidade");
                Planos plano = new Planos(codigo, nome, mensalidade);
                listaPlanos.add(plano);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter os planos do banco de dados: " + e.getMessage());
        }
        // Exibir os planos
        Planos.exibirPlanos(listaPlanos);
    }

    private static void listarExercicios() {
        List<Exercicios> listaExercicios = new ArrayList<>();
        // Obter os exercícios do banco de dados
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT numero, nome, musculosativos FROM exercicios")) {
            while (resultSet.next()) {
                int numero = resultSet.getInt("numero");
                String nome = resultSet.getString("nome");
                String musculosAtivos = resultSet.getString("musculosativos");
                Exercicios exercicio = new Exercicios(numero, nome, musculosAtivos);
                listaExercicios.add(exercicio);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter os exercícios do banco de dados: " + e.getMessage());
        }
        // Exibir os exercícios
        Exercicios.exibirExercicios(listaExercicios);
    }


    private static void conectarBancoDados() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void desconectarBancoDados() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados encerrada.");
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}
