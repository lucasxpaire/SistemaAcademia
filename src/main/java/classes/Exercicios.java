//classe exercicios
package classes;

import com.academia.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Exercicios {
    private int numero;
    private String nome, musculosAtivos;

    public Exercicios(int numero, String nome, String musculosAtivos){
        this.numero = numero;
        this.nome = nome;
        this.musculosAtivos = musculosAtivos;
    }

    public static Exercicios criarExercicio(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Musculos Ativos: ");
        String musculosAtivos = sc.nextLine();
        

        return new Exercicios(numero, nome, musculosAtivos);
    }

    public static void adicionarExercicio(Exercicios exercicio){
        String url = "jdbc:postgresql://localhost:5432/sistemaAcademia";
        String user = "postgres";
        String password = "lucas";

        String sql = "INSERT INTO exercicios (numero, nome, musculosativos) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, exercicio.numero);
            statement.setString(2, exercicio.nome);
            statement.setString(3, exercicio.musculosAtivos);

            int linhasInseridas = statement.executeUpdate();
            if (linhasInseridas > 0) {
                System.out.println("Exercício inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir exercício: " + e.getMessage());
        }
    }

    public static void exibirExercicios(List<Exercicios> listaExercicios){
        System.out.println("Exercícios:");
        for(Exercicios exercicios : listaExercicios){
            System.out.println(exercicios.toString());
        }
    }

    @Override
    public String toString() {
        return  " " + numero +
                " - " + nome +
                " - " + musculosAtivos;
    }
}
