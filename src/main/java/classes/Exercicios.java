package classes;

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
