package com.academia;

import com.academia.Menu;
import classes.Exercicios;
import classes.Planos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(); // Crie uma instância da classe Menu
        menu.main(new String[0]); // Chame o método main() do menu
    }

}

/*
        String url = "jdbc:postgresql://localhost:5432/sistemaAcademia";
        String user = "postgres";
        String password = "lucas";
        Scanner sc = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
            
            // Aqui você pode inserir seus dados
            // Exemplo: insertData(connection);
            Exercicios exercicio = Exercicios.criarExercicio();
            Exercicios.adicionarExercicio(exercicio);
            Planos plano = Planos.criarPlano();
            Planos.adicionarPlano(plano);
            
            connection.close(); // Fechar a conexão quando terminar
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally{
            sc.close();
        }
 */
