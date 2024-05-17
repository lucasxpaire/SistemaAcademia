package classes.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Planos;

public class planosUtils {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistemaAcademia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lucas";
    private static Connection connection;
    
    public static void listarPlanos() {
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

    public static void cadastrarPlano(){
        Planos plano = Planos.criarPlano();
        Planos.adicionarPlano(plano);
    }
}
