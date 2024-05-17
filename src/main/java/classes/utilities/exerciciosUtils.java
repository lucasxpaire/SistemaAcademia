package classes.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Exercicios;

public class exerciciosUtils {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistemaAcademia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lucas";
    private static Connection connection;
    
    public static void listarExercicios() {
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

    public static void cadastrarExercicio(){
        Exercicios exercicio = Exercicios.criarExercicio();
        Exercicios.adicionarExercicio(exercicio);
    }
}
