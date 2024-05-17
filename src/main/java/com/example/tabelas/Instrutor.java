// package com.example.tabelas;

// import com.example.util.Interface;
// import com.example.util.Util;
// import com.example.dao.AlunosDao;

// import com.example.dto.CartaoDto;
// import com.example.dao.CartaoDao;

// public class Instrutor {
//     CartaoDao cartao_banco = new CartaoDao();

//     Interface menu = new Interface();

//     public void instrutor() {
//         System.out.println("Qual operacao com instrutor deseja realizar:");
//         System.out.println("1 - Cadastrar plano!");
//         System.out.println("2 - Cadastrar opções de treino!");
//         System.out.println("3 - Cadastrar treino!");
//         System.out.println("4 - Alterar opcoes de treino!");
//         System.out.println("5 - Excluir opcoes de treino!");
//         System.out.println("6 - Voltar!");

//     }

//     // Cadastrar uma ou mais opções de treino, onde cada opção de treino contém uma
//     // lista de exercícios.

//     // Para cada exercício, informar: o número de séries, o número mínimo e máximo
//     // de repetições, a carga utilizada (em kgs) e o tempo de descanso (em minutos)

//     // Alterar ou excluir opções de treino e os dados dos exercícios cadastrados.

//     Instrutor() {
//         menu.instrutor();
//         opcoesInstrutor(Util.solicitarAlternativas(1, 6, "Número da operação:"));
//     }

//     private void opcoesInstrutor(int opcao) {
//         switch (opcao) {
//             case 1:
//                 cadastrarPlano();
//                 break;
//             case 2:
//                 removerAluno();
//                 break;
//             case 3:
//                 listarAlunos();
//                 break;
//             case 4:
//                 buscarAlunoCpf();
//                 break;
//             case 5:
//                 buscarAlunoNome();
//                 break;
//             default:
//                 break;
//         }
//     }

//     private int cadastrarCartao() {
//         CartaoDto cartao = new CartaoDto();
//         cartao.setNome(Util.solicitarNome(" no cartão"));
//         cartao.setCvv(Util.solicitarNumString(" do cvv", 3, 3));
//         cartao.setData_validade(Util.solicitarData2("Data de validade do cartao"));
//         cartao.setNumero(Util.solicitarNumString(" no cartao", 13, 16));
//         int id = cartao_banco.incluir(cartao);
//         return id;
//     }

//     private void cadastrarPlano() {
//         // PLANO: PEDIR PLANO
//         String data_de_inicio = Util.solicitarData("Data de inicio");
//         int id_cartao = cadastrarCartao();

//         // Cadastrar um plano, contendo: data de início do plano, dados do cartão de
//         // crédito;
//         // Junto com lucas

//     }

//     private void removerAluno() {
//         // int cpf = Util.solicitarCpf(" do aluno a ser removido");
//         if (Util.solicitarSimNao("Deseja realmente remover o aluno:") == 1) {
//             // Conexao banco_dados = new Conexao();
//         }
//     }

//     private void listarAlunos() {
//         // PERCORRER O BANCO DE DADOS E LISTAR TODOS DA TABELA ALUNOS
//     }

//     private void buscarAlunoCpf() {
//         int cpf = Util.solicitarCpf(" do aluno");
//         // Buscar no banco de Dados
//     }

//     private void buscarAlunoNome() {
//         String nome = Util.solicitarNome(" do aluno");
//         // Buscar no banco de dados pessoas com esse nome
//     }

// }
