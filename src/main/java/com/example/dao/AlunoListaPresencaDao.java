package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;


import com.example.dto.AlunoListaPresencaDto;
import com.example.util.Conexao;

public class AlunoListaPresencaDao {

    public boolean incluir(AlunoListaPresencaDto alunoDto) {
        String sql = "INSERT INTO ALUNO_LISTA_PRESENCA(CPF, DATA_TREINO, ID_TREINO) VALUES(?, ?, ?)";
        try (Connection conexao = Conexao.getInstance().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, alunoDto.getCpf());
            statement.setDate(2, Date.valueOf(alunoDto.getData_treino()));
            statement.setInt(3, alunoDto.getId_treino());

            int linhas_afetadas = statement.executeUpdate();
            return linhas_afetadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
