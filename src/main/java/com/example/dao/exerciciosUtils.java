package com.example.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.ExerciciosDto;
import com.example.util.Conexao;

public class ExerciciosUtils {

    public List<ExerciciosDto> listaExercicios() {
        List<ExerciciosDto> listaExercicios = new ArrayList<>();

        String sql = "SELECT numero, nome, musculosativos FROM exercicios";

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultset = statement.executeQuery()) {

            while (resultset.next()) {
                ExerciciosDto exercicio = new ExerciciosDto();
                exercicio.setNome(resultset.getString("NOME"));
                exercicio.setNumero(resultset.getInt("NUMERO"));
                exercicio.setMusculosAtivos(resultset.getString("MUSCULOSATIVOS"));

                listaExercicios.add(exercicio);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao listar exercicios: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao listar exercicios: " + e.getMessage());
            e.printStackTrace();
        }

        return listaExercicios;
    }

    public boolean adicionarExercicio(ExerciciosDto exercicio) {

        String sql = "INSERT INTO exercicios (nome, musculosativos) VALUES (?, ?)";

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql);) {

            statement.setString(1, exercicio.getNome());
            statement.setString(2, exercicio.getMusculosAtivos());

            int linhasInseridas = statement.executeUpdate();
            return linhasInseridas > 0;
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        }
        return false;
    }

    public ExerciciosDto procurarNomeExercicio(String nome) {
        String sql = "SELECT * FROM EXERCICIOS WHERE NOME = ?";
        ExerciciosDto exercicio = null;

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);

            try (ResultSet resultset = statement.executeQuery()) {
                if (resultset.next()) {
                    exercicio = new ExerciciosDto();
                    exercicio.setNome(resultset.getString("NOME"));
                    exercicio.setNumero(resultset.getInt("NUMERO"));
                    exercicio.setMusculosAtivos(resultset.getString("MUSCULOSATIVOS"));
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        }
        return exercicio;
    }

    public ExerciciosDto procurarExercicio(int numero) {
        String sql = "SELECT * FROM EXERCICIOS WHERE NUMERO = ?";
        ExerciciosDto exercicio = null;

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, numero);

            try (ResultSet resultset = statement.executeQuery()) {
                if (resultset.next()) {
                    exercicio = new ExerciciosDto();
                    exercicio.setNome(resultset.getString("NOME"));
                    exercicio.setNumero(resultset.getInt("NUMERO"));
                    exercicio.setMusculosAtivos(resultset.getString("MUSCULOSATIVOS"));
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        }
        return exercicio;
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM EXERCICIOS WHERE NUMERO = ?";

        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            int linhas_afetadas = statement.executeUpdate();
            return linhas_afetadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

        //inserir exercicios no banco de dados através de arquivo
    public static void inserirExercicios(List<ExerciciosDto> exercicios) {
        String sql = "INSERT INTO exercicios (nome, musculosativos, numero) VALUES (?, ?, ?)";
        Connection conexao = null;

        try {
            conexao = Conexao.getInstance().getConnection();
            PreparedStatement statement = conexao.prepareStatement(sql);
            
            for (ExerciciosDto exercicio : exercicios) {
                statement.setString(1, exercicio.getNome());
                statement.setString(2, exercicio.getMusculosAtivos());
                statement.setInt(3, exercicio.getNumero());
    
                statement.executeUpdate();
            }
            System.out.println("Exercícios inseridos com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao inserir exercicio: " + e.getMessage());
        } finally {
            Conexao.desconectarBancoDados(conexao);
        }
    }

    private static List<ExerciciosDto> lerExerciciosCSV(String caminho) {
        List<ExerciciosDto> exercicios = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(";");
                if (dados.length == 3) {
                    String nome = dados[0].trim();
                    String musculosAtivos = dados[1].trim();
                    int numero = Integer.parseInt(dados[2].trim());
                    ExerciciosDto exercicio = new ExerciciosDto();
                    exercicio.setNome(nome);
                    exercicio.setMusculosAtivos(musculosAtivos);
                    exercicio.setNumero(numero);
                    exercicios.add(exercicio);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        return exercicios;
    }

    public static void inicializarExerciciosCSV(String caminho){
        List<ExerciciosDto> exercicios = lerExerciciosCSV(caminho);    
        inserirExercicios(exercicios);
    }

}
