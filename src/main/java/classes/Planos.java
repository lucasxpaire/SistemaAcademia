package classes;

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