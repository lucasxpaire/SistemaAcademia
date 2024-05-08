//classe planos
package classes;

import com.academia.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Planos{
    private int codigo;
    private String nome;
    private float mensalidade;

    public Planos(int codigo, String nome, float mensalidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public static Planos criarPlano(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Mensalidade: ");
        float mensalidade = sc.nextFloat();
        
        return new Planos(codigo, nome, mensalidade);
    }

    public static void adicionarPlano(Planos plano){
        String url = "jdbc:postgresql://localhost:5432/sistemaAcademia";
        String user = "postgres";
        String password = "lucas";

        String sql = "INSERT INTO planos (codigo, nome, mensalidade) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, plano.codigo);
            statement.setString(2, plano.nome);
            statement.setFloat(3, plano.mensalidade);

            int linhasInseridas = statement.executeUpdate();
            if (linhasInseridas > 0) {
                System.out.println("Exercício inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercício: " + e.getMessage());
        }
    }

    public static void exibirPlanos(List<Planos> listaPlanos){
        System.out.println("Planos:");
        for(Planos plano : listaPlanos){
            System.out.println(plano.toString());
        }
    }

    @Override
    public String toString() {
        return  " " + codigo +
                " - " + nome +
                " - R$ " + mensalidade;
    }
}