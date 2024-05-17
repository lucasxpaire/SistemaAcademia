package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.util.Conexao;
import com.example.dto.AlunosDto;

public class AlunosDao {
    public boolean incluir(AlunosDto alunoDto) {
        Connection conexao = null;
        AlunosDto aluno = null;
        aluno = buscarCpf(alunoDto.getCpf());
        if (aluno == null) {
            try {
                conexao = Conexao.getInstance().getConnection();
                String sql = "INSERT INTO ALUNOS(CPF, NOME, DATA_NASCIMENTO) VALUES(?, ?, ?)";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1, alunoDto.getCpf());
                statement.setString(2, alunoDto.getNome().toUpperCase(Locale.ENGLISH));
                statement.setString(3, alunoDto.getDataNascimento());
                statement.execute();
                conexao.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                if (conexao != null) {
                    try {
                        conexao.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            return false;
        }
    }

    public boolean remover(String cpf) {
        Connection conexao = null;
        try {
            conexao = Conexao.getInstance().getConnection();
            String sql = "DELETE FROM ALUNOS WHERE CPF = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.execute();
            conexao.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<AlunosDto> listarAlunos() {
        List<AlunosDto> lista_alunos = new ArrayList<AlunosDto>();
        Connection conexao = null;
        try {
            conexao = Conexao.getInstance().getConnection();
            String sql = "SELECT * FROM ALUNOS";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                AlunosDto aluno = new AlunosDto();
                aluno.setCpf(resultset.getString("CPF"));
                aluno.setNome(resultset.getString("NOME"));
                //
                aluno.setDataNascimento(resultset.getString("DATA_NASCIMENTO"));

                lista_alunos.add(aluno);
            }
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista_alunos;
    }

    public List<AlunosDto> buscarNome(String nome) {
        List<AlunosDto> lista_alunos = new ArrayList<AlunosDto>();
        try {
            Connection conexao = Conexao.getInstance().getConnection();
            String sql = "SELECT * FROM ALUNOS WHERE NOME = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome.toUpperCase(Locale.ENGLISH));

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                AlunosDto aluno = new AlunosDto();
                aluno.setCpf(resultset.getString("CPF"));
                aluno.setNome(resultset.getString("NOME"));
                aluno.setDataNascimento(resultset.getString("DATA_NASCIMENTO"));

                lista_alunos.add(aluno);
            }
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista_alunos;
    }

    public AlunosDto buscarCpf(String cpf) {
        AlunosDto aluno = null;
        Connection conexao = null;
        try {
            conexao = Conexao.getInstance().getConnection();
            if (conexao != null) {
                String sql = "SELECT * FROM ALUNOS WHERE CPF = ?";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1, cpf);
                ResultSet resultset = statement.executeQuery();
                if (resultset.next()) {
                    aluno = new AlunosDto();
                    aluno.setCpf(resultset.getString("CPF"));
                    aluno.setNome(resultset.getString("NOME"));
                    aluno.setDataNascimento(resultset.getString("DATA_NASCIMENTO"));
                }
                resultset.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return aluno;
    }
}
