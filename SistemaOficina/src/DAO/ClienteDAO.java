package DAO;

import DAO.ConexaoDAO;
import DTO.ClienteDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConexaoDAO().connectaBD();
    }

    public void adicionarCliente(ClienteDTO cliente) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO clientes(nome, endereco, telefone) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
  
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ClienteDTO cliente = new ClienteDTO();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));
                    clientes.add(cliente);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public ClienteDTO buscarClientePorId(int id) {
        ClienteDTO cliente = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new ClienteDTO();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public void atualizarCliente(int clienteId, ClienteDTO cliente) {
        String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, clienteId);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
     
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
