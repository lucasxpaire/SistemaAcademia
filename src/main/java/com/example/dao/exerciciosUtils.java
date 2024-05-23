package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.AlunoDadosDto;
import com.example.tabelas.Exercicios;
import com.example.util.Conexao;

public class ExerciciosUtils {

    // private static Connection connection;
    public static void listarExercicios() {
        List<Exercicios> listaExercicios = new ArrayList<>();

        String sql = "SELECT numero, nome, musculosativos FROM exercicios";

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int numero = resultSet.getInt("numero");
                String nome = resultSet.getString("nome");
                String musculosAtivos = resultSet.getString("musculosativos");
                Exercicios exercicio = new Exercicios(numero, nome, musculosAtivos);
                listaExercicios.add(exercicio);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao listar exercicios: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao listar exercicios: " + e.getMessage());
            e.printStackTrace();
        }

        Exercicios.exibirExercicios(listaExercicios);
    }

    public static void adicionarExercicio(Exercicios exercicio) {

        // Conexao connection;

        String sql = "INSERT INTO exercicios (numero, nome, musculosativos) VALUES (?, ?, ?)";

        Connection conexao = null;
        try {
            conexao = Conexao.getInstance().getConnection();
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, exercicio.getNumero());
            statement.setString(2, exercicio.getNome());
            statement.setString(3, exercicio.getMusculosAtivos());

            int linhasInseridas = statement.executeUpdate();
            if (linhasInseridas > 0) {
                System.out.println("Exercício inserido com sucesso!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } finally {
            Conexao.desconectarBancoDados(conexao);
        }
    }

    public Exercicios procurarExercicio(int numero) {
        String sql = "SELECT * FROM EXERCICIOS WHERE NUMERO = ?";
        Exercicios exercicio = null;

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, numero);

            try (ResultSet resultset = statement.executeQuery()) {
                // Processar o resultado da consulta
                if (resultset.next()) {
                    int num = resultset.getInt("NUMERO");
                    String nome = resultset.getString("NOME");
                    String musculos_ativos = resultset.getString("MUSCULOSATIVOS");

                    exercicio = new Exercicios(num, nome, musculos_ativos);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        }
        return exercicio;
    }

    // public AlunoDadosDto buscarCpf(String cpf){
    // AlunoDadosDto aluno = null;

    // return aluno;
    // }

    public static void cadastrarExercicio() {
        Exercicios exercicio = Exercicios.criarExercicio();
        Exercicios.adicionarExercicio(exercicio);
    }
}
