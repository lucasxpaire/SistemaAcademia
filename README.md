Com base na análise dos arquivos enviados (código fonte Java, configurações do Maven e scripts SQL), elaborei um arquivo `README.md` completo para o seu projeto **SistemaAcademia**.

Ele descreve as funcionalidades, tecnologias e, o mais importante, como configurar o banco de dados PostgreSQL necessário para rodar o sistema.

-----

# Sistema de Gerenciamento de Academia

Um sistema em Java desenvolvido para auxiliar no gerenciamento de uma academia. O software permite o cadastro de alunos, instrutores, gerenciamento de planos, criação de fichas de treino personalizadas e geração de relatórios de frequência e evolução de carga.

O sistema opera via interface de linha de comando (CLI), oferecendo menus interativos para navegação.

## 📋 Funcionalidades

O sistema é dividido em módulos principais acessíveis via menu:

### 1\. Gestão de Alunos

  * Incluir, Excluir e Listar alunos.
  * Buscar aluno por CPF ou Nome.
  * Armazena dados pessoais e data de nascimento.

### 2\. Planos e Pagamentos

  * Cadastro de planos (mensais, anuais, etc.).
  * Associação de alunos a planos.
  * Cadastro de cartão de crédito para simulação de pagamento.
  * Cancelamento de planos.

### 3\. Gestão de Exercícios

  * Cadastro e remoção de exercícios.
  * Listagem de exercícios disponíveis com detalhes dos músculos ativados.

### 4\. Gestão de Treinos (Módulo Instrutor)

  * Criação de treinos personalizados para alunos.
  * Adição de exercícios ao treino com definições de:
      * Séries, Repetições (mínimas e máximas).
      * Carga (kg) e Tempo de descanso.
  * Alteração e exclusão de treinos.
  * Ajuste de cargas de exercícios específicos.

### 5\. Área do Aluno

  * Visualização dos treinos atribuídos.
  * Realização de treino (registra presença automaticamente).
  * Visualização da evolução de cargas.

### 6\. Relatórios

  * **Relatório de Presença:** Lista os dias que o aluno treinou em um determinado intervalo de datas.
  * **Evolução de Carga:** Histórico de aumento de carga por exercício.

-----

## 🛠️ Tecnologias Utilizadas

  * **Linguagem:** Java (Compatível com JDK 1.7 ou superior)
  * **Gerenciamento de Dependências:** Apache Maven
  * **Banco de Dados:** PostgreSQL
  * **Driver JDBC:** PostgreSQL JDBC Driver (v42.7.3)
  * **Testes:** JUnit 4.11

-----

## ⚙️ Configuração e Instalação

### Pré-requisitos

1.  Ter o **Java JDK** instalado.
2.  Ter o **Maven** instalado.
3.  Ter o **PostgreSQL** instalado e rodando.

### 1\. Configuração do Banco de Dados

O sistema utiliza um banco de dados PostgreSQL chamado `sistema_academia`. Você deve criá-lo e rodar o script de criação das tabelas.

1.  Crie o banco de dados:
    ```sql
    CREATE DATABASE sistema_academia;
    ```
2.  Execute o script `banco_de_dados.sql` (encontrado na raiz do projeto) para criar as tabelas e sequências necessárias (`aluno_dados`, `aluno_treino`, `exercicios`, etc.).

### 2\. Configuração da Conexão

Antes de rodar, verifique se as credenciais do banco de dados no arquivo `src/main/java/com/example/util/Conexao.java` correspondem às da sua máquina local:

```java
// Arquivo: src/main/java/com/example/util/Conexao.java
private static final String URL = "jdbc:postgresql://localhost:5432/sistema_academia";
private static final String USER = "postgres";
private static final String PASSWORD = "kise"; // Altere "kise" para a sua senha do PostgreSQL
```

### 3\. Compilando e Executando

No terminal, dentro da pasta raiz do projeto:

```bash
# Compilar o projeto e baixar dependências
mvn clean install

# Executar a aplicação (exemplo via plugin exec do maven ou rodando a classe Main diretamente)
java -cp target/classes:target/dependency/* com.example.Main
```

*Observação: Se estiver usando uma IDE (VS Code, IntelliJ, Eclipse), basta abrir o arquivo `src/main/java/com/example/Main.java` e clicar em "Run".*

-----

## 🗄️ Estrutura do Banco de Dados

O sistema persiste dados nas seguintes tabelas principais:

  * `ALUNO_DADOS`: Informações cadastrais.
  * `ALUNO_PLANO`: Vínculo entre aluno e plano.
  * `CARTAO_DE_CREDITO`: Dados financeiros.
  * `EXERCICIOS`: Biblioteca de exercícios.
  * `ALUNO_TREINO` e `ALUNO_TREINO_EXERCICIO`: Definições dos treinos e fichas.
  * `ALUNO_LISTA_PRESENCA`: Histórico de check-ins.
  * `ALUNO_TREINO_EXERCICIO_CARGA`: Histórico de evolução.

-----

## ✒️ Autores

  * **Lucas**
  * **Leandro**
