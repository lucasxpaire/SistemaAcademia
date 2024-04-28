package com.academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemaAcademia", "postgres", "lucas");
            if (conexao != null) {
                System.out.println("Conexão bem-sucedida!");
                Statement stm = conexao.createStatement();
                //insereDados(stm);
                consultaDados(stm);
                conexao.close();
            } else {
                System.out.println("Falha na conexão!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void consultaDados(Statement stm) {
        String sql = "SELECT nome, cpf, datanascimento FROM alunos";
        try {
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                System.out.println("Nome: " + result.getString("nome") + ", CPF: " + result.getInt("cpf") + ", Data de Nascimento: " + result.getString("datanascimento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insereDados(Statement stm){
        String sql = "insert into alunos (Nome) valeus ('Pedro')";
        try {
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
