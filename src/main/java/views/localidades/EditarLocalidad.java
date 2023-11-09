package views.localidades;

import exceptions.ValidationModelException;
import java.sql.SQLException;
import models.Localidad;
import models.Validator;
import repositories.LocalidadRepository;
import views.MessageHandler;
import views.RealTimeValidator;
import views.ValidationRule;

@SuppressWarnings("serial")
public class EditarLocalidad extends javax.swing.JDialog {

    private final LocalidadRepository localidadRepository;
    private final long idEntidad;
    private final long idMunicipio;
    private final long idLocalidad;
    private final Localidades parent;

    public EditarLocalidad(java.awt.Frame parent, LocalidadRepository localidadRepository, long idEntidad, long idMunicipio, long idLocalidad) {
        super(parent, true);
        initComponents();
        this.localidadRepository = localidadRepository;
        this.idEntidad = idEntidad;
        this.idMunicipio = idMunicipio;
        this.idLocalidad = idLocalidad;
        this.parent = (Localidades) parent;

        try {
            Localidad localidad = localidadRepository.findById(idEntidad, idMunicipio, idLocalidad);
            id.setText(String.valueOf(localidad.getId()));
            nombre.setText(localidad.getNombre());
        } catch (SQLException | ValidationModelException ex) {
            MessageHandler.showErrorMessage(ex.getMessage());
        }

        RealTimeValidator.addValidation(id, new ValidationRule(this::esIdValido, idError));
        RealTimeValidator.addValidation(nombre, new ValidationRule(Validator::esNombreValido, nombreError));
    }

    private boolean esIdValido(String id) throws ValidationModelException {
        try {
            Validator.esIdValido(Long.parseLong(id));
        } catch (ValidationModelException ex) {
            throw ex;
        } catch (NumberFormatException ex) {
            throw new ValidationModelException("El id debe ser un numero entero positivo");
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tituloLbl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cancelarBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        nombrePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idError = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nombrePanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombreError1 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        nombrePanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombreError = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar proveedor");
        setMinimumSize(new java.awt.Dimension(550, 200));
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloLbl.setFont(new java.awt.Font("Lato Heavy", 1, 40)); // NOI18N
        tituloLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLbl.setText("Editar localidad");
        jPanel2.add(tituloLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 560, 60));

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelarBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        cancelarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelarBtn.setText("Cancelar");
        cancelarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });
        jPanel6.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 120, 30));

        editBtn.setBackground(new java.awt.Color(129, 140, 248));
        editBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Editar");
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel6.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 140, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 530, 50));

        nombrePanel.setBackground(new java.awt.Color(254, 254, 254));
        nombrePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Id");
        jLabel2.setPreferredSize(new java.awt.Dimension(250, 16));
        nombrePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        idError.setBackground(new java.awt.Color(254, 254, 254));
        idError.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        idError.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        idError.setOpaque(true);
        nombrePanel.add(idError, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 400, 20));

        id.setToolTipText("");
        id.setActionCommand("<Not Set>");
        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        id.setMargin(new java.awt.Insets(2, 10, 2, 6));
        id.setOpaque(true);
        nombrePanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 400, 40));

        jPanel2.add(nombrePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 560, -1));

        nombrePanel1.setBackground(new java.awt.Color(254, 254, 254));
        nombrePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");
        jLabel3.setPreferredSize(new java.awt.Dimension(250, 16));
        nombrePanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        nombreError1.setBackground(new java.awt.Color(254, 254, 254));
        nombreError1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nombreError1.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        nombreError1.setOpaque(true);
        nombrePanel1.add(nombreError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 400, 20));

        nombre1.setToolTipText("");
        nombre1.setActionCommand("<Not Set>");
        nombre1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        nombre1.setMargin(new java.awt.Insets(2, 10, 2, 6));
        nombre1.setOpaque(true);
        nombrePanel1.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 400, 40));

        nombrePanel2.setBackground(new java.awt.Color(254, 254, 254));
        nombrePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre");
        jLabel4.setPreferredSize(new java.awt.Dimension(250, 16));
        nombrePanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        nombreError.setBackground(new java.awt.Color(254, 254, 254));
        nombreError.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        nombreError.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        nombreError.setOpaque(true);
        nombrePanel2.add(nombreError, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 400, 20));

        nombre.setToolTipText("");
        nombre.setActionCommand("<Not Set>");
        nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        nombre.setMargin(new java.awt.Insets(2, 10, 2, 6));
        nombre.setOpaque(true);
        nombrePanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 400, 40));

        nombrePanel1.add(nombrePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 560, -1));

        jPanel2.add(nombrePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 560, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 250));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try {
            Localidad localidad = new Localidad(idEntidad, idMunicipio, Long.valueOf(id.getText()), nombre.getText().trim());
            localidadRepository.update(idEntidad, idMunicipio, idLocalidad, localidad);

            dispose();
            parent.loadEntries();
            MessageHandler.showSuccessMessage("Localidad actualizada", null);
        } catch (SQLException | ValidationModelException ex) {
            MessageHandler.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_editBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField id;
    private javax.swing.JLabel idError;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombre1;
    private javax.swing.JLabel nombreError;
    private javax.swing.JLabel nombreError1;
    private javax.swing.JPanel nombrePanel;
    private javax.swing.JPanel nombrePanel1;
    private javax.swing.JPanel nombrePanel2;
    private javax.swing.JLabel tituloLbl;
    // End of variables declaration//GEN-END:variables
}
