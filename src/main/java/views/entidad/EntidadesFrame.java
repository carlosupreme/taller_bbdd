package views.entidad;

import exceptions.ValidationModelException;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Entidad;
import repositories.EntidadRepository;
import views.MessageHandler;
import views.tabla.TableActionCellEditor;
import views.tabla.TableActionCellRender;
import views.tabla.TableActionEvent;

@SuppressWarnings("serial")
public final class EntidadesFrame extends javax.swing.JFrame {

    private final EntidadRepository entidadRepository;
    private final DefaultTableModel model;

    public EntidadesFrame() {
        initComponents();
        setLocationRelativeTo(null);

        this.entidadRepository = new EntidadRepository();
        model = (DefaultTableModel) table.getModel();
        loadEntries();

        TableActionEvent actionEvent = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                long id = (long) model.getValueAt(row, 0);
                new EditarEntidadModal(EntidadesFrame.this, entidadRepository, id).setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }

                long id = (long) model.getValueAt(row, 0);
                try {
                    Entidad entidadToDelete = entidadRepository.findById(id);
                    boolean confirmed = MessageHandler.showConfirmMessage("¿Estás seguro de que desea eliminar la entidad '" + entidadToDelete.getNombre() + "' ?", "Eliminar permanentemente");

                    if (confirmed) {
                        entidadRepository.delete(id);
                        loadEntries();
                        MessageHandler.showSuccessMessage("Entidad eliminada correctamente", null);
                    }
                } catch (SQLException | ValidationModelException ex) {
                    MessageHandler.showErrorMessage(ex.getMessage());
                }
            }

            @Override
            public void onShow(int row) {
                long id = (long) model.getValueAt(row, 0);
                try {
                    new VerEntidadModal(EntidadesFrame.this, entidadRepository.findById(id)).setVisible(true);
                } catch (SQLException | ValidationModelException ex) {
                    MessageHandler.showErrorMessage(ex.getMessage());
                }
            }
        };

        table.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(actionEvent));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        crearBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entidades");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        crearBtn.setBackground(new java.awt.Color(129, 140, 248));
        crearBtn.setFont(new java.awt.Font("Lato Heavy", 1, 14)); // NOI18N
        crearBtn.setForeground(new java.awt.Color(255, 255, 255));
        crearBtn.setText("Agregar");
        crearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearBtn.setMaximumSize(new java.awt.Dimension(158, 27));
        crearBtn.setMinimumSize(new java.awt.Dimension(158, 27));
        crearBtn.setPreferredSize(new java.awt.Dimension(75, 25));
        crearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel2.add(crearBtn, gridBagConstraints);

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 280, 60));

        jLabel1.setFont(new java.awt.Font("Lato Heavy", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entidades");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 60));

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel4.setLayout(new java.awt.CardLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre ", "Acciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(50);
        table.setShowGrid(false);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        jPanel4.add(jScrollPane2, "card2");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 790, -1));

        setSize(new java.awt.Dimension(799, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        new CrearEntidadModal(this, entidadRepository).setVisible(true);
    }//GEN-LAST:event_crearBtnActionPerformed

    public void loadEntries() {
        model.setRowCount(0);
        try {
            entidadRepository.findAll().forEach(entidad -> {
                Object[] row = new Object[3];
                row[0] = entidad.getId();
                row[1] = entidad.getNombre();
                row[2] = "";
                model.addRow(row);
            });
        } catch (SQLException | ValidationModelException ex) {
            MessageHandler.showErrorMessage(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
