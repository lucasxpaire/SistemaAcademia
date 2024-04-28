package com.academia;

import classes.Exercicios;
import classes.Planos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Planos> listaPlanos = new ArrayList<>();
        List<Exercicios> listaExercicios = new ArrayList<>();

        int continua;
        do{
            listaPlanos.add(Planos.criarPlano());
            System.out.println("Continuar = 1 | Encerrar = 0");
            continua = sc.nextInt();
        }while(continua != 0);
        Planos.exibirPlanos(listaPlanos);

        int continua2;
        do{
            listaExercicios.add(Exercicios.criarExercicio());
            System.out.println("Continuar = 1 | Encerrar = 0");
            continua2 = sc.nextInt();
        }while(continua2 != 0);
        Exercicios.exibirExercicios(listaExercicios);
    }


}