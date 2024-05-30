package com.example;

import com.example.dao.ExerciciosUtils;
import com.example.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean sair = false;
        //Dependendo de como tu clonou o caminho pode ser assim: src/main/exercicios.csv
        String caminhoArquivo = "SistemaAcademia/src/main/exercicios.csv";
        ExerciciosUtils.inicializarExerciciosCSV(caminhoArquivo);

        while (!sair) {
            menu.exibirMenuPrincipal();
            int opcao = Util.solicitarAlternativas(1, 7, "DIGITE O NUMERO QUE DESEJA REALIZAR:");

            switch (opcao) {
                case 1:
                    menu.menuAlunos();
                    break;
                case 2:
                    menu.menuPlanos();
                    break;
                case 3:
                    menu.menuExercicios();
                    break;
                case 4:
                    menu.menuInstrutorAlunosCadastrados();
                    break;
                case 5:
                    menu.menuRelatorios();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        System.out.println("Programa encerrado.");
    }
}
