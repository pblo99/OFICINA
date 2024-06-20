package DAO;

import DTO.OrdemServicoDTO;
import DTO.PecaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    private Connection connection;

    public OrdemServicoDAO() {
        this.connection = new ConexaoDAO().connectaBD();
    }

    public void adicionarOS(OrdemServicoDTO os) {
        String sql = "INSERT INTO ordens_servico (cliente_id, peca_id, status, descricao, valor_peca, valor_servico, quantidade_peca) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, os.getCliente().getId());
            stmt.setInt(2, os.getPeca().getId());
            stmt.setString(3, os.getStatus());
            stmt.setString(4, os.getDescricao());
            stmt.setDouble(5, os.getValorPecas());
            stmt.setDouble(6, os.getValorServico());
            stmt.setInt(7, os.getQuantidade());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OrdemServicoDTO> listarOS() {
        List<OrdemServicoDTO> os = new ArrayList<>();
        String sql = "SELECT * FROM ordens_servico";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemServicoDTO objOS = new OrdemServicoDTO();
                ClienteDAO clienteDAO = new ClienteDAO();
                PecaDAO pecaDAO = new PecaDAO();
                objOS.setId(rs.getInt("id"));
                objOS.setCliente(clienteDAO.buscarClientePorId(rs.getInt("cliente_id")));
                objOS.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                objOS.setStatus(rs.getString("status"));
                objOS.setDescricao(rs.getString("descricao"));
                objOS.setValorPecas(rs.getDouble("valor_peca"));
                objOS.setValorServico(rs.getDouble("valor_servico"));
                objOS.setQuantidade(rs.getInt("quantidade_peca"));
                os.add(objOS);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return os;
    }

    public void atualizarOS(int osID, OrdemServicoDTO os) {
        String sql = "UPDATE ordens_servico SET cliente_id = ?, peca_id = ?, status = ?, descricao = ? , valor_peca = ? , valor_servico = ? , quantidade_peca = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, os.getCliente().getId());
            stmt.setInt(2, os.getPeca().getId());
            stmt.setString(3, os.getStatus());
            stmt.setString(4, os.getDescricao());
            stmt.setDouble(5, os.getValorPecas());
            stmt.setDouble(6, os.getValorServico());
            stmt.setInt(7, os.getQuantidade());
            stmt.setInt(8, osID);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirOS(int osID) {
        String sql = "DELETE FROM ordens_servico WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, osID);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OrdemServicoDTO buscarOSPorId(int osID) {
        OrdemServicoDTO os = null;
        String sql = "SELECT * FROM ordens_servico WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, osID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                os = new OrdemServicoDTO();
                ClienteDAO clienteDAO = new ClienteDAO();
                PecaDAO pecaDAO = new PecaDAO();
                os.setId(rs.getInt("id"));
                os.setCliente(clienteDAO.buscarClientePorId(rs.getInt("cliente_id")));
                os.setPeca(pecaDAO.buscarPecaPorId(rs.getInt("peca_id")));
                os.setStatus(rs.getString("status"));
                os.setDescricao(rs.getString("descricao"));
                os.setValorPecas(rs.getLong("valor_peca"));
                os.setValorServico(rs.getLong("valor_servico"));
                os.setQuantidade(rs.getInt("quantidade_peca"));

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return os;
    }

}
