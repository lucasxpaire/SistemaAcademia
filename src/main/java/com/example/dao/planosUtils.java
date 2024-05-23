package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.dto.CartaoDto;
import com.example.tabelas.Planos;
import com.example.util.Conexao;

public class PlanosUtils {

    Conexao connection;

    public int incluir(CartaoDto cartao) {
        Connection conexao = null;
        int id_cartao = -1;
        try {
            conexao = Conexao.getInstance().getConnection();
            if (conexao != null) {

                String sql = "INSERT INTO CARTAO_DE_CREDITO(NUMERO, NOME, VALIDADE, CVV) VALUES(?, ?, ?, ?)";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1, cartao.getNumero());
                statement.setString(2, cartao.getNome().toUpperCase(Locale.ENGLISH));
                statement.setString(3, cartao.getData_validade());
                statement.setString(4, cartao.getCvv());
                statement.executeUpdate();
                conexao.close();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    id_cartao = resultSet.getInt(1);
                }
                return id_cartao;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return id_cartao;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id_cartao;
    }

    public static Planos plano(int codigo) {

        Connection conexao = null;
        Planos plano = null;
        try {
            conexao = Conexao.getInstance().getConnection();
            if (conexao != null) {

                String sql = "SELECT * FROM PLANOS WHERE codigo = ?";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setInt(1, codigo);
                statement.executeQuery();
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int code = resultSet.getInt("codigo");
                    String nome = resultSet.getString("nome");
                    float mensalidade = resultSet.getFloat("mensalidade");
                    plano = new Planos(code, nome, mensalidade);
                }
                conexao.close();
                return plano;
            }
        } catch (Exception e) {
            System.out.println("ERRO?");
            return plano;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return plano;
    }

    public static void listarPlanos() {
        List<Planos> listaPlanos = new ArrayList<>();
        // Obter os planos do banco de dados
        Connection conexao = null;
        try {
            conexao = Conexao.getInstance().getConnection();
            if (conexao != null) {

                Statement statement = conexao.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT codigo, nome, mensalidade FROM planos");
                while (resultSet.next()) {
                    int codigo = resultSet.getInt("codigo");
                    String nome = resultSet.getString("nome");
                    float mensalidade = resultSet.getFloat("mensalidade");
                    Planos plano = new Planos(codigo, nome, mensalidade);
                    listaPlanos.add(plano);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectarBancoDados(conexao);
        }
        Planos.exibirPlanos(listaPlanos);
        // Exibir os planos
    }

    public static void adicionarPlano(Planos plano) {

        String sql = "INSERT INTO planos (codigo, nome, mensalidade) VALUES (?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, plano.getCodigo());
            statement.setString(2, plano.getNome());
            statement.setFloat(3, plano.getMensalidade());

            int linhasInseridas = statement.executeUpdate();
            if (linhasInseridas > 0) {
                System.out.println("Plano inserido com sucesso!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao inserir plano: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir plano: " + e.getMessage());
        } finally {
            Conexao.desconectarBancoDados(connection);
        }

    }

    public static void cadastrarPlano() {
        Planos plano = Planos.criarPlano();
        adicionarPlano(plano);
    }
}
