/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Pablo
 */
public class telaOficina extends javax.swing.JFrame {

    /**
     * Creates new form telaOficina
     */
    public telaOficina() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOrdemServico = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnPecas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oficina");
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 504, 187));
        setMaximumSize(new java.awt.Dimension(504, 187));
        setMinimumSize(new java.awt.Dimension(504, 187));
        setPreferredSize(new java.awt.Dimension(504, 187));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOrdemServico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOrdemServico.setText("Ordem de Serviço");
        btnOrdemServico.setMaximumSize(new java.awt.Dimension(180, 32));
        btnOrdemServico.setMinimumSize(new java.awt.Dimension(180, 32));
        btnOrdemServico.setPreferredSize(new java.awt.Dimension(180, 32));
        btnOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdemServicoActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrdemServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 240, -1));

        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClientes.setText("Estoque de Peças");
        btnClientes.setMaximumSize(new java.awt.Dimension(180, 32));
        btnClientes.setMinimumSize(new java.awt.Dimension(180, 32));
        btnClientes.setPreferredSize(new java.awt.Dimension(180, 32));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 240, -1));

        btnPecas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPecas.setText("Clientes");
        btnPecas.setMaximumSize(new java.awt.Dimension(180, 32));
        btnPecas.setMinimumSize(new java.awt.Dimension(180, 32));
        btnPecas.setPreferredSize(new java.awt.Dimension(180, 32));
        btnPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPecasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 240, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Oficina");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        setSize(new java.awt.Dimension(504, 224));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdemServicoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaOrdemServico tela = new telaOrdemServico();
                tela.setTitle("Ordem de Servico");

                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnOrdemServicoActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaPeca tela = new telaPeca();
                tela.setTitle("Peças");

                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPecasActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaCliente tela = new telaCliente();
                tela.setTitle("Clientes");

                tela.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnPecasActionPerformed

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
                telaOficina tela = new telaOficina();
                tela.setTitle("Oficina");

                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnOrdemServico;
    private javax.swing.JButton btnPecas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}