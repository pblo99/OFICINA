package DAO;

import DTO.PecaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PecaDAO {
    private Connection connection;

    public PecaDAO() {
        this.connection = new ConexaoDAO().connectaBD();
    }

    public void adicionarPeca(PecaDTO peca) {
        String sql = "INSERT INTO pecas (nome, descricao, quantidade, valor, codigo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getDescricao());
            stmt.setInt(3, peca.getQuantidade());
            stmt.setDouble(4, peca.getValor());
            stmt.setLong(5, peca.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PecaDTO> listarPecas() {
        List<PecaDTO> pecas = new ArrayList<>();
        String sql = "SELECT * FROM pecas";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PecaDTO peca = new PecaDTO();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getInt("quantidade"));
                peca.setValor(rs.getDouble("valor"));
                peca.setCodigo(rs.getLong("codigo"));
                pecas.add(peca);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pecas;
    }

    public void atualizarPeca(int pecaId, PecaDTO peca) {
        String sql = "UPDATE pecas SET nome = ?, descricao = ?, quantidade = ?, valor = ?, codigo = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getDescricao());
            stmt.setInt(3, peca.getQuantidade());
            stmt.setDouble(4, peca.getValor());
            stmt.setLong(5, peca.getCodigo());
            stmt.setInt(6, pecaId);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPeca(int pecaId) {
        String sql = "DELETE FROM pecas WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pecaId);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PecaDTO buscarPecaPorId(int id) {
        PecaDTO peca = null;
        String sql = "SELECT * FROM pecas WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                peca = new PecaDTO();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getInt("quantidade"));
                peca.setValor(rs.getDouble("valor"));
                peca.setCodigo(rs.getLong("codigo"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peca;
    }

    // Novo método para baixar o estoque e registrar a solicitação de baixa
    public void baixarEstoque(int pecaId, int quantidade, String motivo) {
        String sqlBaixaEstoque = "UPDATE pecas SET quantidade = quantidade - ? WHERE id = ?";
        String sqlRegistrarBaixa = "INSERT INTO solicitacoes_baixa (id_peca, quantidade, motivo) VALUES (?, ?, ?)";
        try {
            connection.setAutoCommit(false); // Inicia a transação

            // Atualiza o estoque
            PreparedStatement stmtBaixaEstoque = connection.prepareStatement(sqlBaixaEstoque);
            stmtBaixaEstoque.setInt(1, quantidade);
            stmtBaixaEstoque.setInt(2, pecaId);
            stmtBaixaEstoque.execute();
            stmtBaixaEstoque.close();

            // Registra a solicitação de baixa
            PreparedStatement stmtRegistrarBaixa = connection.prepareStatement(sqlRegistrarBaixa);
            stmtRegistrarBaixa.setInt(1, pecaId);
            stmtRegistrarBaixa.setInt(2, quantidade);
            stmtRegistrarBaixa.setString(3, motivo);
            stmtRegistrarBaixa.execute();
            stmtRegistrarBaixa.close();

            connection.commit(); // Confirma a transação
        } catch (SQLException e) {
            try {
                connection.rollback(); // Desfaz a transação em caso de erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true); // Restaura o modo de commit automático
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
