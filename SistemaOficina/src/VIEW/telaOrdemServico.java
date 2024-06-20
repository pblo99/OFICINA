/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.ClienteDAO;
import DAO.OrdemServicoDAO;
import DAO.PecaDAO;
import DTO.ClienteDTO;
import DTO.OrdemServicoDTO;
import DTO.PecaDTO;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class telaOrdemServico extends javax.swing.JFrame {

    /**
     * Creates new form telaCliente
     */
    public telaOrdemServico() {
        initComponents();

        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PecaDAO pecaDAO = new PecaDAO();

        try {
            List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();

            DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
            model.setRowCount(0);

            cmbClienteNome.addItem("Nenhum");
            cmbClienteID.addItem("---");
            cmbPecaNome.addItem("Nenhuma");
            cmbPecaID.addItem("---");
            try {
                for (OrdemServicoDTO os : listaDeOS) {
                    model.addRow(new Object[]{os.getId(), os.getCliente().getNome(), os.getPeca().getNome(), os.getStatus(), os.getQuantidade(), os.getValorPecas(), os.getValorServico(), os.getDescricao()});
                }
            } catch (Exception e) {
            }

            List<ClienteDTO> clientes = new ArrayList<>();
            clientes = clienteDAO.listarClientes();

            List<PecaDTO> pecas = new ArrayList<>();
            pecas = pecaDAO.listarPecas();

            for (ClienteDTO cliente : clientes) {
                cmbClienteNome.addItem(cliente.getNome());
                cmbClienteID.addItem(String.valueOf(cliente.getId()));
            }
            for (PecaDTO peca : pecas) {
                cmbPecaNome.addItem(peca.getNome());
                cmbPecaID.addItem(String.valueOf(peca.getId()));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar as ordens de serviço [#1]: " + e.getMessage());
        }

    }

    private void Limparcampos() {
        cmbClienteNome.setSelectedIndex(0);
        cmbClienteID.setSelectedIndex(0);
        cmbPecaNome.setSelectedIndex(0);
        cmbPecaID.setSelectedIndex(0);
        cmbQuantidadePeca.setValue(0);
        cmbValorServico.setValue(0);
        txtDescricao.setText("");
        txtMessage.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdemServico = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        cmbClienteNome = new javax.swing.JComboBox<>();
        cmbClienteID = new javax.swing.JComboBox<>();
        cmbPecaID = new javax.swing.JComboBox<>();
        cmbPecaNome = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        cmbValorServico = new javax.swing.JSpinner();
        cmbQuantidadePeca = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Ordem de Serviço");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Informações do Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Informações da Peça:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 200, 30));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, 110, 32));

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 110, 32));

        btnConcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnConcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 110, 32));

        tblOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Peça", "Status", "Quantia de Peças", "Valor das Peças", "Valor do Serviço", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdemServico.setShowGrid(true);
        tblOrdemServico.getTableHeader().setReorderingAllowed(false);
        tblOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdemServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrdemServico);
        if (tblOrdemServico.getColumnModel().getColumnCount() > 0) {
            tblOrdemServico.getColumnModel().getColumn(0).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(1).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(2).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(3).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(4).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(5).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(6).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(7).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 940, 230));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Detalhes do Serviço:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 180, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Descricao do Serviço:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, -1));

        txtMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 51));
        getContentPane().add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 420, 40));

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, 110, 32));

        cmbClienteNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbClienteNome.setToolTipText("");
        cmbClienteNome.setName("Selecione um Cliente"); // NOI18N
        cmbClienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteNomeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbClienteNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 210, 30));

        cmbClienteID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbClienteID.setToolTipText("");
        cmbClienteID.setName("Selecione um Cliente"); // NOI18N
        cmbClienteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteIDActionPerformed(evt);
            }
        });
        getContentPane().add(cmbClienteID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 210, 30));

        cmbPecaID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPecaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPecaIDActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPecaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 210, 30));

        cmbPecaNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPecaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPecaNomeActionPerformed(evt);
            }
        });
        getContentPane().add(cmbPecaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 210, 30));

        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel8.setText("Nome");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel9.setText("ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        jLabel10.setText("Nome");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        txtDescricao.setColumns(20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 940, 60));

        jLabel11.setText("(R$)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 190, 30, -1));

        jLabel12.setText("Quantia da Peça");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 150, 90, 20));

        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setMaximumSize(new java.awt.Dimension(105, 32));
        btnAtualizar.setMinimumSize(new java.awt.Dimension(105, 32));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(105, 32));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 110, 32));

        cmbValorServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbValorServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 210, 30));

        cmbQuantidadePeca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cmbQuantidadePeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 210, 30));

        jLabel13.setText("Valor do Serviço");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 190, 100, -1));

        setSize(new java.awt.Dimension(1016, 708));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // Verifica se há uma linha selecionada na tabela
        int selectedRow = tblOrdemServico.getSelectedRow();

        if (selectedRow >= 0) {

            // Cria um JOptionPane para confirmar a edição
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente atualizar esta ordem de serviço?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {

                    String cliente = cmbClienteID.getSelectedItem().toString();
                    String peca = cmbPecaID.getSelectedItem().toString();

                    String valorServico = cmbValorServico.getValue().toString();
                    String quantidadePeca = cmbQuantidadePeca.getValue().toString();
                    String descricao = txtDescricao.getText();

                    if (cliente.isEmpty() || peca.isEmpty() || quantidadePeca.isEmpty() || valorServico.isEmpty() || descricao.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (quantidadePeca.length() > 11 || valorServico.length() > 20 || descricao.length() > 100) {
                        JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int id = Integer.parseInt(tblOrdemServico.getValueAt(selectedRow, 0).toString());
                    // Atualiza a peça no banco de dados
                    OrdemServicoDAO osDAO = new OrdemServicoDAO();
                    OrdemServicoDTO os = osDAO.buscarOSPorId(id);

                    ClienteDAO clienteDAO = new ClienteDAO();
                    PecaDAO pecaDAO = new PecaDAO();

                    os.setCliente(clienteDAO.buscarClientePorId(Integer.parseInt(cliente)));
                    os.setPeca(pecaDAO.buscarPecaPorId(Integer.parseInt(peca)));

                    os.setValorServico(Double.parseDouble(valorServico));
                    os.setValorPecas(os.getPeca().getValor() * Double.parseDouble(quantidadePeca));
                    os.setQuantidade(Integer.parseInt(quantidadePeca));
                    os.setDescricao(descricao);

                    osDAO.atualizarOS(os.getId(), os);
                    Limparcampos();
                    txtMessage.setText("Ordem de serviço atualizada com sucesso!");
                    // Atualiza a tabela
                    List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
                    DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
                    model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas
                    for (OrdemServicoDTO ordem : listaDeOS) {
                        model.addRow(new Object[]{ordem.getId(), ordem.getCliente().getNome(), ordem.getPeca().getNome(), ordem.getStatus(), ordem.getQuantidade(), ordem.getValorPecas(), ordem.getValorServico(), ordem.getDescricao()});
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar isto.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma ordem de serviço para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        // Verifica se há uma linha selecionada na tabela
        int selectedRow = tblOrdemServico.getSelectedRow();

        if (selectedRow >= 0) {
            // Cria um JOptionPane para confirmar a edição
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta ordem de serviço?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {

                    int id = Integer.parseInt(tblOrdemServico.getValueAt(selectedRow, 0).toString());
                    // Atualiza a peça no banco de dados
                    OrdemServicoDAO osDAO = new OrdemServicoDAO();
                    OrdemServicoDTO os = osDAO.buscarOSPorId(id);

                    osDAO.excluirOS(os.getId());
                    Limparcampos();
                    txtMessage.setText("Ordem de serviço excluida com sucesso!");
                    // Atualiza a tabela
                    List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
                    DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
                    model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas
                    for (OrdemServicoDTO ordem : listaDeOS) {
                        model.addRow(new Object[]{ordem.getId(), ordem.getCliente().getNome(), ordem.getPeca().getNome(), ordem.getStatus(), ordem.getQuantidade(), ordem.getValorPecas(), ordem.getValorServico(), ordem.getDescricao()});
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: Esta ordem de serviço não pode ser deletada");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma ordem de serviço para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed

        // Verifica se há uma linha selecionada na tabela
        int selectedRow = tblOrdemServico.getSelectedRow();

        if (selectedRow >= 0) {
            if ("Finalizada".equals(tblOrdemServico.getValueAt(selectedRow, 3).toString())) {
                JOptionPane.showMessageDialog(null, "Esta Ordem de Serviço já foi finalizada.");
                return;
            }
            // Cria um JOptionPane para confirmar a edição
            int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente concluir esta ordem de serviço?", "Confirmar Atualização", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {

                    int id = Integer.parseInt(tblOrdemServico.getValueAt(selectedRow, 0).toString());
                    // Atualiza a peça no banco de dados
                    OrdemServicoDAO osDAO = new OrdemServicoDAO();
                    OrdemServicoDTO os = osDAO.buscarOSPorId(id);

                    os.setStatus("Finalizada");

                    osDAO.atualizarOS(os.getId(), os);
                    Limparcampos();
                    txtMessage.setText("Ordem de serviço finalizada com sucesso!");
                    // Atualiza a tabela
                    List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
                    DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
                    model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas
                    for (OrdemServicoDTO ordem : listaDeOS) {
                        model.addRow(new Object[]{ordem.getId(), ordem.getCliente().getNome(), ordem.getPeca().getNome(), ordem.getStatus(), ordem.getQuantidade(), ordem.getValorPecas(), ordem.getValorServico(), ordem.getDescricao()});
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao finalizar essa OS: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma ordem de serviço para editar.");
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void tblOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdemServicoMouseClicked

        int selectedRow = tblOrdemServico.getSelectedRow();

        if (selectedRow >= 0) {
            String ID = tblOrdemServico.getValueAt(selectedRow, 0).toString();

            OrdemServicoDAO osDAO = new OrdemServicoDAO();
            OrdemServicoDTO os = osDAO.buscarOSPorId(Integer.parseInt(ID));

            String quantidadePeca = tblOrdemServico.getValueAt(selectedRow, 4).toString();
            String valorServico = tblOrdemServico.getValueAt(selectedRow, 6).toString();
            String descricao = tblOrdemServico.getValueAt(selectedRow, 7).toString();

            cmbClienteNome.setSelectedItem(os.getCliente().getNome());
            cmbClienteID.setSelectedItem(os.getCliente().getId());

            cmbPecaNome.setSelectedItem(os.getPeca().getNome());
            cmbPecaID.setSelectedItem(os.getPeca().getId());

            cmbQuantidadePeca.setValue(Double.parseDouble(quantidadePeca));
            cmbValorServico.setValue(Double.parseDouble(valorServico));

            txtDescricao.setText(descricao);
            Limparcampos();
            txtMessage.setText("Ordem de serviço atualizada com sucesso!");
        }
    }//GEN-LAST:event_tblOrdemServicoMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String cliente = cmbClienteID.getSelectedItem().toString();
        String peca = cmbPecaID.getSelectedItem().toString();

        String quantidadePeca = cmbQuantidadePeca.getValue().toString();
        String valorServico = cmbValorServico.getValue().toString();
        String descricao = txtDescricao.getText();

        if (cliente.isEmpty() || peca.isEmpty() || quantidadePeca.isEmpty() || valorServico.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você precisa preencher todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (quantidadePeca.length() > 20 || valorServico.length() > 20 || descricao.length() > 100) {
            JOptionPane.showMessageDialog(null, "Você passou o limite de caracteres em algum campo", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cmbPecaID.getSelectedIndex() == 0 || cmbClienteID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para atualizar isto.");
            return;
        }

        OrdemServicoDTO os = new OrdemServicoDTO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PecaDAO pecaDAO = new PecaDAO();

        os.setCliente(clienteDAO.buscarClientePorId(Integer.parseInt(cliente)));
        os.setPeca(pecaDAO.buscarPecaPorId(Integer.parseInt(peca)));
        os.setStatus("Em Aberto");
        os.setValorPecas(os.getPeca().getValor() * Double.parseDouble(quantidadePeca));
        os.setValorServico(Double.parseDouble(valorServico));
        os.setQuantidade(Integer.parseInt(quantidadePeca));
        os.setDescricao(descricao);

        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        osDAO.adicionarOS(os);
        pecaDAO.baixarEstoque(os.getPeca().getId(), Integer.parseInt(quantidadePeca), descricao);
        Limparcampos();
        txtMessage.setText("Ordem de serviço criada com sucesso!");
        List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();
        DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
        model.setRowCount(0);  // Limpa a tabela antes de adicionar novas linhas
        try {
            for (OrdemServicoDTO ordem : listaDeOS) {
                model.addRow(new Object[]{ordem.getId(), ordem.getCliente().getNome(), ordem.getPeca().getNome(), ordem.getStatus(), ordem.getQuantidade(), ordem.getValorPecas(), ordem.getValorServico(), ordem.getDescricao()});
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cmbClienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteNomeActionPerformed
        try {
            int index = cmbClienteNome.getSelectedIndex();
            cmbClienteID.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbClienteNomeActionPerformed

    private void cmbClienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteIDActionPerformed
        try {
            int index = cmbClienteID.getSelectedIndex();
            cmbClienteNome.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbClienteIDActionPerformed

    private void cmbPecaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPecaNomeActionPerformed
        try {
            int index = cmbPecaNome.getSelectedIndex();
            cmbPecaID.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbPecaNomeActionPerformed

    private void cmbPecaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPecaIDActionPerformed
        try {
            int index = cmbPecaID.getSelectedIndex();
            cmbPecaNome.setSelectedIndex(index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cmbPecaIDActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        OrdemServicoDAO osDAO = new OrdemServicoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PecaDAO pecaDAO = new PecaDAO();
        Limparcampos();

        try {
            List<OrdemServicoDTO> listaDeOS = osDAO.listarOS();

            DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
            model.setRowCount(0);

            for (OrdemServicoDTO os : listaDeOS) {
                model.addRow(new Object[]{os.getId(), os.getCliente().getNome(), os.getPeca().getNome(), os.getStatus(), os.getQuantidade(), os.getValorPecas(), os.getValorServico(), os.getDescricao()});
            }

            List<ClienteDTO> clientes = new ArrayList<>();
            clientes = clienteDAO.listarClientes();

            List<PecaDTO> pecas = new ArrayList<>();
            pecas = pecaDAO.listarPecas();

            cmbClienteNome.removeAllItems();
            cmbClienteID.removeAllItems();
            cmbPecaNome.removeAllItems();
            cmbPecaID.removeAllItems();

            cmbClienteNome.addItem("Nenhum");
            cmbClienteID.addItem("---");
            cmbPecaNome.addItem("Nenhuma");
            cmbPecaID.addItem("---");

            for (ClienteDTO cliente : clientes) {
                cmbClienteNome.addItem(cliente.getNome());
                cmbClienteID.addItem(String.valueOf(cliente.getId()));
            }
            for (PecaDTO peca : pecas) {
                cmbPecaNome.addItem(peca.getNome());
                cmbPecaID.addItem(String.valueOf(peca.getId()));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar as ordens de serviço [#2]: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
                telaOrdemServico tela = new telaOrdemServico();
                tela.setTitle("Ordem de Serviço");

                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cmbClienteID;
    private javax.swing.JComboBox<String> cmbClienteNome;
    private javax.swing.JComboBox<String> cmbPecaID;
    private javax.swing.JComboBox<String> cmbPecaNome;
    private javax.swing.JSpinner cmbQuantidadePeca;
    private javax.swing.JSpinner cmbValorServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOrdemServico;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtMessage;
    // End of variables declaration//GEN-END:variables
}
