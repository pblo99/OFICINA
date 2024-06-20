/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class telaCliente extends javax.swing.JFrame {

    /**
     * Creates new form telaCliente
     */
    public telaCliente() {
        initComponents();

        ClienteDAO clienteDao = new ClienteDAO();

        try {
            List<ClienteDTO> listaDeClientes = clienteDao.listarClientes();

            DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
            model.setRowCount(0);

            for (ClienteDTO cliente : listaDeClientes) {
                model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar clientes: " + e.getMessage());
        }

    }

    private void Limparcampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtMessage.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtTelefone = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Cadastro Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 60, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Telefone");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Endereço");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 80, 30));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 590, -1, -1));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, -1, -1));

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, -1, -1));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereço", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setShowGrid(true);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setResizable(false);
            tblClientes.getColumnModel().getColumn(1).setResizable(false);
            tblClientes.getColumnModel().getColumn(2).setResizable(false);
            tblClientes.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 940, 240));

        txtTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 362, 30));

        txtEndereco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 362, 30));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 362, 30));

        txtMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 450, 40));

        setSize(new java.awt.Dimension(1016, 708));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // Verifica se há uma linha selecionada na tabela
        int selectedRow = tblClientes.getSelectedRow();

        if (selectedRow >= 0) {
            // Cria um JOptionPane para confirmar a edição
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar este cliente?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {

                    String nome = txtNome.getText();
                    String endereco = txtEndereco.getText();
                    String telefone = txtTelefone.getText();

                    if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (nome.length() > 50 || endereco.length() > 50 || telefone.length() > 50) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int id = Integer.parseInt(tblClientes.getValueAt(selectedRow, 0).toString());
                    // Atualiza a peça no banco de dados
                    ClienteDAO clienteDAO = new ClienteDAO();
                    ClienteDTO objcliente = clienteDAO.buscarClientePorId(id);

                    objcliente.setNome(nome);
                    objcliente.setEndereco(endereco);
                    objcliente.setTelefone(telefone);

                    clienteDAO.atualizarCliente(objcliente.getId(), objcliente);
                    Limparcampos();
                    txtMessage.setText("Cliente atualizado com sucesso!");
                    // Atualiza a tabela
                    List<ClienteDTO> listaDeClientes = clienteDAO.listarClientes();
                    DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
                    model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas
                    for (ClienteDTO cliente : listaDeClientes) {
                        model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone()});
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar o cliente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        // Verifica se há uma linha selecionada na tabela
        int selectedRow = tblClientes.getSelectedRow();

        if (selectedRow >= 0) {
            // Cria um JOptionPane para confirmar a edição
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {

                    int id = Integer.parseInt(tblClientes.getValueAt(selectedRow, 0).toString());
                    // Atualiza a peça no banco de dados
                    ClienteDAO clienteDAO = new ClienteDAO();
                    ClienteDTO objcliente = clienteDAO.buscarClientePorId(id);

                    ClienteDAO clienteDao = new ClienteDAO();

                    clienteDao.excluirCliente(objcliente.getId());
                    Limparcampos();
                    txtMessage.setText("Cliente excluido com sucesso!");
                    // Atualiza a tabela
                    List<ClienteDTO> listaDeClientes = clienteDao.listarClientes();
                    DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
                    model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas
                    for (ClienteDTO cliente : listaDeClientes) {
                        model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone()});
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Este cliente não pode ser deletado");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(telaCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(telaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        String nome = txtNome.getText().trim();
        String endereco = txtEndereco.getText().trim();
        String telefone = txtTelefone.getText().trim();

        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Se algum campo estiver vazio, não continue com a adição
        }

        if (nome.length() > 50 || endereco.length() > 50 || telefone.length() > 50) {
            JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClienteDTO objcliente = new ClienteDTO();

        objcliente.setNome(nome);
        objcliente.setEndereco(endereco);
        objcliente.setTelefone(telefone);

        try {
            ClienteDAO clienteDao = new ClienteDAO();
            clienteDao.adicionarCliente(objcliente);
            Limparcampos();
            txtMessage.setText("Cliente cadastrado com sucesso!");

            // Atualiza a tabela
            List<ClienteDTO> listaDeClientes = clienteDao.listarClientes();
            DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
            model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas

            for (ClienteDTO cliente : listaDeClientes) {
                model.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone()});
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(telaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(telaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked

        int selectedRow = tblClientes.getSelectedRow();

        if (selectedRow >= 0) {
            String nome = tblClientes.getValueAt(selectedRow, 1).toString();
            String endereco = tblClientes.getValueAt(selectedRow, 2).toString();
            String telefone = tblClientes.getValueAt(selectedRow, 3).toString();

            txtNome.setText(nome);
            txtEndereco.setText(endereco);
            txtTelefone.setText(telefone);
            txtMessage.setText("");
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaCliente tela = new telaCliente();
                tela.setTitle("Clientes");

                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JLabel txtMessage;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
